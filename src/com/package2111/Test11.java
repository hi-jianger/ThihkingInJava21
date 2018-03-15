package com.package2111;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/24 下午3:07
 **/
public class Test11 implements Runnable {

    private volatile int sum = 10;
    private volatile String content;

    public synchronized void operation() {
        sum++;
        content = "第一次修改sum的值为" + sum;
        sum++;
        content = "第一次修改sum的值为" + sum;
        sum++;
        content = "第一次修改sum的值为" + sum;
        sum++;
        content = "第一次修改sum的值为" + sum;
        ++sum;
        content = "第一次修改sum的值为" + sum;
        ++sum;
        content = "第一次修改sum的值为" + sum;

    }

    public synchronized int getSum() {
        return sum;
    }

    public synchronized String getContent() {
        return content;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                operation();
//
//                try {
////                    TimeUnit.SECONDS.sleep(1);
////                System.out.println(i+"  test11的content为：" + content);
////                System.out.println(i+"  test11的sum为：" + sum);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("run content: " + content + "sum :" + sum);
        }
    }
}
