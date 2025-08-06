package com.itheima.myzipstream;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    public static void main(String[] args) throws IOException {
        File src = new File("myio\\src\\com\\itheima\\testFiles\\111");
        File destParent = src.getParentFile();
        File dest = new File(destParent, src.getName() + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        String name = src.getName();
        toZip(src, zos, name);

        zos.close();
    }

    public static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        ZipEntry entry = new ZipEntry(name + "\\");
        zos.putNextEntry(entry);
        zos.closeEntry();

        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    ZipEntry fileEntry = new ZipEntry(name + "\\" + file.getName());
                    zos.putNextEntry(fileEntry);
                    int b;
                    FileInputStream fis = new FileInputStream(file);
                    while ((b = fis.read()) != -1) {
                        zos.write(b);
                    }
                    fis.close();
                    zos.closeEntry();
                } else {
                    toZip(file, zos, name + "\\" + file.getName());
                }
            }
        }
    }
}
