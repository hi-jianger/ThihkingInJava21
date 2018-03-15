package com.package2101;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午1:54
 **/
public class Test01 implements Runnable {

    public void startThread() {
        System.out.println("start the thread");
    }

    public void entThread() {
        System.out.println("end the thread");
    }


    @Override
    public void run() {
        startThread();
        for (int i = 0; i < 3; i++) {
            System.out.println("print something");
            Thread.yield();
        }
        entThread();
    }
}
