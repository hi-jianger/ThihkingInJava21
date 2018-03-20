//package com.package2134;
//
//import javax.annotation.Generated;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// *需要使用Generator
// * @author jianger
// * @Date 2018/3/16 下午10:22
// **/
//public abstract class Tester<C> {
//
//    static int testReps=10;
//    static int testCycles=1000;
//    static int containserSize=1000;
//
//    /**
//     * 初始化一个容器类
//     * @return
//     */
//    abstract C containerInitiallizer();
//
//    /**
//     * 开始读入读出
//     */
//    abstract void startReaderAndWriters();
//    C testContainer;
//    String testId;
//    int nReders;
//    int nWriters;
//
//    volatile long readResult=0;
//    volatile long resdTime=0;
//    volatile long writerTime=0;
//    CountDownLatch countDownLatch;
//
//    static ExecutorService executorService= Executors.newCachedThreadPool();
//
//    Integer[] writeData;
//
//    public Tester(String testId, int nReders, int nWriters) {
//        this.testId = testId;
//        this.nReders = nReders;
//        this.nWriters = nWriters;
//
//        writeData= Generated.array(Integer.class,new RandomGenerator.Integer)
//    }
//}
