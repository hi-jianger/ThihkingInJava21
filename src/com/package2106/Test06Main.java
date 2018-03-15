package com.package2106;

import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午4:08
 **/
public class Test06Main  {

    public static void main(String[] args) throws InterruptedException {
        Thread d=new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d是否为后台线程："+d.isDaemon());
        TimeUnit.SECONDS.sleep(0);
    }
}
