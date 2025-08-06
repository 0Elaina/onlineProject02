package com.itheima.mybufferedstream1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferedStreamDemo3 {
    /*
    字符缓冲输入流：
    构造方法：
    public BufferedReader(Reader r)
    
    特有方法：
    public String readLine()            读一整行
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("myio\\src\\com\\itheima\\testFiles\\a.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            /*
             * readLine方法在读取的时候，一次读一整行，遇到回车换行结束
             * 但是他不会把回车换行读到内存当中
             */
            System.out.println(line);
        }
        br.close();
    }
}
