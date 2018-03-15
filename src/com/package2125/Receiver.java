package com.package2125;

import java.io.IOException;
import java.io.PipedReader;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 接收者 Reader
 * @author jianger
 * @Date 2018/3/4 下午12:19
 **/
public class Receiver implements Runnable {
//    private PipedReader pipedReader;
    private Random random=new Random(47);
    private BlockingQueue<Character> blockingQueue;

    public Receiver(BlockingQueue<Character> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    //    public PipedReader getPipedReader() {
//        return pipedReader;
//    }

//    public Receiver(Sender sender) throws IOException {
//        this.pipedReader = new PipedReader(sender.getOut());
//    }

    @Override
    public void run() {
       try {
           while (!Thread.interrupted()){
//               System.out.println((char) pipedReader.read());
               System.out.println(blockingQueue.take());
//               System.in.read();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
