package com.itheima.mytest;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Test08 {
    public static void main(String[] args) throws IOException{
        //需求：
        //将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
        Student stu1 = new Student("zhangsan", 23, "nanjing");
        Student stu2 = new Student("lisi", 24, "changchun");
        Student stu3 = new Student("wangwu", 25, "shanghai");

        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list, stu1, stu2, stu3);

        ObjectOutputStream oos = new ObjectOutputStream
        (new FileOutputStream("myio\\src\\com\\itheima\\testFiles\\222\\ccc.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
