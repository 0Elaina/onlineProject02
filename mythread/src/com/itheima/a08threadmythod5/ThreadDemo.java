package com.itheima.a08threadmythod5;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        public final void join()            插入线程/插队线程
         */
        MyThread mt = new MyThread();
        mt.setName("土豆");
        mt.start();

        //表示把mt这个线程插入到当前线程之前
        mt.join();

        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "@" + i);
        }
    }
}
