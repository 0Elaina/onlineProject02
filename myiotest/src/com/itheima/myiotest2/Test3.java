package com.itheima.myiotest2;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Test3 {
    public static void main(String[] args) throws IOException{
        /*
         * 一个文件里面存储了班级同学的姓名，每一个姓名占一行。
         * 要求通过程序实现随机点名器。
         * 第三次必定是张三同学
         */
        //阙棋奥
        File allNamesFile = new File("myiotest\\src\\com\\itheima\\testFiles\\names.txt");
        ArrayList<String> allNamesList = getNamesList(allNamesFile);
        callRoll(allNamesList);
    }

    private static ArrayList<String> getNamesList(File allNamesFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(allNamesFile));
        ArrayList<String> allNamesList = new ArrayList<>();
        String stu;
        while((stu = br.readLine()) != null){
            allNamesList.add(stu.split("-")[0]);
        }
        return allNamesList;
    }

    private static void callRoll(ArrayList<String> allNamesList) throws IOException {
        Collections.shuffle(allNamesList);
        BufferedReader br = new BufferedReader(new FileReader("myiotest\\src\\com\\itheima\\myiotest2\\Test3ResultNames.txt"));
        int count = Integer.parseInt(br.readLine().substring(6)) + 1;
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\src\\com\\itheima\\myiotest2\\Test3ResultNames.txt"));
        if(count % 3 == 0){
            bw.write("count=" + count);     bw.newLine();
            bw.write("阙棋奥");  bw.newLine();
        }else{
            bw.write("count=" + count);     bw.newLine();
            bw.write(allNamesList.get(0));         bw.newLine();
        }
        bw.close();
    }
}
