package com.package2116;

import java.util.Random;

/**
 * 传感器
 *
 * @author jianger
 * @Date 2018/2/25 上午11:49
 **/
public class Sensor {
    /**
     * 检测出的辐射
     */
    private int xRay;

    public int getxRaySum() {
        Random random = new Random();
        xRay = random.nextInt(100);
        if (xRay != 0) {
            Thread.yield();
        }
        return xRay;
    }

    public int getxRay(){
        return xRay;
    }


}
