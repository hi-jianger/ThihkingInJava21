package com.package2128;

/**
 * @author jianger
 * @Date 2018/3/5 上午9:20
 **/
public class TestMain {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TestStatic testStatic = new TestStatic();
            System.out.println(testStatic);
//            System.out.println("id"+testStatic);
        }
        System.out.println(TestStatic.getI());

    }
}
