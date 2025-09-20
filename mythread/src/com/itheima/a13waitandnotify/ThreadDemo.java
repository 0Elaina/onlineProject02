package com.itheima.a13waitandnotify;

public class ThreadDemo {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();

        foodie.start();
        cook.start();
    }
}
