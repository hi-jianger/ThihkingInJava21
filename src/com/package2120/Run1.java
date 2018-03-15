package com.package2120;


import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午9:19
 **/
public class Run1 implements Runnable {
    public Flag flag;

    public Run1(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始休眠10秒");
            TimeUnit.SECONDS.sleep(10);
            flag.setFlag(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
