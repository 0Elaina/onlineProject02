package com.itheima.a13waitandnotify;

public class Cook extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    if(Desk.foodFlag == 1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("厨师制作了一碗面条");
                        Desk.foodFlag = 1;
                        Desk.lock.notify();
                    }
                }
            }
        }
    }
}
