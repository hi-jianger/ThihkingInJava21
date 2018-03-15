package com.package2119;

import kotlin.jvm.Synchronized;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:57
 **/
public class Runnable1 implements Runnable {
//   private Runnable1 waitNotify;
//
//    public Runnable1(Runnable1 waitNotify) {
//        this.waitNotify = waitNotify;
//    }

    @Override
    public void run() {
         synchronized (this) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("任务1被唤醒啦");

         }
    }
}
