package com.itheima.mybufferedstream1;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException{
        /*
        需求:
        利用字节缓冲流拷贝文件
        字节缓冲输入流的构造方法：                           public BufferedInputStream(InputStream is)
        字节缓冲输出流的构造方法：                           public BufferedOutputStream(OutputStream os)
         */
        File file = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        File target = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy.mp4");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }
}
