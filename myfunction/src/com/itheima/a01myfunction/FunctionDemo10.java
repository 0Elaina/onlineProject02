package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.Arrays;

public class FunctionDemo10 {
    /*
    需求:
    创建集合添加学生对象
    学生对象属性：name，age
    
    要求：
    把姓名和年龄拼接成：张三-23的字符串，并放到数组当中
    使用方法引用完成
     */
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = new Student("lisi", 24);
        Student stu3 = new Student("wangwu", 25);

        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list, stu1, stu2, stu3);

        list.stream().map(new Function<Student, String>(){
            @Override
            public String apply(Student stu){
                return stu.getName() + "-" + stu.getAge();
            }
        }).toArray(new IntFunction<String[]>(){
            @Override
            public String[] apply(int value){
                return new String[value];
            }
        });

        String[] arr = list.stream().map(Student::getStudentString).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
