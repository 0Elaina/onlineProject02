package com.itheima.mybytestream1;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException{
        /*
         * void write(int b)                            一次写一个字节数据
         * void write(byte[] b)                         一次写一个字节数组数据
         * void write(byte[] b, int off, int len)       一次写一个字节数组的部分数据
         */
        File file = new File("myio\\src\\com\\itheima\\testFiles\\a.txt");
        FileOutputStream fos = new FileOutputStream(file);

        byte[] arr = {97, 98, 99, 102, 99, 100, 105, 110};
        fos.write(arr);
        fos.write(arr, 2, 3);
        fos.close();
    }
}
