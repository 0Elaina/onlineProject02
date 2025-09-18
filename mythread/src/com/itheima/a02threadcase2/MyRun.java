package com.itheima.a02threadcase2;

public class MyRun implements Runnable{
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "HelloWorld" + i);
        }
    }
}
