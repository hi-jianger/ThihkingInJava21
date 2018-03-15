package com.package2124;

/**
 * @author jianger
 * @Date 2018/3/4 上午11:35
 **/
public class Butterer implements Runnable {
    private ToastQueue dryQueue,butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                /**
                 * 从干的吐司队列中拿出吐司
                 */
                Toast toast=dryQueue.take();
                /**
                 * 给干的吐司涂黄油
                 */
                toast.butter();
                System.out.println("Butterer任务的吐司"+toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer任务被中断");
        }
        System.out.println("Butterer任务结束");
    }
}
