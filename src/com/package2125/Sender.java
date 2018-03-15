package com.package2125;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 发送消息，writer类
 *
 * @author jianger
 * @Date 2018/3/4 下午12:15
 **/
public class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    private BlockingQueue<Character> blockingQueue;

    public Sender(BlockingQueue<Character> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'A'; c < 'Z'; c++) {
//                    out.write(c);
                    blockingQueue.add(c);
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            try {
////                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public PipedWriter getOut() {
        return out;
    }
}
