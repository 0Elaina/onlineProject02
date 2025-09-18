package com.itheima.a03threadcase3;

import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask(mc);
        Thread t = new Thread(ft);
        t.start();
        Integer sum = ft.get();
        System.out.println(sum);
    }
}
