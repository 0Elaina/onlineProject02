package com.itheima.a08test;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        /*
        班级里有5个学生
        要求:
        被点到的学生不会再被点到。
        但是如果班级中所有的学生都点完了，需要重新开启第二轮点名。
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("a"); list.add("b"); list.add("c"); list.add("d"); list.add("e");
        ArrayList<String> tempList = new ArrayList<>();
        boolean flag = true;
        for(int i = 1; i < 4; i++) {
            tempList.clear();
            System.out.println("---------------第" + i + "轮点名--------------");
            while (flag) {
                String result = rollCall(list);
                if (result.length() > 1) {
                    flag = false;
                    System.out.println();
                    System.out.println(result);
                } else {
                    System.out.print(result + " ");
                    tempList.add(result);
                }
            }
            list.addAll(tempList);
            flag = true;
        }

    }
    public static String rollCall(ArrayList<String> list) {
        String result = "";
        if(list.isEmpty()) return "已点完";
        Collections.shuffle(list);
        result = list.get(0);
        list.remove(0);
        return result;
    }
}
