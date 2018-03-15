package com.package2120;

import com.package2119.Runnable1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/26 下午9:21
 **/
public class Run2 implements Runnable {
    private Flag flag;

    public Run2(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(flag.getFlag());
        while(true){
            if (flag.getFlag()==true) {
                System.out.println("循环结束");
                flag.setFlag(false);
                break;
            }
            System.out.println("循环等待中");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Flag flag=new Flag();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Run1(flag));
//        TimeUnit.SECONDS.sleep(2);
        executorService.execute(new Run2(flag));

        executorService.shutdown();
    }
}
