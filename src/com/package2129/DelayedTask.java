package com.package2129;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author jianger
 * @Date 2018/3/15 上午11:20
 **/
public class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    /**
     * 延迟的时间
     */
    private final int delta;
    /**
     * ??
     */
    private final int trigger;
    /**
     * 延迟队列
     */
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = (int) (System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS));
        sequence.add(this);
    }

    /**
     * 策略设计模式最简单的实现，每个重写getDelay的类，都需要传入一个TimeUnit类的对象，而返回long类型的延迟时间，
     * 不管方法体里面到底是怎么样实现的，把那些作为延迟时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if (trigger < that.trigger)
            return -1;
        if (trigger > that.trigger)
            return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println("run2");
        System.out.println(this+" ");
    }

    public String summary(){
        return "("+id+":"+delta+")";
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "id=" + id +
                ", delta=" + delta +
                ", trigger=" + trigger +
                '}';
    }

    /**
     *静态内部类
     */
    public static class EndSentinel extends DelayedTask{
        private ExecutorService executorService;
        public EndSentinel(int delay,ExecutorService e){
            super(delay);
            executorService=e;
        }

        @Override
        public void run() {
            for (DelayedTask pt:sequence){
                System.out.println(pt.summary()+" ");
            }
            System.out.println(this+"调用shutdownnow");
            executorService.shutdownNow();
        }
    }
}
