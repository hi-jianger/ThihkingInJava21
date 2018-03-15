package com.package2123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author jianger
 * @Date 2018/2/27 下午3:46
 **/
public class Test  {
    static void getKey(){
        try{
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static  void test(String msg, BlockingDeque<LightOff> queue){
        System.out.println(msg);
        LiftOffRunner runner=new LiftOffRunner(queue);
        Thread t=new Thread(runner);
        t.start();
        for (int i = 0; i <5 ; i++) {
            runner.add(new LightOff(i));
        }
        getKey("Press Enter "+msg);
        getKey();
        t.interrupt();

        System.out.println("test 方法结束");
    }

     static void  testForObject (){
        test("LinkedBlockingQueue",new LinkedBlockingDeque<LightOff>());
        test("ArrayBlockingQueue", (BlockingDeque<LightOff>) new ArrayBlockingQueue<LightOff>(3));
        test("SynchronousQueue", (BlockingDeque<LightOff>) new SynchronousQueue<LightOff>());
    }

    public static void main(String[] args) {
//        test("LinkedBlockingQueue",new LinkedBlockingDeque<LightOff>());
//        test("ArrayBlockingQueue", (BlockingDeque<LightOff>) new ArrayBlockingQueue<LightOff>(3));
//        test("SynchronousQueue", (BlockingDeque<LightOff>) new SynchronousQueue<LightOff>());
        testForObject();
    }
}
