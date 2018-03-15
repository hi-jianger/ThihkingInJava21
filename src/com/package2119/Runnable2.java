package com.package2119;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:59
 **/
public class Runnable2 implements Runnable {
    private Runnable1 waitNotify;

    public Runnable2(Runnable1 waitNotify) {
        this.waitNotify = waitNotify;
    }

    @Override
    public void run() {
        synchronized (waitNotify) {


            waitNotify.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        WaitNotify waitNotify=new WaitNotify();
        Runnable1 runnable1 = new Runnable1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(runnable1);
        TimeUnit.SECONDS.sleep(1);
        executorService.execute(new Runnable2(runnable1));

        TimeUnit.SECONDS.sleep(1);
        executorService.shutdown();
    }
}
