package com.itheima.myconvertstream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException{
        //利用转换流按照指定字符编码读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\src\\com\\itheima\\testFiles\\222\\gbkfile.txt"), "GBK");
        int b;
        while((b = isr.read()) != -1){
            System.out.print((char)b);
        }
        isr.close();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();

        FileReader fr = new FileReader("myio\\src\\com\\itheima\\testFiles\\222\\gbkfile.txt", Charset.forName("GBK"));
        while((b = fr.read()) != -1){
            System.out.print((char)b);
        }
        fr.close();
    }
}
