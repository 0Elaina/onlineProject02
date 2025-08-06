package com.itheima.mytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test06 {
    public static void main(String[] args) throws IOException{
        //需求：把《出师表》的文章顺序进行恢复到一个新文件中。
        BufferedReader br = new BufferedReader(new FileReader("myio\\src\\com\\itheima\\testFiles\\111\\csb.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\com\\itheima\\testFiles\\111\\newcsb.txt"));
        String line;
        HashMap<Integer, String> hm = new HashMap<>();
        while((line = br.readLine()) != null){
            hm.put(Integer.parseInt(line.substring(0,1)), line);
        }
        Set<Integer> s = hm.keySet();
        for(Integer i: s){
            bw.write(hm.get(i));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
