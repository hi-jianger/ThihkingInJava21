package com.package2123;

import java.util.concurrent.BlockingDeque;

/**
 * @author jianger
 * @Date 2018/2/27 下午2:27
 **/
public class LiftOffRunner implements Runnable {

    private BlockingDeque<LightOff> rockets;

    public LiftOffRunner(BlockingDeque<LightOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LightOff lightOff){
        rockets.add(lightOff);
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                LightOff lightOff=rockets.take();
                lightOff.run();

            }
        } catch (InterruptedException e) {
            System.out.println("被take()唤醒");
        }
        System.out.println("任务结束");
    }
}
