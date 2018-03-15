package com.package2127;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 下午3:17
 **/
public class TaskPortion implements Runnable {

    private static  int counter=0;

    private static final int id=counter++;

    private static Random random=new Random(47);

    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println("等待睡眠中");
    }
}
