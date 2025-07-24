package com.itheima.mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException{
        //循环读取
        FileInputStream fis = new FileInputStream("myio\\src\\com\\itheima\\testFiles\\a.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
        fis.close();
    }
}
