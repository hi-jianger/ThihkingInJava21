package com.package2105;

import java.util.concurrent.ThreadFactory;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午3:51
 **/
public class BackThread implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r);
        //设为后台线程
        thread.setDaemon(true);
        return thread;
    }
}
