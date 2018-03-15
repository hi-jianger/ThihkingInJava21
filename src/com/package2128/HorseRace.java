package com.package2128;

import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 下午4:00
 **/
public class HorseRace {

    static final int FINISH_LINE=75;
    private List<Horse>  horses=new ArrayList<>();

    private ExecutorService executorService= Executors.newCachedThreadPool();

    private CyclicBarrier barrier;

    public HorseRace(List<Horse> horses, ExecutorService executorService, CyclicBarrier barrier) {
        this.horses = horses;
        this.executorService = executorService;
        this.barrier = barrier;
    }

    public HorseRace(int nHorse,final int pause) throws InterruptedException {
        barrier=new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                StringBuilder s=new StringBuilder();
                for (int i = 0; i <FINISH_LINE ; i++) {
                    s.append("=");
                }
                System.out.println(s);
//                System.out.println(horses.size()+"size");
                horses.forEach(h->{
                    System.out.println(h.trickets());
                });
//                System.out.println("检测进来没");
                for (Horse horse:horses){
                    if (horse.getStrides()>=FINISH_LINE){
                        System.out.println(horse+"won!");
                        executorService.shutdownNow();
                        return;
                    }
                }
            }
        });
//        TimeUnit.SECONDS.sleep(10);
        for (int i = 0; i < nHorse; i++) {
//            System.out.println("谁先");
            Horse horse=new Horse(barrier);
//            System.out.println(Horse.id);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int nHorse=7;
        int pause=200;
//        System.out.println(args.length);
        if (args.length>0){
            int n=new Integer(args[0]);
//            System.out.println(args[0]);
            nHorse=n>0?n:pause;
        }

        if (args.length>1){
            int p=new Integer(args[1]);
            pause=p>-1?p:pause;
        }

        new HorseRace(nHorse,pause);
    }
}
