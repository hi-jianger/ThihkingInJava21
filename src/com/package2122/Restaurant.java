package com.package2122;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianger
 * @Date 2018/2/27 上午10:27
 **/
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Chef chef = new Chef(this, lock);
    Waitter waitter = new Waitter(this, lock);
    BusyBoy busyBoy = new BusyBoy(this, lock);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitter);
        executorService.execute(busyBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
