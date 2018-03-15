package com.package2115;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:51
 **/
public class OtherObject {

    private Object object=new Object();
    public synchronized void f(){
        for (int i=0;i<10;i++){
            System.out.println("我是f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (object){
            for (int i=0;i<5;i++) {
                System.out.println("我是g()");
                Thread.yield();
            }
        }
    }

}
