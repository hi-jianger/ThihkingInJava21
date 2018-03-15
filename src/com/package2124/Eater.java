package com.package2124;

/**
 * @author jianger
 * @Date 2018/3/4 上午11:48
 **/
public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private Integer count=0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
       try{
           while(!Thread.interrupted()){
               Toast toast=finishedQueue.take();
               if (toast.getIntId()!=count++||toast.getStatus()!=Toast.Status.JAMMED){
                   System.out.println("出错");
                   System.exit(1);
               }
               System.out.println("吃吐司");
           }
       }catch (InterruptedException e) {
           System.out.println("吃吐司任务被中断");
       }
        System.out.println("吃吐司任务结束");
    }
}
