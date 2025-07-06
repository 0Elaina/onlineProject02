package com.itheima.a08test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        HashMap<String, Character> hm = new HashMap<>();
        hm.put("A", '男'); hm.put("B", '女'); hm.put("C", '女');
        int manCount = 0, womanCount = 0;
        for(int i = 0; i < 100; i++){
            String name = rollCall(hm);
            if(name.equals("A")) manCount++;
            else womanCount++;
        }
        System.out.println("man: " + manCount + ", woman: " + womanCount);
    }
    public static String rollCall(HashMap<String, Character> hm){
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        Random r = new Random();
        Set<String> keySet = hm.keySet();
        Iterator<String> it = keySet.iterator();
        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> womanList = new ArrayList<>();
        while(it.hasNext()){
            String key = it.next();
            if(hm.get(key) == '男') manList.add(key);
            if(hm.get(key) == '女') womanList.add(key);
        }
        if(arr[r.nextInt(arr.length)] == 1){
            Collections.shuffle(manList);
            return manList.get(0);
        }else{
            Collections.shuffle(womanList);
            return womanList.get(0);
        }
    }
}
