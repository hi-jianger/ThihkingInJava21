package com.package2111;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 共享：多个线程访问同一个对象的变量。同一个对象：简单理解为new Object();
 *
 * @author jianger
 * @Date 2018/2/24 下午3:10
 **/
public class Test11Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<>();
        Test11 test11 = new Test11();
        for (int i = 0; i < 10; i++) {
            executorService.execute(test11);
//            results.add(executorService.submit(test11));
        }
        executorService.shutdown();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终结果：sum "+test11.getSum()+"content "+test11.getContent());

    }
}
