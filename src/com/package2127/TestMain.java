package com.package2127;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianger
 * @Date 2018/3/4 下午3:26
 **/
public class TestMain {
    static final int SIZE=100;
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
        CountDownLatch countDownLatch=new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(countDownLatch));
        }

        /**
         * 闭锁，锁住要执行任务的部分，直到Count数为0，不然的话，await部分不会执行
         */
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new TaskPortion(countDownLatch));
        }

        executorService.shutdown();
    }
}
