package com.itheima.myiotest2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
         * 一个文件里面存储了班级同学的信息，每一个学生信息占一行。
         * 格式为：张三-男-23。
         * 要求通过程序实现随机点名器。
         * 70%的概率随机到男生
         * 30%的概率随机到女生
         * 总共随机100万次，统计结果。
         */
        File allNamesFile = new File("myiotest\\src\\com\\itheima\\testFiles\\names.txt");
        ArrayList<String> allNamesList = getNamesList(allNamesFile);
        ArrayList<String> boyList = getGenderList(allNamesList, "男");
        ArrayList<String> girlList = getGenderList(allNamesList, "女");
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\src\\com\\itheima\\myiotest2\\Test2ResultNames.txt", true));
        int boyCount = 0; int girlCount = 0;
        for (int j = 0; j < 100000; j++) {
            ArrayList<String> callList = getCallList(boyList, girlList);
            for (int i = 0; i < 10; i++) {
                String stu = callList.get(i);
                String gender = stu.split("-")[1];
                if(gender.equals("男")) boyCount++;
                else girlCount++;
                String result = stu.substring(0, stu.length() - 5);
                bw.write(result);
                bw.newLine();
            }
        }
        bw.write("boyCount = " + boyCount); bw.newLine();
        bw.write("girlCount = " + girlCount); bw.newLine();
        bw.close();
        System.out.println("--------------------------");
        System.out.println("boyCount = " + boyCount);
        System.out.println("girlCount = " + girlCount);
    }

    private static ArrayList<String> getNamesList(File allNamesFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(allNamesFile));
        ArrayList<String> allNamesList = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            allNamesList.add(str);
        }
        br.close();
        return allNamesList;
    }

    private static ArrayList<String> getGenderList(ArrayList<String> allNamesList, String gender) {
        ArrayList<String> genderList = new ArrayList<>();
        for (String stu : allNamesList) {
            if (stu.split("-")[1].equals(gender)) {
                genderList.add(stu);
            }
        }
        return genderList;
    }

    private static ArrayList<String> getCallList(ArrayList<String> boyList, ArrayList<String> girlList) {
        Collections.shuffle(boyList);
        Collections.shuffle(girlList);
        ArrayList<String> callList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            callList.add(boyList.get(i));
        }
        for (int i = 0; i < 3; i++) {
            callList.add(girlList.get(i));
        }
        Collections.shuffle(callList);
        return callList;
    }
}
