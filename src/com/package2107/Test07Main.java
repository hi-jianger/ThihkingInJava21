package com.package2107;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 上午10:33
 **/
public class Test07Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future future=new ThreadMethod("ThreadMethod").runTask(3);
        System.out.println(future);
        System.out.println(future.get());
    }
}
