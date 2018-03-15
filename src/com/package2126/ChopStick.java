package com.package2126;

/**
 * 筷子/只
 * @author jianger
 * @Date 2018/3/4 下午2:07
 **/
public class ChopStick {
    private Boolean token=false;
    /**
     * 筷子笼
     */
    private  Integer count;

    public ChopStick(Integer count) {
        this.count = count;
    }

    /**
     * 占有筷子
     * @throws InterruptedException
     */
    public synchronized void token() throws InterruptedException {
        while (token)
            wait();
        token=false;
    }

    /**
     * 释放筷子资源
     */
    public synchronized void drop(){
//        token=false;
//        notifyAll();
        if (count==5){
            notifyAll();
        }
        count++;
        count++;
    }

    public  Integer getCount() {
        return count;
    }

    public synchronized void setCount() throws InterruptedException {
        if (count==0){
            wait();
        }
        count--;
    }
}
