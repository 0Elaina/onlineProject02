package com.itheima.a02test;

import java.io.File;

public class Test5 {
    public static void main(String[] args) {
        //统计一个文件夹的总大小
        File path = new File("E:\\school\\javaclass\\onlinelearned\\code\\"
        + "onlineProject02\\myfile\\src\\com\\itheima");
        System.out.println(getDirSize(path));
    }

    public static long getDirSize(File path){
        long size = 0;
        File[] files = path.listFiles();
        for(File file: files){
            if(file.isFile()) size = size + file.length();
            else size = size + getDirSize(file);
        }
        return size;
    }
}
