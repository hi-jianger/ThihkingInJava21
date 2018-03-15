package com.package2129;

import java.util.concurrent.DelayQueue;

/**
 * @author jianger
 * @Date 2018/3/15 上午11:39
 **/
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> queue;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
        System.out.println("构造器");
    }

    @Override
    public void run() {
        try{
            System.out.println("run方法进来没有");
            while (!Thread.interrupted()){
                queue.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束了DelayedTaskConsumer");
    }
}
