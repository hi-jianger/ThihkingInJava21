package com.package2114;

/**
 * @author jianger
 * @Date 2018/2/25 上午9:58
 **/
public class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.setX();
        p.setY();
        try {
            store(getP());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
