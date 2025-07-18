package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo5 {
    /*
    集合里面存储姓名和年龄，比如：张无忌，15
    要求：将数据封装成Student对象并收集到List集合中
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13",
                "张强,20", "张三丰,100", "张翠山,40", "张良,35", "王二麻子,37");
        
        
        list.stream().map(Student::new).forEach(System.out::println);
    }
}

class Student{
    private String name;
    private int age;

    public Student(){}

    public Student(String message){
        this.name = message.split(",")[0];
        this.age = Integer.parseInt(message.split(",")[1]);
    }

    public Student(String name, int age){
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

    public String getStudentString(){
        return name + "-" + age;
    }

    public String toString(){
        return "Student{name = " + name + ", age = " + age + "}";
    }
};
