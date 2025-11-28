package com.itheima.test5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.getClass()) {
                if (list.size() == 0) {
                    break;
                } else {
                    Collections.shuffle(list);
                    System.out.println(getName() + "又产生了一个" + list.remove(0) + "元大奖");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
