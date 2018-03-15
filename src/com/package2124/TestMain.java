package com.package2124;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 上午11:48
 **/
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 花生黄油
         */
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();

        /**
         * 果酱
         */
        ToastQueue dryQueueJam = new ToastQueue(),
                butterQueueJam = new ToastQueue(),
                finishedQueueJam = new ToastQueue();


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        TimeUnit.SECONDS.sleep(1);
        executorService.execute(new Toaster(dryQueueJam));
        executorService.execute(new Butterer(dryQueue, butterQueue));
        executorService.execute(new Butterer(dryQueueJam,butterQueueJam));
        executorService.execute(new Jammer(butterQueue, finishedQueue));
        executorService.execute(new Jammer(butterQueueJam,finishedQueueJam));
        executorService.execute(new Eater(finishedQueue));
        executorService.execute(new Eater(finishedQueueJam));

        TimeUnit.SECONDS.sleep(10);
        executorService.shutdownNow();
    }
}
