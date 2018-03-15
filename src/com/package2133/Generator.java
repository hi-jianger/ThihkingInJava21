package com.package2133;

/**
 * java中没有Generator，需要自己定义生成器
 * @author jianger
 * @Date 2018/3/15 下午7:07
 **/
public interface Generator<T> {

    /**
     - 用以产生新对象
     - @return
     */
    public T next();

}
