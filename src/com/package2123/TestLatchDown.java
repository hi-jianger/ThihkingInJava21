package com.package2123;

import java.util.concurrent.CountDownLatch;

/**
 * await之后的任务是要等待的
 * @author jianger
 * @Date 2018/3/2 上午10:50
 **/
public class TestLatchDown implements Runnable {

    private CountDownLatch countDownLatch;

    public TestLatchDown(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        TestLatchDown latchDown = new TestLatchDown(countDownLatch);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            new Thread(latchDown).start();
        }

        countDownLatch.await();

        long end = System.currentTimeMillis();
        System.out.println("执行程序消费的时间为：" + (end - start));
    }

    @Override
    public void run() {
         synchronized (this){
             for (int i=0;i<5000;i++){
                 if(i%2==0){
                     System.out.println(i+"是偶数");
                 }
             }
             countDownLatch.countDown();
         }
    }
}
