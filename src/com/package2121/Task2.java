package com.package2121;

/**
 * @author jianger
 * @Date 2018/2/27 上午9:36
 **/
public class Task2 implements Runnable {
    static Blocker blocker=new Blocker();
    @Override
    public void run() {
       blocker.waitingCall();
    }
}
