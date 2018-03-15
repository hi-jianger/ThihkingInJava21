package com.cas;

/**
 * 接口中默认都是public
 * @author jianger
 * @Date 2018/2/26 下午3:53
 **/
public interface Test {
    /**
     * 默认是常量
     */
    int i=1;

    /**
     * 默认是public
     */
    static void get(){
        System.out.println("hello world");
    }

    /**
     * 接口实例化时要实现的方法
     */
    default void tets(){
        System.out.println("test");
    }

    static void main(String[] args) {
        Test test=new Test() {
            @Override
            public void tets() {
                System.out.println("重写了的tets()");
            }
        };
        test.tets();
        System.out.println("这是一个main方法");
    }
}
