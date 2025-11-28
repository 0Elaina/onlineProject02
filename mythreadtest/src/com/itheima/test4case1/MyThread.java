package com.itheima.test4case1;

public class MyThread extends Thread {
    //共享数据
    //100块，分成三个包
    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN = 0.01;


    @Override
    public void run() {
        synchronized (this.getClass()) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包");
            } else {
                double prize = 0;
                if (count == 1) {
                    prize = money;
                } else {
                    prize = money * Math.random() + 0.01;
                }
                money -= prize;
                count--;
                System.out.println(getName() + "抢到了" + prize + "元红包");
            }
        }
    }
}
