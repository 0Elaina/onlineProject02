package com.itheima.mytest;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class Test01 {
    public static void main(String[] args) throws IOException{
        //拷贝一个文件夹，考虑子文件夹
        File src = new File("myio\\src\\com\\itheima\\testFiles");
        File dest = new File("myio\\src\\com\\itheima\\dest");
        copyDir(src, dest);
    }

    public static void copyDir(File src, File dest) throws IOException{
        dest.mkdirs();
        File[] files = src.listFiles();
        for(File file: files){
            if(file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            }else{
                copyDir(file, new File(dest, file.getName()));
            }

        }
    }
}
