package com.package2102;

import com.package2101.Test01;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午2:21
 **/
public class Test02Main {

    /**
     * cachedThreadPool
     *
     * @param args public static void main(String[] args) {
     *             ExecutorService executorService= Executors.newCachedThreadPool();
     *             for (int i=0;i<5;i++){
     *             executorService.execute(new Test01());
     *             }
     *             executorService.shutdown();
     *             }
     */

    /**
     * fixedThreadPool
     *
     * @param args public static void main(String[] args) {
     *             ExecutorService executorService = Executors.newFixedThreadPool(5);
     *             for (int i = 0; i < 5; i++) {
     *             executorService.execute(new Test01());
     *             }
     *             executorService.shutdown();
     *             }
     */

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Test01());
        }
        executorService.shutdown();
    }


}
