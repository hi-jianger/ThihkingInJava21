package com.package2108;

/**
 * @author jianger
 * @Description
 * @Date 2018/2/24 上午11:30
 **/
public class Joining {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleeper", 1500),
                grumy = new Sleeper("Grumy", 1500);
        Joiner dopey = new Joiner("Dopey", sleeper),
                doc = new Joiner("Doc", grumy);
        grumy.interrupt();
    }
}
