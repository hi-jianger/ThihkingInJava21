package com.package2108;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 上午11:29
 **/
public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
