package com.package2120;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午9:39
 **/
public class RunWait2 implements Runnable {
    private Flag flag;

    public RunWait2(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        System.out.println(flag.getFlag());
        synchronized (flag) {
            while (flag.getFlag() == false) {

                try {
                    System.out.println("任务2开始等待");

                    flag.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        flag.setFlag(false);
        System.out.println("flag=" + flag.getFlag());
    }

    public static void main(String[] args) {
        Flag flag = new Flag();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RunWait1(flag));

        executorService.execute(new RunWait2(flag));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
