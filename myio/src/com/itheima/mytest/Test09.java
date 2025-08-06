package com.itheima.mytest;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream
        (new FileInputStream("myio\\src\\com\\itheima\\testFiles\\222\\ccc.txt"));
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
        for(Student stu: list){
            System.out.println(stu);
        }
        ois.close();
    }
}
