package com.package2130;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author jianger
 * @Date 2018/3/15 下午12:42
 **/
public class PrioritizedTaskDemo {

    public static void main(String[] args) {
        Random random=new Random(47);
        ExecutorService executorService= Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue=new PriorityBlockingQueue<>();

        executorService.execute(new PrioritizedTaskProducer(queue,executorService));
        executorService.execute(new PrioritizedTaskConsumer(queue));
    }
}
