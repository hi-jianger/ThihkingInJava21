package com.package2117;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jianger
 * @Date 2018/2/25 下午2:20
 **/
public class IOBlocaked implements Runnable {
    private InputStream inputStream;

    public IOBlocaked(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            System.out.println("请输入。。。。。。");
            inputStream.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("IO被中断");
            } else {
                throw new RuntimeException(e);
            }
        }
    }
}
