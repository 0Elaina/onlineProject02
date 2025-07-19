package com.itheima.a02test;

import java.io.File;
import java.io.IOException;

public class Test1{
    // 在当前模块下的aaa文件夹中创建一个a.txt文件
    public static void main(String[] args) throws IOException {
        File parent = new File("E:\\school\\javaclass\\onlinelearned\\code\\" +
         "onlineProject02\\myfile\\src\\com\\itheima\\testfiles\\aaa");
        String child = "a.txt";
        File targetFile = new File(parent, child);
        System.out.println(targetFile.createNewFile());
    }
}
