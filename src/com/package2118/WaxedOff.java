package com.package2118;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:30
 **/
public class WaxedOff implements Runnable {

    private Car car;

    public WaxedOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println("抛光开始");
            try {
                car.waitingForWaxed();//等待涂蜡结束
//                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();

            } catch (InterruptedException e) {
                System.out.println("抛光任务被中断");
            }
            System.out.println("抛光任务结束");
        }
    }
}
