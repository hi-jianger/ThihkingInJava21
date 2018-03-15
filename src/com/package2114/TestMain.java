package com.package2114;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:00
 **/
public class TestMain {
    static void test(PairManager pairManager1,PairManager pairManager2){
        ExecutorService executorService= Executors.newCachedThreadPool();
        PairChecker pairChecker1=new PairChecker(pairManager1),
                pairChecker2=new PairChecker(pairManager2);
        PairChecker2 pairChecker21=new PairChecker2(pairManager1),
                pairChecker22=new PairChecker2(pairManager2);

        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);
        executorService.execute(pairChecker21);
        executorService.execute(pairChecker22);

        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pairManager1 :"+pairManager1+"pairManager2 "+pairManager2);
        System.exit(0);
    }


    public static void main(String[] args) {
        PairManager pairManager1=new PairManager1(),
                pairManager2=new PairManager2();
        test(pairManager1,pairManager2);

    }
}
