package com.itheima.a02test;

import java.io.File;
import java.util.HashMap;

public class Test6 {
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        /*
        需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
        打印格式如下：
        txt:3个
        doc:4个
        jpg:6个
         */
        File file = new File("E:\\school\\javaclass\\onlinelearned\\code" 
        + "\\onlineProject02\\myfile\\src\\com\\itheima\\testfiles");
        System.out.println(getCount(file, hm));

    }

    public static HashMap<String, Integer> getCount(File src, HashMap<String, Integer> hm){
        File[] files = src.listFiles();
        for(File file: files){
            if(file.isFile()){
                String[] arr = file.getName().split("\\.");
                String endName = arr[arr.length - 1];
                if(hm.containsKey(endName)){
                    hm.put(endName, Test6.hm.get(endName) + 1);
                }else{
                    hm.put(endName, 1);
                }
            }else{
                hm = getCount(file, hm);
            }
        }
        return hm;
    }
}
