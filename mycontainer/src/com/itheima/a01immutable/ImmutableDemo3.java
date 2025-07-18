package com.itheima.a01immutable;

import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;

public class ImmutableDemo3 {
    //创建map的不可变集合
    //Map里的of方法最多只能传递10个键值对， 20个参数
    public static void main(String[] args){
        Map<String, String> m = Map.of("a", "A", "b", "B", "c", "C");

        Set<String> s = m.keySet();
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.print(key + ": " + m.get(key) + " | ");
        }
        System.out.println();
        System.out.println("-------------------------");

        System.out.println(m);
        System.out.println("-------------------------");

        m.forEach((key, value) -> System.out.print(key + ": " + value + " | "));
        System.out.println();
        System.out.println("------------------------------");
        for(String key: s){
            System.out.print(key + ": " + m.get(key) + " | ");
        }
        System.out.println();

        System.out.println("---------------------------------");
        Set<Map.Entry<String, String>> entries = m.entrySet();
        for(Map.Entry<String, String> entry : entries){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print(key + ": " + value + " | ");
        }
        System.out.println();
    }
}
