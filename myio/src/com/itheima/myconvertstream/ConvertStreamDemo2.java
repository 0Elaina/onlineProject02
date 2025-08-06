package com.itheima.myconvertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException{
        //利用转换流按照指定字符编码写出
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream
                ("myio\\src\\com\\itheima\\testFiles\\222\\gbkfile.txt", true), "GBK");
        osw.write("/r/n");
        osw.write("ogsjgosjgosd");
        osw.close();

        File file = new File("myio\\src\\com\\itheima\\testFiles\\222\\zzz.txt");
        FileWriter fw = new FileWriter(file, Charset.forName("GBK"));
        fw.write("akfpofjalojfoa");
        fw.write("哦设计公司你哦i就");
        fw.close();

    }
}
