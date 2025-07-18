package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionDemo9 {
    public static void main(String[] args) {
        /*
         * 需求：
         * 创建集合添加学生对象
         * 学生对象属性：name，age
         * 要求：
         * 获取姓名并放到数组当中
         * 使用方法引用完成
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan,23", "lisi,24", "wangwu,25");

        List<Student1> newList = list.stream().map(new Function<String, Student1>(){
            @Override
            public Student1 apply(String str){
                return new Student1(str.split(",")[0], Integer.parseInt(str.split(",")[1]));
            }
        }).collect(Collectors.toList());

        newList.stream().map(new Function<Student1, String>(){
            @Override
            public String apply(Student1 stu){
                return stu.getName();
            }
        }).toArray(new IntFunction<String[]>(){
            @Override
            public String[] apply(int value){
                return new String[value];
            }
        });

        String[] arr = newList.stream().map(Student1::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}

class Student1{
    private String name;
    private int age;

    public Student1(){}

    public Student1(String message){
        this.name = message.split(",")[0];
        this.age = Integer.parseInt(message.split(",")[1]);
    }

    public Student1(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
