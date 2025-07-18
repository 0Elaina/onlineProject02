package com.itheima.a01mystream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StreamDemo3 {
    public static void main(String[] args){
        HashMap<String, String> hm = new HashMap<>();
        hm.put("a", "A"); hm.put("b", "B"); hm.put("c", "C"); hm.put("d", "D");

        hm.entrySet().stream().forEach(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + " | "));
        System.out.println();
        hm.keySet().stream().forEach(key -> System.out.print(key + ": " + hm.get(key) + " | "));
        System.out.println();

        Set<Map.Entry<String, String>> entries = hm.entrySet();
        entries.stream().forEach(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + " | "));
        System.out.println();

        Set<String> set = hm.keySet();
        set.stream().forEach(key -> System.out.print(key + ": " + hm.get(key) + " | "));
        System.out.println();

        Map.Entry[] arr = entries.toArray(new Map.Entry[0]);
        Arrays.stream(arr).forEach(entry -> System.out.print(entry.getKey() + ": " + entry.getValue() + " | "));

    }
}
