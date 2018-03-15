package com.package2106;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午4:04
 **/
public class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + "开始了：");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "]是否是后台线程：" + t[i].isDaemon() + ",");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
