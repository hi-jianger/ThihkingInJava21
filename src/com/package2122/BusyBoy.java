package com.package2122;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jianger
 * @Date 2018/2/27 上午11:17
 **/
public class BusyBoy implements Runnable {
    private Restaurant restaurant;
    private Lock lock;
    private Condition condition;

    public BusyBoy(Restaurant restaurant, Lock lock) {
        this.restaurant = restaurant;
        this.lock = lock;
        this.condition = this.lock.newCondition();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                TimeUnit.SECONDS.sleep(1);
                synchronized (this) {
//                    while (restaurant.meal == null) {
                    wait();
//                    }
                }
                System.out.println("清理桌子");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
