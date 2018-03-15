package com.package2133;

/**
 * @author jianger
 * @Date 2018/3/15 下午7:20
 **/
public class Fat {

    private volatile double d;
    private static int counter=0;

    private final int id=counter++;

    public Fat(){
        for (int i = 0; i < 10000; i++) {
            d+=Math.PI+Math.E/(double)i;
        }
    }

    public void operation(){
        System.out.println(this);
    }

    public String toString(){
        return "Fat id:"+id;
    }
}
