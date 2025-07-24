package com.itheima.mycharstream1;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException{
        /*
        第一步：创建对象
        public FileReader(File file)                            创建字符输入流关联本地文件
        public FileReader(String pathname)                      创建字符输入流关联本地文件

        第二步：读取数据
        public int read()                                       读取数据，读到末尾返回-1
        public int read(char[] buffer)                          读取多个数据，读到末尾返回-1
        
        第三步：释放资源
        public void close()                                     释放资源/关流
         */
        FileReader fr = new FileReader(new File("myio\\src\\com\\itheima\\testFiles\\a.txt"));
        int ch;
        //read()默认是一个字节一个字节读取的，如果遇到中文就会一次读取多个
        //读取之后，方法的底层还会进行解码并转成十进制
        while((ch = fr.read()) != -1){
            System.out.print((char)ch);
        }
        fr.close();
        System.out.println();
        System.out.println("-----------------------------------");

        FileReader frd = new FileReader("myio\\src\\com\\itheima\\testFiles\\a.txt");
        int len;
        char[] chars = new char[2];
        //read(chars)：读取数据，解码，强转三步合并了，把强转之后的字符放到数组中
        while((len = frd.read(chars)) != -1){
            System.out.print(new String(chars, 0, len));
        }
        frd.close();
    }
}
