package com.package2117;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/25 下午2:17
 **/
public class SleepBlocked implements Runnable {


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);

        } catch (InterruptedException e) {
            System.out.println("SleepBlocked的InterruptedException");
        }
        System.out.println("正在结束SleepBlocked任务");
    }
}
