package com.package2130;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author jianger
 * @Date 2018/3/15 下午12:43
 **/
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                q.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束消费任务");
    }
}
