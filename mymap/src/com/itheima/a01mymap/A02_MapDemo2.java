package com.itheima.a01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("尹志平", "小龙女");
        map.put("郭靖", "穆念慈");
        map.put("欧阳克", "黄蓉");

        Set<String> keys = map.keySet();
        for(String key : keys){
            String value = map.get(key);
            System.out.println(key + ": " + value);
        }

        System.out.println("--------------------------");

        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key + ": " + map.get(key));
        }

        System.out.println("----------------------------");

        keys.forEach(s -> System.out.println(s + ": " + map.get(s)));
    }
}
