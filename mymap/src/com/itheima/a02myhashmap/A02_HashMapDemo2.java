package com.itheima.a02myhashmap;

import java.util.*;

public class A02_HashMapDemo2 {
    public static void main(String[] args) {
        /*
        某个班级80名学生，现在需要组成秋游活动，
        班长提供了四个景点依次是（A、B、C、D），
        每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
         */
        String[] arr = {"A", "B", "C", "D"};
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 80; i++) {
            list.add(arr[r.nextInt(arr.length)]);
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for(String name: list){
            if(hm.containsKey(name)){
                int count = hm.get(name);
                count++;
                hm.put(name, count);
            }else{
                hm.put(name, 1);
            }
        }

        hm.forEach((key, value) -> System.out.println(key + ": " + value));

        Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        int max = 0;
        String position = null;
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() > max){
                max = entry.getValue();
                position = entry.getKey();
            }
        }
        System.out.println("max = " + max + ", position = " + position);
    }
}
