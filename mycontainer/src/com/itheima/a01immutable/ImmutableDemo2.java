package com.itheima.a01immutable;

import java.util.Set;
import java.util.Iterator;

public class ImmutableDemo2 {
    public static void main(String[] args){
        //创建Set的不可变集合
        Set<String> set = Set.of("张三", "李四", "王五", "赵六");

        for(String str: set){
            System.out.print(str + " ");
        }

        System.out.println();
        System.out.println("--------------------------");

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("-------------------------------");

        set.forEach(s -> System.out.print(s + " "));
    }
}
