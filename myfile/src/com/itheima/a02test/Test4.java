package com.itheima.a02test;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {
        //删除一个多级文件夹
        File path = new File("D:\\aaa\\src");
        delete(path);
    }

    public static void delete(File path){
        File[] files = path.listFiles();
        for(File file: files){
            if(file.isFile()) file.delete();
            else delete(file);
        }
        path.delete();
    }
}
