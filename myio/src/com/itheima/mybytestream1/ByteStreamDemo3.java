package com.itheima.mybytestream1;

import java.io.IOException;
import java.io.FileOutputStream;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException{
        //换行和续写
        FileOutputStream fos = new FileOutputStream("myio\\src\\com\\itheima\\testFiles\\a.txt", true);//打开续写开关

        String wrap = "\r\n";
        fos.write(wrap.getBytes());
        String str = "ojaojogjaoijgaosdije";
        byte[] bytes = str.getBytes();
        fos.write(bytes);

        fos.close();
    }
}
