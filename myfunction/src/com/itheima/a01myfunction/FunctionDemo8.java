package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.function.Function;

public class FunctionDemo8 {
    public static void main(String[] args) {
        /*
         * 集合中存储一些字符串的数据，比如：张三，23。
         * 收集到Student类型的数组当中
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13",
                "张强,20", "张三丰,100", "张翠山,40", "张良,35", "王二麻子,37");

        list.stream().map(new Function<String, Student0>(){
            @Override
            public Student0 apply(String str){
                return new Student0(str.split(",")[0], Integer.parseInt(str.split(",")[1]));
            }
        }).toArray(new IntFunction<Student0[]>(){
            @Override
            public Student0[] apply(int value){
                return new Student0[value];
            }
        });
        

        Student0[] arr = list.stream().map(Student0::new).toArray(Student0[]::new);
        System.out.println(Arrays.toString(arr));
    }
}

class Student0{
    private String name;
    private int age;

    Student0(){}

    Student0(String message){
        this.name = message.split(",")[0];
        this.age = Integer.parseInt(message.split(",")[1]);
    }

    Student0(String name, int age){
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