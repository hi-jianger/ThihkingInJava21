package com.package2130;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/15 下午12:20
 **/
public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask> {

    Random random=new Random(47);
    private static int counter=0;
    private final int id=counter++;
    private final int priority;

    protected static List<PrioritizedTask> prioritizedTasks=new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority=priority;
        prioritizedTasks.add(this);
    }

    @Override
    public int compareTo(@NotNull PrioritizedTask o) {
        return priority<o.priority?1:(priority>o.priority?-1:0);
    }

    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PrioritizedTask{" +
                "random=" + random +
                ", id=" + id +
                ", priority=" + priority +
                '}';
    }

    public String summery(){
        return "("+id+":"+priority+")";
    }

    /**
     *静态内部类
     */
    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService executorService;
        public EndSentinel(ExecutorService e){
            super(-1);
            executorService=e;
        }

        @Override
        public void run() {
//            int count=0;
            for (PrioritizedTask pt:prioritizedTasks){
                System.out.println(pt.summery()+" ");
//                if (count++%5==0)

            }
            System.out.println(this+"调用shutdownnow");
            executorService.shutdownNow();
        }
    }
}
