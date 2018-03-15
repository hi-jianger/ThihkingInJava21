package com.package2130;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/15 下午12:38
 **/
public class PrioritizedTaskProducer implements Runnable {
    private Random random=new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService executorService;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService executorService) {
        this.queue = queue;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            /**
             * 做出让步，但不一定会接受让步
             */
            Thread.yield();
        }
        try{
            for (int i = 0; i <10 ; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }

            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(executorService));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束PrioritizedTaskProducer");
    }
}
