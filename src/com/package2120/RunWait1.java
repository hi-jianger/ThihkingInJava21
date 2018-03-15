package com.package2120;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午9:34
 **/
public class RunWait1 implements Runnable {
    private Flag flag;

    public RunWait1(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        System.out.println("开始休眠10秒");
        try {
            TimeUnit.SECONDS.sleep(10);
            flag.setFlag(true);
            synchronized (flag) {
                System.out.println("开始唤醒任务2");
                flag.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
