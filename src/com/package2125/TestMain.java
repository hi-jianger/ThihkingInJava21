package com.package2125;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author jianger
 * @Date 2018/3/4 下午12:23
 **/
public class TestMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        BlockingQueue<Character> blockingQueue=new LinkedBlockingDeque<>();
        Sender sender=new Sender(blockingQueue);
        Receiver receiver=new Receiver(blockingQueue);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);

        TimeUnit.SECONDS.sleep(10);
        executorService.shutdownNow();
    }
}
