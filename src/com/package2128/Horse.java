package com.package2128;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jianger
 * @Date 2018/3/4 下午3:52
 **/
public class Horse implements Runnable {
    public static int counter=0;
    public  final int id=counter++;

    private int strides=0;

    private static Random random=new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier cyclicBarrier) {
          barrier=cyclicBarrier;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    strides+=random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Horse{" +
                "strides=" + id +
                '}';
    }

    public String trickets(){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <getStrides() ; i++) {
            stringBuilder.append("*");
        }
//        System.out.println(counter
//        +"counter");
        stringBuilder.append(id);
//        System.out.println(id);
        return stringBuilder.toString();
    }
}
