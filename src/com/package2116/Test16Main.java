package com.package2116;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/25 下午12:04
 **/
public class Test16Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new XRayCounter(i));
        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("预期的总和："+XRayCounter.counter());
    }
}
