package com.package2133;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author jianger
 * @Date 2018/3/15 下午5:00
 **/
public class ExchangeConsumer<T> implements Runnable {

    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangeConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;
                    holder.remove(x);
                }
            }
        } catch (InterruptedException e) {

        }
        System.out.println("最后的value" + value);
    }
}
