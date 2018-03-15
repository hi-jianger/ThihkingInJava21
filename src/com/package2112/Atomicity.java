package com.package2112;

/**
 * @author jianger
 * @Date 2018/2/24 下午4:39
 **/
public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}
