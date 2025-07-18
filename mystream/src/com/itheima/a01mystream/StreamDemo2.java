package com.itheima.a01mystream;

import java.util.ArrayList;
import java.util.Collections;

public class StreamDemo2 {
    /*
     * 单列集合             default Stream<E> stream()                              Collection中的默认方法
        双列集合            无                                                      无法直接使用stream流
        数组                public static <T> Stream<T> stream(T[] array)           Arrays工具类中的静态方法
        一堆零散数据         public static<T> Stream<T> of(T... values)              Stream接口中的静态方法
     */
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "e", "f");

        list.stream().forEach(s -> System.out.println(s));
    }
}
