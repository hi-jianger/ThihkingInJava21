package com.package2117;

/**
 * @author jianger
 * @Date 2018/2/25 下午2:29
 **/
public class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        /**
         * 不释放锁
         */
        while (true) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        System.out.println("尝试调用f()");
        f();
        System.out.println("正在结束SynchronizedBlocked的run()");
    }
}
