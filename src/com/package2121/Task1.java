package com.package2121;

/**
 * @author jianger
 * @Date 2018/2/27 上午9:31
 **/
public class Task1 implements Runnable {
    static Blocker blocker=new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}
