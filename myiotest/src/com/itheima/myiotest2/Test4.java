package com.itheima.myiotest2;

import cn.hutool.core.lang.hash.Hash;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public class Test4 {
    public static void main(String[] args) throws IOException {
        /*
        被点到的学生不会再被点到
        如果班级中所有的学生都点完了，需要自动的重新开启第二轮点名
        细节1：假设班级有10个学生，每一轮中每一位学生只能被点到一次，程序运行10次，第一轮结束
        细节2：第11次运行的时候，我们自己不需要手动操作本地文件，要求程序自动开始第二轮点名
         */
        File allNamesFile = new File("myiotest/src/com/itheima/testFiles/names.txt");
        HashSet<String> allNamesSet = getNamesSet(allNamesFile);
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest/src/com/itheima/myiotest2/Test4ResultNames.txt"));
        int count = 1;
        while(count <= 3){
            String callCount = "-----------------第 " + count + " 次点名------------------------";
            bw.write(callCount);
            bw.newLine();
            System.out.println(callCount);
            callRoll(allNamesSet, bw);
            count++;
        }
        bw.close();
    }
    private static HashSet<String> getNamesSet(File allNamesFile) throws IOException {
        HashSet<String> allNamesSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(allNamesFile));
        String name;
        while((name = br.readLine()) != null){
            allNamesSet.add(name.split("-")[0]);
        }
        return allNamesSet;
    }

    private static void callRoll(HashSet<String> allNamesSet, BufferedWriter bw) throws IOException {
        ArrayList<String> allNamesList = new ArrayList<>(allNamesSet.stream().toList());
        Collections.shuffle(allNamesList);
        for(String name : allNamesList){
            bw.write(name);
            bw.newLine();
        }
    }
}
