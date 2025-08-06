package com.itheima.mybufferedstream1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException{
        File file = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        File target = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy.mp4");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        byte[] bytes = new byte[100];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }
}
