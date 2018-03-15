package com.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jianger
 * @Date 2018/2/26 下午3:08
 **/
public class TestCAS {
    public static void main(String[] args) {
        Atomic atomic=new Atomic();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(atomic);
            thread.start();
        }
    }
}

class Atomic implements Runnable{
    AtomicInteger atomicInteger=new AtomicInteger(0);


    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println(increment());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int increment(){
        return atomicInteger.getAndIncrement();
    }
}

