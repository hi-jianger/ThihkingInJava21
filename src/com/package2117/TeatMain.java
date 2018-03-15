package com.package2117;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/25 下午2:34
 **/
public class TeatMain {

    public static void test(Runnable runnable) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(runnable);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("开始中断 " + runnable.getClass().getName());
            future.cancel(true);
            System.out.println("中断结束 " + runnable.getClass().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test(new SleepBlocked());
        test(new IOBlocaked(System.in));
        test(new SynchronizedBlocked());
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("结束main()");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
