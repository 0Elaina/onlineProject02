package com.itheima.myiotest3;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class Test1 {
    static ArrayList<Student> allStusList;
    static double[] personalWeightArr;
    static File allStusFile = new File("myiotest\\src\\com\\itheima\\myiotest3\\names.txt");
    public static void main(String[] args) throws IOException {
        /*
         * TXT文件中事先准备好一些学生信息，每个学生的信息独占一行。
         * 要求1：每次被点到的学生，再次被点到的概率在原先的基础上降低一半。
         * 举例：80个学生，点名5次，每次都点到小A，概率变化情况如下：
         * 第一次每人概率：1.25%。
         * 第二次小A概率：0.625%。
         * 其他学生概率：1.2579%
         * 第三次小A概率：0.3125%。
         * 其他学生概率：1.261867%
         * 第四次小A概率：0.15625%。
         * 其他学生概率：1.2638449%
         * 第五次小A概率：0.078125%。
         * 其他学生概率：1.26483386%
         * 提示：本题的核心就是带权重的随机
         */
        allStusList = getStusList();
        int count = 0;
        while(count < 30){
            callRoll();
            count++;
        }
    }

    private static ArrayList<Student> getStusList() throws IOException {
        ArrayList<Student> allStusList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(allStusFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] stuArr = line.split("-");
            Student stu = new Student(stuArr[0], stuArr[1], Integer.parseInt(stuArr[2]), Double.parseDouble(stuArr[3]));
            allStusList.add(stu);
        }
        br.close();
        return allStusList;
    }

    private static double getWeightSum(){
        double weightSum = 0;
        for(Student stu: allStusList){
            weightSum = weightSum + stu.getWeight();
        }
        return weightSum;
    }

    private static double[] getPersonalWeight(double weightSum){
        //计算每一个人的实际占比
        double[] personalWeightArr = new double[allStusList.size()];
        for(int i = 0; i < personalWeightArr.length; i++){
            personalWeightArr[i] = allStusList.get(i).getWeight() / weightSum;
        }

        //计算每一个人的权重占比范围
        for(int i = 1; i < personalWeightArr.length; i++){
            personalWeightArr[i] = personalWeightArr[i - 1] + personalWeightArr[i];
        }
        return personalWeightArr;
    }

    private static void callRoll() throws IOException{
        //计算权重总和
        double weightSum = getWeightSum();
        //计算每一个人的实际占比范围
        personalWeightArr = getPersonalWeight(weightSum);


/*        Random r = new Random();
        double number = r.nextDouble();*/
        double number = Math.random();
        int position = getPosition(number);

        //修改当前学生的权重
        Student stu = allStusList.get(position);
        System.out.println(stu);
        stu.setWeight(stu.getWeight() / 2);
        BufferedWriter bw = new BufferedWriter(new FileWriter(allStusFile));
        for(Student student: allStusList){
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();
    }

    private static int getPosition(double number){
        int beginIndex = 0; int endIndex = personalWeightArr.length - 1; int midIndex;
        while(beginIndex <= endIndex){
            midIndex = (beginIndex + endIndex) / 2;
            if(number < personalWeightArr[midIndex]){
                if(midIndex == 0 || number > personalWeightArr[midIndex - 1]){
                    return midIndex;
                }
                endIndex = midIndex - 1;
            }else{
                beginIndex = midIndex + 1;
            }
        }
        return -1;
    }


}
