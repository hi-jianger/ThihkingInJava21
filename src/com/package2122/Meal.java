package com.package2122;

/**
 * 膳食
 * @author jianger
 * @Date 2018/2/27 上午10:19
 **/
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
