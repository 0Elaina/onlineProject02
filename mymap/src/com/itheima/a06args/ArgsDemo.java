package com.itheima.a06args;

public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2, 3, 4, 5, 5, 6, 7));
    }
    public static int getSum(int...args){
        int sum = 0;
        for(int i: args) sum += i;
        return sum;
    }
}
