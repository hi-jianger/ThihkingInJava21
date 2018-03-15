package com.package2114;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:07
 **/
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            p.setX();
            p.setY();
            temp=getP();
        }
        try {
            store(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
