package com.itheima.myzipstream;

import java.util.zip.ZipInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException{
        File src = new File("myio\\src\\com\\itheima\\testFiles\\333\\ggg.zip");
        File dest = new File("myio\\src\\com\\itheima\\testFiles\\333");
        unZip(src, dest);
    }
    public static void unZip(File src, File dest) throws IOException{
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry;
        while((entry = zip.getNextEntry()) != null){
            if(entry.isDirectory()){
                File file = new File(dest, entry.toString());
                file.mkdirs();
            }else{
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while((b = zip.read()) != -1){
                    fos.write(b);
                }
                fos.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }
}
