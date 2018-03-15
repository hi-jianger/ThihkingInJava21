package com.package2122;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author jianger
 * @Date 2018/2/27 上午10:36
 **/
public class Waitter implements Runnable {
    private Restaurant restaurant;
    private Lock lock;
    private Condition condition;

    public Waitter(Restaurant restaurant,Lock lock) {
        this.restaurant = restaurant;
        this.lock=lock;
        this.condition=this.lock.newCondition();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                synchronized (this) {
                    lock.lock();
                    try {
                        while (restaurant.meal == null) {

//                            wait();
                            condition.await();
                        }
                    }finally {
                        lock.unlock();
                    }
//                }
                    //消费
                    System.out.println("waitter 得到 "+restaurant.meal);
                    restaurant.chef.getLock().lock();
                    try {
//                    synchronized (restaurant.chef) {
                        System.out.println("消费者开始消费食物,并唤醒生产者生产食物");
                        restaurant.meal = null;
//                        restaurant.chef.notifyAll();
                        restaurant.chef.getCondition().signalAll();
//                    }
                    }finally {
                        restaurant.chef.getLock().unlock();
                    }
                    restaurant.busyBoy.getLock().lock();
                    try {

//                    synchronized (restaurant.busyBoy){
                        System.out.println("通知busyBoy清理");
//                        restaurant.busyBoy.notifyAll();
                        restaurant.busyBoy.getCondition().signalAll();
//                    }
                    }finally {
                        restaurant.busyBoy.getLock().unlock();
                    }


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("haha");
    }
}
