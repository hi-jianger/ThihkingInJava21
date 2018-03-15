package com.package2103;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author jianger
 * @Description Callable：get()以及get()之后的方法都会等到线程执行结束，可以用于闭锁操作
 * @Date 2018/2/23 下午2:49
 **/
public class Test03Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(executorService.submit(new Fibonacci(i)));
        }

        TimeUnit.SECONDS.sleep(10);

        arrayList.forEach(fs -> {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("test 是否会get之前执行");
//        Fibonacci fibonacci = new Fibonacci(2);
//        fibonacci.getSum();

    }
}
