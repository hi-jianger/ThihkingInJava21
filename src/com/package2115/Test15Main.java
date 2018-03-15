package com.package2115;

/**
 * @author jianger
 * @Date 2018/2/25 上午10:53
 **/
public class Test15Main {
    public static void main(String[] args) {

//        OtherObject otherObject=new OtherObject();
//        new Thread(){
//            public void run(){
//                otherObject.f();
//            }
//        }.start();
//        otherObject.g();

        Test15 test15 = new Test15();
        new Thread() {
            public void run() {
                test15.test1();
            }
        }.start();
        new Thread() {
            public void run() {
                test15.test3();
            }
        }.start();
        test15.test2();
//        new Test15().test3();
    }
}
