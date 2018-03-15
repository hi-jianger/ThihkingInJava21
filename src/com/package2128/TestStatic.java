package com.package2128;

/**
 * @author jianger
 * @Date 2018/3/5 上午9:19
 **/
public class TestStatic {
    private static int i=0;
    private  final int id=i++;



    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        TestStatic.i = i;
    }


    public  int getId() {
        return id;
    }

    @Override
    public String toString() {
//        TestStatic.id=TestStatic.
//        TestStatic.id=getI();
        return "TestStatic{}"+id;
    }
}
