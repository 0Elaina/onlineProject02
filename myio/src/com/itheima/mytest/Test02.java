package com.itheima.mytest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Test02 {
    public static void main(String[] args) throws IOException{
        /*
        为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
        加密原理：
        对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
        解密原理：
        读取加密之后的文件，按照加密的规则反向操作，变成原始文件。
         */
        File orginFile = new File("myio\\src\\com\\itheima\\testFiles\\testmovie1.mp4");
        File destFile = new File("myio\\src\\com\\itheima\\testFiles\\encrytestmovie1.mp4");
        encryptFile(orginFile, destFile);
        decryptFile(destFile, new File("myio\\src\\com\\itheima\\testFiles\\testmovie11.mp4"));

    }
    public static void encryptFile(File originFile, File destFile) throws IOException{
        FileInputStream fis = new FileInputStream(originFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        int b;
        while((b = fis.read()) != -1){
            fos.write(b ^ 2);
        }
        fos.close();
        fis.close();
    }

    public static void decryptFile(File originFile, File destFile) throws IOException{
        encryptFile(originFile, destFile);
    }
}
