package com.itheima.test4case1;

public class Test {
    public static void main(String[] args) {
        /*
        微信中的抢红包也用到了多线程。
        假设：100块，分成了3个包，现在有5个人去抢。
        其中，红包是共享数据。
        5个人是5条线程。
        打印结果如下：
            XXX抢到了XXX元
            XXX抢到了XXX元
            XXX抢到了XXX元
            xxx没抢到
            XXX没抢到
         */

        //创建线程的对象
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        MyThread mt4 = new MyThread();
        MyThread mt5 = new MyThread();

        //给线程命名
        mt1.setName("a");
        mt2.setName("b");
        mt3.setName("c");
        mt4.setName("d");
        mt5.setName("e");

        //启动线程
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
    }
}
