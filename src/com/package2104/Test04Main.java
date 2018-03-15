package com.package2104;

import java.util.Random;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/23 下午3:25
 **/
public class Test04Main {

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            Random random=new Random();
            Test04 test04=new Test04(random.nextInt(1000));
            test04.run();
        }
    }
}
