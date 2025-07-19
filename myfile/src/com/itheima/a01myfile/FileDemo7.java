package com.itheima.a01myfile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo7 {
    public static void main(String[] args) {
        File file = new File("E:\\school\\javaclass\\onlinelearned\\code" +
                "\\onlineProject02\\myfile\\src\\com\\itheima\\testfiles");
        String[] arr = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                return src.isFile() && name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(arr));

        String[] arr1 = file.list((File dir, String name) -> {
            File src = new File(dir, name);
            return src.isFile() && name.endsWith(".txt");
        });
        System.out.println(Arrays.toString(arr1));

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".txt")) System.out.print(f + "   ");
        }
    }
}
