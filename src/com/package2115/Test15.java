package com.package2115;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianger
 * @Date 2018/2/25 上午11:02
 **/
public class Test15 {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
    private Object object = new Object();

    public void test1() {
        lock1.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("我是test1()的" + i);
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void test2() {
        lock2.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("我是test2()的" + i);
                    Thread.yield();
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            lock2.unlock();
            }

    }

    public void test3() {
        lock3.lock();
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println("我是test3()的" + i);
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}
