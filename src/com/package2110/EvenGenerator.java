package com.package2110;

/**
 * @author jianger
 * @Date 2018/2/24 下午1:39
 **/
public class EvenGenerator extends IntGenerator {

    private int currentEventValue = 0;

//    @Override
//    public int next() {
//        ++currentEventValue;
//        ++currentEventValue;
//        return currentEventValue;
//    }

    @Override
    public synchronized int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
