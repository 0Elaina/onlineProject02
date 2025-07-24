package com.itheima.mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("myio\\src\\com\\itheima\\testFiles\\testmovie1copy.mp4");
        FileInputStream fis = new FileInputStream("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        int b;
        long beginTime = System.nanoTime();
        while((b = fis.read()) != -1){
            fos.write(b);
        }
        fis.close();
        fos.close();
        long endTime = System.nanoTime();
        System.out.println((endTime - beginTime) / 1000 / 1000 / 1000);
        
    }
}
