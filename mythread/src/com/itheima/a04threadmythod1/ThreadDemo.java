package com.itheima.a04threadmythod1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        String getName()                                    返回此线程的名称
            如果没有给线程设置名字，线程有默认名字
            格式：Thread-X (X序号，从0开始)

        void setName(String name)                           设置线程的名字（构造方法也可以设置名字）
        static Thread currentThread()                       获取当前线程的对象
            当JVM虚拟机启动后，会自动的启动多条线程
            其中一条为main线程
            作用是调用main方法，并执行其中的代码

        static void sleep(long time)                        让线程休眠指定的时间，单位为毫秒
            哪条线程执行到sleep方法，那么哪条线程就会在这里停留对应的时间
            方法的参数就表示睡眠的时间，单位毫秒
            当时间到了之后，线程会继续执行下面的代码

         */
        MyThread mt = new MyThread("aaa");

        mt.start();

        System.out.println(Thread.currentThread().getName());
    }
}
