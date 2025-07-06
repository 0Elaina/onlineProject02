package com.itheima.a04mytreemap;

import java.util.Comparator;
import java.util.TreeMap;

public class A01_TreeMapDemo1 {
    public static void main(String[] args) {
        /*
        TreeMap集合：基本应用
        需求1：
        键：整数表示id
        值：字符串表示商品名称
        要求：按照id的升序排列、按照id的降序排列
         */

        TreeMap<Integer, String> tm = new TreeMap<>((o1, o2) -> o2 - o1);

        tm.put(1, "粤利粤");
        tm.put(2, "雷碧");
        tm.put(3, "可恰可乐");
        tm.put(4, "九个核桃");

        System.out.println(tm);

    }
}
