package com.package2114;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:11
 **/
public class PairChecker2 implements Runnable {
    private PairManager pairManager;

    public PairChecker2(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true){
            pairManager.checkCounter.incrementAndGet();
            pairManager.getP().checkState();
        }
    }
}
