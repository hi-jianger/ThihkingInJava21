package com.package2121;

/**
 * @author jianger
 * @Date 2018/2/27 上午9:30
 **/
public class Blocker  {

    synchronized void waitingCall(){
        while(!Thread.interrupted()){
            try {
                wait();
                System.out.println(Thread.currentThread()+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void prod(){
        notify();
    }

    synchronized void prodAll(){
        notifyAll();
    }
}
