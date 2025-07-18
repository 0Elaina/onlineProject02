package com.itheima.a01mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class StreamDemo6 {
    public static void main(String[] args) {
        /*
        filter          过滤
        limit           获取前几个元素
        skip            跳过前几个元素
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

        //filter
        list.stream().filter(new Predicate<String>(){
            @Override
            public boolean test(String name){
                //返回值为true表示当前数据留下，false反之
                return name.startsWith("张");
            }
        }).forEach(name -> System.out.print(name + " "));
        System.out.println();

        list.stream()
        .filter(name -> name.startsWith("张"))
        .filter(name -> name.length() == 3)
        .forEach(name -> System.out.print(name + " "));
        System.out.println();

        //limit
        list.stream().limit(3).forEach(name -> System.out.print(name + " "));
        System.out.println();

        //skip
        list.stream().skip(4).forEach(name -> System.out.print(name + " "));
        System.out.println();

        list.stream().skip(3).limit(3).forEach(name -> System.out.print(name + " "));
    }
}
