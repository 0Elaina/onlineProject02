package com.itheima.a06threadmythod3;

public class ThreadDemo {
    public static void main(String[] args){
        /*
        final void setDaemon(boolean on)                    设置为守护线程

        当其他非守护线程执行完毕之后，守护线程会陆续结束
         */
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();

        mt1.setName("线程1");
        mt2.setName("线程2");

        mt2.setDaemon(true);

        mt1.start();
        mt2.start();
    }
}
