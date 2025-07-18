package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo3 {
    public static void main(String[] args){
        /*
         * 集合中有一些名字，按照要求过滤数据
         * 数据："张无忌"，"周芷若"，"赵敏"，"张强"，"张三丰"
         * 要求：只要以张开头，而且名字是3个字的
         */
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        list.stream().filter(new stringOperation()::stringJudge).forEach(System.out::println);
    }
}
class stringOperation{
    public boolean stringJudge(String str){
        return str.startsWith("张") && str.length() == 3;
    }
}