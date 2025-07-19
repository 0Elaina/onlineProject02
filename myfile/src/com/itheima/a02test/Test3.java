package com.itheima.a02test;

import java.io.File;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException{
        /*
         * 需求：
         * 找到电脑中所有以avi结尾的电影。（需要考虑子文件夹）
         */
        File f = new File("C:\\");
        findAVI(f);

        
    }
    public static void findAVI(){
        File[] allDisks = File.listRoots();
        for(File disk: allDisks){
            findAVI(disk);
        }
    }

    public static void findAVI(File f){
        File[] files = f.listFiles();
        if(files != null){
            for(File file: files){
                if(file.isFile() && file.getName().endsWith(".mp4")) System.out.println(file);
                else findAVI(file);
            }
        }
    }
}
