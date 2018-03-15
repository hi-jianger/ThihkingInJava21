package com.package2126;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 下午2:21
 **/
public class TestMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ChopStick chopSticks = new ChopStick(3);
//        for (int i = 0; i < 5; i++) {
//            chopSticks[i] = new ChopStick();
//        }

        for (int i = 0; i < 10; i++) {
//            if (i < 4)
//                executorService.execute(new Philosopher(chopSticks[i], chopSticks[(i + 1) % 5], i));
//            else
//                executorService.execute(new Philosopher(chopSticks[0], chopSticks[i], i));
            executorService.execute(new Philosopher(chopSticks,i));

        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("按下回车结束程序");
        System.in.read();
        executorService.shutdownNow();
    }
}
