package com.package2122;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianger
 * @Date 2018/2/27 上午10:19
 **/
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;
    private Lock lock;
    private Condition condition;

    public Chef(Restaurant restaurant,Lock lock) {
        this.restaurant = restaurant;
        this.lock=lock;
        this.condition=this.lock.newCondition();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            synchronized (this){
                while (restaurant.meal!=null){
                    try {
                        //等待食物被消费
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //生产食物
            if (++count==10){
                System.out.println("食物已经生产够了,结束任务");
                restaurant.executorService.shutdownNow();
                return;
            }

            synchronized (restaurant.waitter){
                System.out.println("开始生产食物，并唤醒消费者");
                restaurant.meal=new Meal(count);
                //唤醒等待的消费者
                restaurant.waitter.notifyAll();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
