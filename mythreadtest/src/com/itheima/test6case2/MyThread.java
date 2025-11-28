package com.itheima.test6case2;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        while(true){
            synchronized (this.getClass()){
                if(list.size() == 0){
                        System.out.println("在此次抽奖过程中，" + getName() + "总共产生了" + boxList.size() + "个奖项。");
                        System.out.print(getName() + ": " + boxList);
                        System.out.println(" 最高金额为" + getMax(boxList) + "元 总金额为" + getSum(boxList) + "元");
                    break;
                }else{
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    boxList.add(prize);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int getSum(ArrayList<Integer> list){
        int sum = 0;
        for(int i : list){
            sum = sum + i;
        }
        return sum;
    }

    private int getMax(ArrayList<Integer> list){
        int max = list.get(0);
        for(int i : list){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
