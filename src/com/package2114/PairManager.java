package com.package2114;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jianger
 * @Date 2018/2/25 上午9:52
 **/
public abstract class PairManager {
    AtomicInteger checkCounter=new AtomicInteger();
    protected Pair p=new Pair();
    private List<Pair> storage= Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getP() {
        return new Pair(p.getX(),p.getY());
    }

    protected void store(Pair p) throws InterruptedException {
        storage.add(p);
        TimeUnit.SECONDS.sleep(50);
    }

    public abstract void increment();

    @Override
    public String toString() {
        return "PairManager{" +
                "checkCounter=" + checkCounter +
                ", p=" + p +
                ", storage=" + storage +
                '}';
    }
}
