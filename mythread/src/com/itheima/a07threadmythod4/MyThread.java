package com.itheima.a07threadmythod4;

public class MyThread extends Thread{
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(getName() + "@" + i);
            //表示让出当前cpu的执行权
            Thread.yield();
        }
    }
}
