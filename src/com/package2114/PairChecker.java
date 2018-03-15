package com.package2114;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:09
 **/
public class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while(true){
           pairManager.increment();
        }
    }

    @Override
    public String toString() {
        return "PairChecker{" +pairManager.checkCounter+
                "pairManager=" + pairManager.getP() +
                '}';
    }
}
