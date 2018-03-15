package com.package2105;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午3:53
 **/
public class BackFromBackThread implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建的所有线程都为后台线程
        ExecutorService executorService= Executors.newCachedThreadPool(new BackThread());
        for (int i=0;i<10;i++){
            executorService.execute(new BackFromBackThread());
        }

        System.out.println("所有的后台线程开始了：");
        TimeUnit.MILLISECONDS.sleep(500);

    }
}
