package com.package2109;

import java.io.IOException;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 上午11:42
 **/
public class ResponseUI extends Thread {
    private static volatile  double d = 1;

    public ResponseUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            System.out.println("run方法中的d"+d);
            d = d + (Math.PI + Math.E) / d;
            System.out.println("run方法之后的d"+d);
        }

    }


    public static void main(String[] args) throws IOException {
        new ResponseUI();
        System.in.read();
        System.out.println(d);
    }

}
