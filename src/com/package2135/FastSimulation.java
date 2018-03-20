package com.package2135;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jianger
 * @Date 2018/3/17 下午4:05
 **/
public class FastSimulation {
    static final int N_ELENMENTS=30;
    static final int N_GENES=30;
    static final int N_EVOLVERS=50;
    static final AtomicInteger[][] GRID=new AtomicInteger[N_ELENMENTS][N_GENES];
    static final Random random=new Random(47);
    static class Evolver implements Runnable{

        @Override
        public void run() {
            while(!Thread.interrupted()){
               int element=random.nextInt(N_ELENMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int prvious=element-1;
                    if (prvious<0)
                        prvious=N_ELENMENTS-1;
                    int next=element+1;
                    if (next>=N_ELENMENTS)
                        next=0;
                    int oldvalue=GRID[element][i].get();
                    int newvalue=oldvalue+GRID[prvious][i].get()+GRID[next][i].get();
                    newvalue /=3;
                    if (!GRID[element][i].compareAndSet(oldvalue,newvalue)){
                        System.out.println("old value changed from "+oldvalue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i <N_ELENMENTS ; i++) {
            for (int j = 0; j <N_GENES ; j++) {
                GRID[i][j]=new AtomicInteger(random.nextInt(1000));
            }
        }
        for (int i=0;i<N_EVOLVERS;i++){
            executorService.execute(new Evolver());
        }
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
