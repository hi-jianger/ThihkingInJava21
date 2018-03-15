package com.package2107;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 上午10:20
 **/
public class ThreadMethod {
    private Thread thread;
    private String name;

    private static final int F_0 = 0;
    private static final int F_1 = 1;


    public int getFN(int m) {
        int sum = 0;
        if (m == 0) {
            return F_0;
        }

        if (m == 1) {
            return F_1;
        }

//        System.out.println(getFN(m - 2));
//        System.out.println(getFN(m - 1));
//        System.out.println();
        return getFN(m - 1) + getFN(m - 2);
    }

    public int getSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += getFN(i);
        }
        return sum;
    }

    public ThreadMethod(String name) {
        this.name = name;
    }

    public Future<String> runTask(int n) {
        if (thread == null) {
            thread = new Thread(name) {
                private int sum;

                @Override
                public void run() {
                    sum = getSum(n);
                    System.out.println(sum);

                }

                @Override
                public String toString() {
                    return getName() + "总和为：" + sum;
                }
            };
            thread.start();
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        return (Future<String>) executorService.submit(thread);
    }
}
