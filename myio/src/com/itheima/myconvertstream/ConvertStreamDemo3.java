package com.itheima.myconvertstream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //将本地文件中的GBK文件，转成UTF-8

        //jdk11以前的方案
        InputStreamReader fsr = new InputStreamReader
                (new FileInputStream("myio/src/com/itheima/testFiles/222/zzz.txt"), "GBK");
        OutputStreamWriter fsw = new OutputStreamWriter
                (new FileOutputStream("myio/src/com/itheima/testFiles/222/zzz.txt"), "UTF-8");
        int b;
        while((b = fsr.read()) != -1){
            fsw.write(b);
        }
        fsw.close();
        fsr.close();


        //jdk11以后的方案
        FileReader fr = new FileReader
                ("myio/src/com/itheima/testFiles/222/zzz.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter
                ("myio/src/com/itheima/testFiles/222/bbb.txt", Charset.forName("UTF-8"));
        int c;
        while ((c = fr.read()) != -1){
            fw.write(c);
        }
        fr.close();
        fw.close();

    }
}
