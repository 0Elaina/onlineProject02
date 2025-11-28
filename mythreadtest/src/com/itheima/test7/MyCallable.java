package com.itheima.test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
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

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while(true){
            synchronized (this.getClass()){
                if(list.size() == 0){
                    System.out.println("在此次抽奖过程中，" + Thread.currentThread().getName() + "总共产生了" + boxList.size() + "个奖项。");
                    System.out.print(Thread.currentThread().getName() + ": " + boxList);
                    System.out.println(" 最高金额为" + getMax(boxList) + "元 总金额为" + getSum(boxList) + "元");
                    break;
                }else{
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    boxList.add(prize);
                }
            }
                Thread.sleep(100);
        }
        if(boxList.size() == 0){
            return null;
        }else{
            return Collections.max(boxList);
        }
    }
}
