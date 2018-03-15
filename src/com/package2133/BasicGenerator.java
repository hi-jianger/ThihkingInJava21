package com.package2133;


/**
 * @author jianger
 * @Date 2018/3/15 下午7:11
 **/
public class BasicGenerator<T> implements Generator<T> {

    private Class[] types = new Class[]{BasicGenerator.class};
    private Class<T> clazz;
    static Generator creat(Class clazz){
        Generator<Fat> generator=new BasicGenerator<Fat>();
        return generator;
    }

    @Override
    public T next() {
        try {
            // 利用反射生成 Person 对象
            return (T)types[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
