package com.itheima.a02test;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {
        /*
         * 需求：
         * 定义一个方法找某一个文件夹中，是否有以avi结尾的电影。
         * （暂时不需要考虑子文件夹）
         */
        File parent = new File("E:\\school\\javaclass\\onlinelearned\\code\\" +
         "onlineProject02\\myfile\\src\\com\\itheima\\testfiles");
        File[] files = parent.listFiles();
        for(File f: files){
            if(f.isFile() && f.getName().endsWith(".avi")) System.out.println(f);
        }
    }
}
