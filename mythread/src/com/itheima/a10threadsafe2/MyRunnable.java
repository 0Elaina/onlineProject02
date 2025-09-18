package com.itheima.a10threadsafe2;

public class MyRunnable implements Runnable {

    int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if(func()) break;
        }
    }

    private synchronized boolean func() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在售卖第" + ticket + "张票!!!");
        }
        return false;
    }
}
