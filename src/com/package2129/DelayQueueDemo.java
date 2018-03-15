package com.package2129;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianger
 * @Date 2018/3/15 上午11:41
 **/
public class DelayQueueDemo {

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(random.nextInt(50)));
        }
        queue.add(new DelayedTask.EndSentinel(50, executorService));
        executorService.execute(new DelayedTaskConsumer(queue));
    }
}
