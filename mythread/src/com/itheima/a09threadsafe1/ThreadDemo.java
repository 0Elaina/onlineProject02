package com.itheima.a09threadsafe1;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread window1 = new MyThread();
        MyThread window2 = new MyThread();
        MyThread window3 = new MyThread();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
