package com.itheima.mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("myio\\src\\com\\itheima\\testFiles\\a.txt");
        System.out.println(fis.read());
        fis.close();
    }
}
