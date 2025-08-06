package com.itheima.myconvertstream;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException{
        //利用字节流读取文件中的数据，每次读一整行，而且不能出现乱码
        BufferedReader bis = new BufferedReader(new InputStreamReader
        (new FileInputStream("myio\\src\\com\\itheima\\testFiles\\222\\zzz.txt"), "GBK"));
        String str;
        while((str = bis.readLine()) != null){
            System.out.println(str);
        }
        bis.close();
    }
}
