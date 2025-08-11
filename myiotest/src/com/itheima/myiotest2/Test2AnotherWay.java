package com.itheima.myiotest2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test2AnotherWay {
    public static void main(String[] args) throws IOException {
        File allNamesFile = new File("myiotest\\src\\com\\itheima\\testFiles\\names.txt");
        ArrayList<Integer> percentList = new ArrayList<>();
        Collections.addAll(percentList, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        ArrayList<String> allNamesList = getNamesList(allNamesFile);
        ArrayList<String> boyList = getGenderList(allNamesList, "男");
        ArrayList<String> girlList = getGenderList(allNamesList, "女");
        int boyCount = 0; int girlCount = 0;
        for(int i = 0; i < 1000000; i++){
            Collections.shuffle(percentList);
            if(percentList.get(0) == 1){
                boyCount++;
                Collections.shuffle(boyList);
                System.out.println(boyList.get(0));
            }else{
                Collections.shuffle(girlList);
                System.out.println(girlList.get(0));
                girlCount++;
            }
        }
        System.out.println("--------------------------");
        System.out.println("Boy: " + boyCount);
        System.out.println("Girl: " + girlCount);
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
}
