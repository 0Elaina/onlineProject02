package com.itheima.a01myfile;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        /*
         * public File(String pathname)                 根据文件路径创建文件对象
         * public File(String parent, String child)     根据父路径名字符串和子路径名字符串创建文件对象
         * public File(File parent, String child)       根据父路径对应文件对象和子路径名字符串创建文件对象
         */

        File file = new File("E:\\school\\javaclass\\onlinelearned\\code\\" +
                 "onlineProject02\\myfile\\src\\com\\itheima\\a01myfile\\a.txt");
        System.out.println(file);

        String parent = "E:\\school\\javaclass\\onlinelearned\\code\\onlineProject02\\myfile\\src\\com\\itheima\\a01myfile";
        String child = "a.txt";
        File file1 = new File(parent, child);
        System.out.println(file1);

        File parent1 = new File("E:\\school\\javaclass\\onlinelearned\\code\\onlineProject02\\myfile\\src\\com\\itheima\\a01myfile");
        File file2 = new File(parent1, child);
        System.out.println(file2);

    }
}
