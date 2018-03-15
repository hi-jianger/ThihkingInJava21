package com.package2118;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:26
 **/
public class WaxedOn implements Runnable {
    private Car car;

    public WaxedOn(Car car) {
        this.car = car;
    }



    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println("涂蜡开始");
            try {
//                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffed();//等待抛光
            } catch (InterruptedException e) {
                System.out.println("涂蜡任务被中断");
            }
            System.out.println("涂蜡任务结束");
        }
    }
}
