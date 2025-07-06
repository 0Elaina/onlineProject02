package com.itheima.a01mymap;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class A03_MapDemo3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for(Map.Entry<String, String> entry : entrySet){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("------------------------");

        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("-----------------------------");
        entrySet.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
