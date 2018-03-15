package com.package2118;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午8:33
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Car car=new Car();

        executorService.execute(new WaxedOff(car));

        executorService.execute(new WaxedOn(car));
        executorService.shutdownNow();
//        TimeUnit.SECONDS.sleep(1);

    }
}
