package com.package2104;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午3:23
 **/
public class Test04 implements Runnable {
    private int sleeptime;

    public Test04(int sleeptime) {
        this.sleeptime = sleeptime;
    }

    @Override
    public void run() {
        System.out.println("睡眠时间："+sleeptime);
        try {
            TimeUnit.MILLISECONDS.sleep(sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
