package com.itheima.a08test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class Test4 {
    public static void main(String[] args) {
        /* 需求
        定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个。
        添加完毕后，遍历结果格式如下：
        江苏省＝南京市，扬州市，苏州市，无锡市，常州市
        湖北省＝武汉市，孝感市，十堰市，宜昌市，鄂州市
        河北省＝石家庄市，唐山市，邢台市，保定市，张家口市*/
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> province1 = new ArrayList<>();
        province1.add("南京市"); province1.add("扬州市"); province1.add("苏州市"); province1.add("无锡市"); province1.add("常州市");
        ArrayList<String> province2 = new ArrayList<>();
        province2.add("武汉市"); province2.add("孝感市"); province2.add("十堰市"); province2.add("宜昌市"); province2.add("鄂州市");
        ArrayList<String> province3 = new ArrayList<>();
        province3.add("石家庄市"); province3.add("唐山市"); province3.add("邢台市"); province3.add("保定市"); province3.add("张家口市");

        hm.put("江苏省", province1);
        hm.put("湖北省", province2);
        hm.put("河北省", province3);

        hm.forEach((String key, ArrayList<String> value) -> System.out.println(key + " = " + value));
    }
}
