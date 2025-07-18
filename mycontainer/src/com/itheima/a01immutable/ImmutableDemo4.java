package com.itheima.a01immutable;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class ImmutableDemo4 {
    //创建map的不可变集合，键值对超过十个
    public static void main(String[] args){
        HashMap<String, String> hm = new HashMap<>();
        hm.put("a", "A");hm.put("b", "B");hm.put("c", "C");hm.put("d", "D");hm.put("e", "E");hm.put("f", "F");hm.put("g", "G");hm.put("h", "H");hm.put("i", "I");hm.put("j", "J");hm.put("k", "K");

        /*Set<Map.Entry<String, String>> entries = hm.entrySet();
        Map.Entry[] arr = entries.toArray(new Map.Entry[0]);
        Map m = Map.ofEntries(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]);
        System.out.println(m);*/

        Map<String, String> m = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));
        System.out.println(m);

        /*
        copyOf方法传入可变集合，返回相应不可变集合
        传入不可变集合无变化
         */
        Map<String, String> map = Map.copyOf(hm);
        System.out.println(map);
    }

}
