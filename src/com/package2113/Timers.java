package com.package2113;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author jianger
 * @Date 2018/2/24 下午4:54
 **/
public class Timers {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("执行简单的任务");
                }
            },1000);
        }
    }
}
