package com.package2116;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 辐射计数器
 * @author jianger
 * @Date 2018/2/25 上午11:47
 **/
public class XRayCounter implements Runnable{
    private int id;
    private static List<XRayCounter> sensors=new ArrayList<>();
    private Sensor sensor=new Sensor();

    public XRayCounter(int id) {
        this.id=id;
        sensors.add(this);
    }

    /**
     * 每个传感器得到的辐射相加
     * @return
     */
    public static int counter(){
        int sum=0;
        for (XRayCounter xRayCounter:sensors){
            sum+=xRayCounter.getValue();
        }
        return sum;
    }

    public int getValue(){
        return sensor.getxRay();
    }


    @Override
    public void run() {
        synchronized (this){
            System.out.println(this+" 当前辐射为"+sensor.getxRaySum());
        }
    }

    @Override
    public String toString() {
        return "XRayCounter" + id ;
    }
}
