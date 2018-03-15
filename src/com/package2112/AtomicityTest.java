package com.package2112;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianger
 * @Date 2018/2/24 下午4:40
 **/
public class AtomicityTest implements Runnable {
    private volatile int i = 0;

    public synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        ++i;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                evenIncrement();
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        while (true) {
            int val = atomicityTest.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
