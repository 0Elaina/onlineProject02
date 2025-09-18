package com.itheima.a05threadmythod2;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "@" + i);
        }
    }
}
