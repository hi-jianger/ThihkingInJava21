package com.package2126;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jianger
 * @Date 2018/3/4 下午2:11
 **/
public class Philosopher implements Runnable {

    private ChopStick left;
//    private ChopStick right;
    private final Integer id;
    private Random random=new Random(47);

    public void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(random.nextInt(5));
    }

    public Philosopher(Integer id) {
        this.id = id;
    }

    public Philosopher(ChopStick left, Integer id) {
        this.left = left;
//        this.right = right;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this+"哲学家思考问题中");
                pause();
                System.out.println(this+"哲学家吃饭");
                System.out.println(this+"得到左边的筷子");
//                left.token();
                left.setCount();
                System.out.println(this+"得到右边的筷子");
//                right.token();
                left.setCount();
                System.out.println(this+"吃饭中");
                pause();
                left.drop();
//                right.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
