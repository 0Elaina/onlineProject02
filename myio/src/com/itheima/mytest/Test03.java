package com.itheima.mytest;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Collections;
import java.util.ArrayList;
import java.io.IOException;
import java.util.StringJoiner;

public class Test03 {
    public static void main(String[] args) throws IOException{
        /*
        文本文件中有以下的数据：
        2-1-9-4-7-8
        将文件中的数据进行排序，变成以下的数据：
        1-2-4-7-8-9
         */
        FileReader fr = new FileReader("myio\\src\\com\\itheima\\testFiles\\111\\a.txt");
        StringBuilder sb = new StringBuilder();
        int b;
        while((b = fr.read()) != -1){
            sb.append((char)b);
        }
        fr.close();
        String str = sb.toString();
        String[] strArr = str.split("-");
        ArrayList<Integer> list = new ArrayList<>();
        for(String s: strArr){
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        StringJoiner sj = new StringJoiner("-");
        for(int i: list){
            sj.add(i + "");
        }
        String result = sj.toString();
        FileWriter fw = new FileWriter("myio\\src\\com\\itheima\\testFiles\\111\\a.txt");
        fw.write(result);
        fw.close();
    }
}
