package com.itheima.myobjectstream;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
         * 需求:
         * 利用反序列化流/对象操作输入流，把文件中中的对象读到程序当中
         * 构造方法：
         * public ObjectInputStream(InputStream out)                把基本流变成高级流
         * 
         * 成员方法：
         * public Object readObject()                               把序列化到本地文件中的对象，读取到程序中来
         */
        ObjectInputStream ois = new ObjectInputStream
        (new FileInputStream("myio\\src\\com\\itheima\\testFiles\\222\\ccc.txt"));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
    }
}
