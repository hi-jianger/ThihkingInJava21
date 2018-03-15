package com.package2124;

/**
 * @author jianger
 * @Date 2018/3/4 上午11:41
 **/
public class Jammer implements Runnable {

    private ToastQueue butteredQueue, finshedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finshedQueue) {
        this.butteredQueue = butteredQueue;
        this.finshedQueue = finshedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println("涂上果酱啦~");
                finshedQueue.put(toast);

            }
        } catch (InterruptedException e) {
            System.out.println("果酱任务被中断");
        }
        System.out.println("果酱任务结束");
    }
}
