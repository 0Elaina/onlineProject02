package com.itheima.a09threadsafe1;

public class MyThread extends Thread {
    //表示这个类的所有对象，都共享ticket数据
    static int ticket = 0;

    //锁对象一定是要唯一的
    static Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (ticket < 100) {
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票!!!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
