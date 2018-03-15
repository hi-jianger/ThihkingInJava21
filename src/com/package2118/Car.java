package com.package2118;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:13
 **/
public class Car {
    /**
     * 表示涂蜡-抛光的过程
     */
    private Boolean waxOn=false;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    /**
     * 涂蜡,需要唤醒抛光的线程
     */
    public  void waxed(){
        lock.lock();
        try {
            waxOn = true;
            System.out.println("涂蜡结束，唤醒抛光任务");
//            notifyAll();
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 抛光，需要唤醒涂蜡的线程
     */
    public  void buffed(){
        lock.lock();
        try {
            waxOn = false;
            System.out.println("抛光结束，唤醒涂蜡任务");
//            notifyAll();
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 等待涂蜡
     * @throws InterruptedException
     */
    public  void waitingForWaxed() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false) {
                System.out.println("等待涂蜡，抛光任务被挂起");
//                wait();
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    /**
     * 等待抛光
     * @throws InterruptedException
     */
    public  void waitingForBuffed() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true) {//涂蜡没有涂好，false就是涂蜡涂好
                System.out.println("等待抛光，涂蜡任务呗挂起");
//                wait();
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}
