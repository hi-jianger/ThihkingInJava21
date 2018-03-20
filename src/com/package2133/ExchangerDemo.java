package com.package2133;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该方法中需要使用到生成器
 * but，怎么去定义生成器？
 * @author jianger
 * @Date 2018/3/15 下午7:14
 **/
public class ExchangerDemo {
    static int size=10;
    static int delay=5;

    public static void main(String[] args) {
        if (args.length>0){
            size=new Integer(args[0]);
        }

        if (args.length>1){
            delay=new Integer(args[0]);
        }

        ExecutorService executorService= Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc=new Exchanger<>();
        List<Fat> products=new CopyOnWriteArrayList<>(),
                consumerList=new CopyOnWriteArrayList<>();
        executorService.execute(new ExchangerProducer<Fat>( new BasicGenerator<>(),xc,products));

        executorService.execute(new ExchangeConsumer<>(xc,consumerList));

//        Map<String,Object> map=new HashMap<String,Object>();
    }
}
