package com.itheima.test7;

import com.itheima.test6case2.MyThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        有一个抽奖池，该抽奖池中存放了奖励的金额，该抽奖池中的奖项为[10,5，20,50,100,200，500，800,2，80，300,700};
        创建两个抽奖箱（线程）设置线程名称分别为“抽奖箱1”，"抽奖箱2”
        随机从抽奖池中获取奖项元素并打印在控制台上，格式如下：
        在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10，20，100，500，2，300
        最高奖项为300元，总计额为932元
        在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5，50，200，800，80，700
        最高奖项为800元，总计额为1835元
        在此次抽奖过程中，抽奖箱2中产生了最大奖项，该奖项金额为800元
        以上打印效果只是数据模拟，实际代码运行的效果会有差异
         */
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        //创建多线程要运行的参数对象
        MyCallable mc = new MyCallable(list);

        //创建多线程运行的结果管理者对象
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);

        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();

        Integer max1 = ft1.get();
        Integer max2 = ft2.get();
        if(max1 > max2){
            System.out.println("在此次抽奖过程中，抽奖箱1中产生了最大奖项，该奖项金额为800元");
        }else{
            System.out.println("在此次抽奖过程中，抽奖箱2中产生了最大奖项，该奖项金额为800元");
        }
    }
}
