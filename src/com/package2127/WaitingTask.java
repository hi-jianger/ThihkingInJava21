package com.package2127;

import java.util.concurrent.CountDownLatch;

/**
 * @author jianger
 * @Date 2018/3/4 下午3:22
 **/
public class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch countDownLatch;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("结束等待");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
