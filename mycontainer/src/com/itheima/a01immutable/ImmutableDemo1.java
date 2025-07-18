package com.itheima.a01immutable;

import java.util.List;
import java.util.Iterator;

public class ImmutableDemo1 {
    /*
     * 创建不可变的List集合
     */

    public static void main(String[] args) {
        //不可变集合一旦创建完毕，不可修改
        List<String> list = List.of("张三", "李四", "王五", "赵六");

        for (String str : list) {
            System.out.println(str);
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        list.forEach(s -> System.out.print(s + " "));
    }
}
