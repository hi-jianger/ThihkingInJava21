package com.package2108;

/**
 * @author jianger
 * @Description 直接继承Thread，Java单继承；构造器启动线程
 * @Date 2018/2/24 上午11:21
 **/
public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    public void run(){
        try {
            sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
