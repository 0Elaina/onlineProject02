package com.itheima.mybytestream2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        FileOutputStream fos = new FileOutputStream("myio\\src\\com\\itheima\\testFiles\\testmovie1copy.mp4", true);
        byte[] bytes = new byte[1024 * 2];
        int len;
        long beginTime = System.currentTimeMillis();
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
        System.out.println((System.currentTimeMillis() - beginTime));
    }
}
