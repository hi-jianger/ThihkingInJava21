package com.package2110;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 下午1:23
 **/
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();

    public void cancel(){
        canceled=true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
