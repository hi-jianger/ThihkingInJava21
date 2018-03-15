package com.package2121;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/27 上午9:41
 **/
public class NotifyVSNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        /**
         * Task1和Task2等待的不是同一个锁
         */
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task1());
        }
        executorService.execute(new Task2());
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod=true;
            @Override
            public void run() {
               if (prod){
                   System.out.println("notify()");
                   Task1.blocker.prod();
                   prod=false;
               }else {
                   System.out.println("notifyAll()");
                   Task1.blocker.prodAll();
                   prod=true;
               }
            }
        },400,400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer 结束");
        TimeUnit.MILLISECONDS.sleep(500);
        Task2.blocker.prodAll();
        System.out.println("Task2 blocker.prodAll()");
        TimeUnit.MILLISECONDS.sleep(200);
        executorService.shutdownNow();
        System.out.println("所有任务关闭");

    }
}
