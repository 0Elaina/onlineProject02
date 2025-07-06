package com.itheima.a01mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class A04_MapDemo4 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");

        map.forEach(new BiConsumer<String, String>(){
           @Override
           public void accept(String key, String value){
               System.out.println(key + ": " + value);
           }
        });

        System.out.println("-----------------------------");
        map.forEach((key, value) ->System.out.println(key + ": " + value));
    }
}
