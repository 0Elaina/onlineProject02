package com.itheima.a04mytreemap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.TreeMap;

public class A03_TreeMapDemo3 {
    public static void main(String[] args) {
        /*
        需求：字符串“aababcabcdabcde”请统计字符串中每一个字符出现的次数，并按照以下格式输出
        输出结果：
        a (5) b (4) c (3) d (2) e (1)
        */

        //需要排序用TreeMap
        //不需要排序用HashMap

        String str = "aababcabcdabcde";

        TreeMap<Character, Integer> tm = new TreeMap<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(tm.containsKey(c)) {
                tm.put(c, tm.get(c) + 1);
            }else{
                tm.put(c, 1);
            }
        }

        tm.forEach((key, value) -> System.out.print(key + " (" + value + ") "));
    }
}
