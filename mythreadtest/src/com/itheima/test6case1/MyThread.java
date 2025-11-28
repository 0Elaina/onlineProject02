package com.itheima.test6case1;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();

    @Override
    public void run() {
        while(true){
            synchronized (this.getClass()){
                if(list.size() == 0){
                    if("抽奖箱1".equals(getName())){
                        System.out.println("在此次抽奖过程中，抽奖箱1总共产生了" + list1.size() + "个奖项。");
                        System.out.print(getName() + ": " + list1);
                        System.out.println(" 最高金额为" + getMax(list1) + "元 总金额为" + getSum(list1) + "元");
                    }else{
                        System.out.println("在此次抽奖过程中，抽奖箱2总共产生了" + list2.size() + "个奖项。");
                        System.out.print(getName() + ": " + list2);
                        System.out.println(" 最高金额为" + getMax(list2) + "元 总金额为" + getSum(list2) + "元");
                    }
                    break;
                }else{
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    if("抽奖箱1".equals(getName())){
                        list1.add(prize);
                    }else{
                        list2.add(prize);
                    }
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
