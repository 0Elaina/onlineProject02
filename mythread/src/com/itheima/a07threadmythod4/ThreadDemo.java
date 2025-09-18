package com.itheima.a07threadmythod4;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        public static void yield()              出让线程/礼让线程
         */

        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.setName("mt1");
        mt2.setName("mt2");

        mt1.start();
        mt2.start();
    }
}
