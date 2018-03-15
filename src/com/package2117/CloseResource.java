package com.package2117;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/2/25 下午2:46
 **/
public class CloseResource {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            InputStream inputStream=new Socket("localhost",8080).getInputStream();
            executorService.execute(new IOBlocaked(inputStream));
            executorService.execute(new IOBlocaked(System.in));
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("正在结束所有的线程......");
            executorService.shutdownNow();
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("关闭"+inputStream.getClass().getName());
            inputStream.close();
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("关闭"+System.in.getClass().getName());
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
