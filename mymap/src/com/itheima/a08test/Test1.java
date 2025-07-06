package com.itheima.a08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        /*
        班级里有N个学生，学生属性：姓名，年龄，性别。
        实现随机点名器
         */
        System.out.println(rollCall("a", "b", "c", "d", "e", "f", "g", "h"));

        ArrayList<String> list = new ArrayList<>();
        list.add("a"); list.add("b"); list.add("c"); list.add("d"); list.add("e");
        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
    public static String rollCall(String...name){
        Random r = new Random();
        return name[r.nextInt(name.length)];
    }
}
