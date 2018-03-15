package com.package2124;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 上午11:29
 **/
public class Toaster implements Runnable {
    /**
     * 需要执行的类似于多线程的任务
     */
    private ToastQueue toastQueue;
    private int count=0;
    private Random random=new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
                Toast toast=new Toast(count++);
                System.out.println("Toaster任务的toast"+toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster任务被中断");
        }
        System.out.println("Toaster任务结束");
    }
}
