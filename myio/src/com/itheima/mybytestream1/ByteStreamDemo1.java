package com.itheima.mybytestream1;

import java.io.IOException;
import java.io.FileOutputStream;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("myio\\src\\com\\itheima\\testFiles\\a.txt");
        fos.write(95);
        fos.close();
    }
}
