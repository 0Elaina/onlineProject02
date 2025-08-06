package com.itheima.myzipstream;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException{
        File src = new File("myio\\src\\com\\itheima\\testFiles\\111\\a.txt");
        File dest = new File("myio\\src\\com\\itheima\\testFiles\\111");
        toZip(src, dest);
    }
    public static void toZip(File src, File dest) throws IOException{
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "a.zip")));
        ZipEntry entry = new ZipEntry("a.txt");
        zos.putNextEntry(entry);
        int b;
        FileInputStream fis = new FileInputStream(src);
        while((b = fis.read()) != -1){
            zos.write(b);
        }
        fis.close();
        zos.closeEntry();
        zos.close();
    }
}
