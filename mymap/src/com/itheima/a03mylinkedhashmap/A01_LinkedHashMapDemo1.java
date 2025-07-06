    package com.itheima.a03mylinkedhashmap;

    import java.util.LinkedHashMap;

    public class A01_LinkedHashMapDemo1 {
        public static void main(String[] args) {
            LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

            lhm.put("two", 2);
            lhm.put("three", 3);
            lhm.put("one", 1);
            lhm.put("one", 2);

            System.out.println(lhm);

        }
    }
