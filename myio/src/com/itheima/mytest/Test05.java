package com.itheima.mytest;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class Test05 {
    public static void main(String[] args) throws IOException{
        //四种方式拷贝文件，并统计各自用时
        File file = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        File target1 = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy1.mp4");
        File target2 = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy2.mp4");
        File target3 = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy3.mp4");
        File target4 = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1copy4.mp4");

        byteCopy(file, target1);
        bytesCopy(file, target2);
        bufferedByteCopy(file, target3);
        bufferedBytesCopy(file, target4);


    }
    public static void byteCopy(File file, File target) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(target);
        int b;
        long beginTime = System.currentTimeMillis();
        while((b = fis.read()) != -1){
            fos.write(b);
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        long result = endTime - beginTime;
        System.out.println("基本流一次读取一个字节复制用时：" + result + "ms");
    }

    public static void bytesCopy(File file, File target) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(target);
        byte[] bytes = new byte[1024];
        int len;
        long beginTime = System.currentTimeMillis();
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
        long endTime = System.currentTimeMillis();
        long result = endTime - beginTime;
        System.out.println("基本流一次读取一个字节数组复制耗时：" + result + "ms");
    }

    public static void bufferedByteCopy(File file, File target) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        int b;
        long beginTime = System.currentTimeMillis();
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        long result = endTime - beginTime;
        System.out.println("缓冲流一次读取一个字节复制耗时：" + result + "ms");
    }

    public static void bufferedBytesCopy(File file, File target) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        byte[] bytes = new byte[1024];
        int len;
        long beginTime = System.currentTimeMillis();
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
        long endTime = System.currentTimeMillis();
        long result = endTime - beginTime;
        System.out.println("缓冲流一次读取一个字节数组复制耗时：" + result + "ms");
    }

}

