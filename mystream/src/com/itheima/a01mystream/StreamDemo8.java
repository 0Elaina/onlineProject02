package com.itheima.a01mystream;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.Collections;

public class StreamDemo8 {
    public static void main(String[] args) {
        // map                      转换流中的数据类型
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌-15", "周芷若-14", "赵敏-13");
        //只获取年龄

        list1.stream().map(new Function<String, Integer>(){
            //第一个类型：流中原本的数据类型
            //第二个类型：要转成之后的类型
            @Override
            public Integer apply(String s){
                //apply的形参s:依次表示流里面的每一个数据
                //返回值表示转换之后的数据
                String[] arr = s.split("-");
                return Integer.parseInt(arr[1]);
            }
        }).forEach(age -> System.out.print(age + " "));
        System.out.println();

        list1.stream()
        .map(s -> Integer.parseInt(s.split("-")[1]))
        .forEach(age -> System.out.print(age + " "));
    }
}
