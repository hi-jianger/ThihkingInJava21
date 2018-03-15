package com.package2132;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/15 下午2:14
 **/
public class GreenRoomScheduler {
    /**
     * 开灯
     */
    private volatile boolean light = false;
    /**
     * 浇水
     */
    private volatile boolean water = false;
    /**
     * 时间
     */
    private String time = Time.DAY.getCode();

    public synchronized String getTime() {
        return time;
    }

    public synchronized void setTime(String time) {
        this.time = time;
    }

//    ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);
    DelayQueue delayQueue=new DelayQueue();

    /**
     * 执行一次
     *
     * @param event
     * @param delay
     */
    public void scheduler(Delayed event) {
//        poolExecutor.schedule(event, delay, TimeUnit.MILLISECONDS);
           delayQueue.put(event);
    }

    /**
     * 周期性执行
     *
     * @param event
     * @param initialDelay
     * @param delay
     */
//    public void repeat(Runnable event, long initialDelay, long delay) {
//        poolExecutor.scheduleAtFixedRate(event, initialDelay, delay, TimeUnit.MILLISECONDS);
//    }

    class LightOn implements Runnable,Delayed {


        @Override
        public void run() {
            System.out.println("开灯");
            light = true;
        }

        @Override
        public long getDelay(@NotNull TimeUnit unit) {
            return unit.convert(10000,TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(@NotNull Delayed o) {
            return 0;
        }
    }

    class LightOff implements Runnable {

        @Override
        public void run() {
            System.out.println("关灯");
            light = false;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            System.out.println("浇水");
            water = true;
        }
    }

    class WaterOff implements Runnable {

        @Override
        public void run() {
            System.out.println("停止浇水");
            water = false;
        }
    }

    class TimeDay implements Runnable {

        @Override
        public void run() {
            System.out.println("时间白天");
            /**
             * time不是原子性的，但是set、get方法是同步的
             */
            setTime(Time.DAY.getCode());
        }

    }

    class TimeNight implements Runnable {

        @Override
        public void run() {
            System.out.println("时间黑夜");
            setTime(Time.NIGHT.getCode());
        }
    }

    class BellOn implements Runnable {

        @Override
        public void run() {
            System.out.println("响铃了");
        }
    }

//    class Terminate implements Runnable {
//        /**
//         * 匿名内部类的lambda表达式
//         */
//        @Override
//        public void run() {
//            System.out.println("停止");
//            poolExecutor.shutdownNow();
//            new Thread(() ->
//                    data.forEach(d ->
//                            System.out.println(d)
//                    )
//            ).start();
//        }
//    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return "DataPoint{" +
                    "time=" + time +
                    ", temperature=" + temperature +
                    ", humidity=" + humidity +
                    '}';
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private float lastHum = 50.0f;
    private int humidityDriection = +1;
    private Random random = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable {

        @Override
        public void run() {
            System.out.println("Collection data");
            synchronized (GreenRoomScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                if (random.nextInt(5) == 4) {
                    humidityDriection = -humidityDriection;
                }
                lastTemp = lastTemp + humidityDriection * random.nextFloat();
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHum));
            }
        }
    }


    public static void main(String[] args) {
        GreenRoomScheduler greenRoomScheduler = new GreenRoomScheduler();
        greenRoomScheduler.scheduler(greenRoomScheduler.new LightOn());
//        greenRoomScheduler.repeat(greenRoomScheduler.new LightOff(), 0, 200);
//        greenRoomScheduler.repeat(greenRoomScheduler.new BellOn(), 0, 1000);
//        greenRoomScheduler.repeat(greenRoomScheduler.new LightOn(), 0, 1500);
//        greenRoomScheduler.repeat(greenRoomScheduler.new CollectData(), 500, 500);
    }


}

enum Time {
    DAY(1, "day"),

    NIGHT(2, "night");

    private int id;
    private String code;

    Time(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
