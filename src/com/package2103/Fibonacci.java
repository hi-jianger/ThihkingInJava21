package com.package2103;

import java.util.concurrent.Callable;

/**
 * @author jianger
 * @Description 裴波纳锲数列
 * @Date 2018/2/23 下午2:36
 **/
public class Fibonacci implements Callable<String> {

    private static final int F_0 = 0;
    private static final int F_1 = 1;

    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

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

    public int getSum() {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += getFN(i);
        }
        return sum;
    }


    @Override
    public String call() throws Exception {


        return "数列" + n + "的结果为：" + getSum();
    }
}
