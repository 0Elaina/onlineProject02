package com.itheima.myiotest2;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
         * 需求:
         * 有一个文件里面存储了班级同学的信息，每一个信息占一行。
         * 格式为：张三-男-23
         * 要求通过程序实现随机点名器。
         */
        File allNamesFile = new File("myiotest\\src\\com\\itheima\\testFiles\\names.txt");
        System.out.println(callRoll(allNamesFile));
    }

    private static String callRoll(File allNamesFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(allNamesFile));
        ArrayList<String> namesList = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            namesList.add(str);
        }
        br.close();
        Collections.shuffle(namesList);
        return namesList.get(0).split("-")[0];
    }
}
