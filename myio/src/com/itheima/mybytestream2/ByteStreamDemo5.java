package com.itheima.mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException{
        //一次读取多个字节
        FileInputStream fis = new FileInputStream("myio\\src\\com\\itheima\\testFiles\\a.txt");
        byte[] bytes = new byte[2];
        int len;
        while((len = fis.read(bytes)) != -1){
            System.out.print(new String(bytes,0,len));
        }
        fis.close();
    }
}
