package com.package2119;

/**
 * @author jianger
 * @Date 2018/2/26 下午9:07
 **/
public class WaitNotify {

    public  synchronized void waitMthod(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notifyMethod(){
        notifyAll();
    }
}
