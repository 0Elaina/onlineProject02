package com.itheima.mycharstream1;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException{
        /*
        void write(int c)                               写出一个字符
        void write(String str)                          写出一个字符串
        void write(String str, int off, int len)        写出一个字符串的一部分
        void write(char[] cbuf)                         写出一个字符数组
        void write(char[] cbuf, int off, int len)       写出字符数组的一部分
         */
        FileWriter fw = new FileWriter("myio\\src\\com\\itheima\\testFiles\\a.txt", true);
        fw.write(49543);
        fw.write("范吉奥激发哦好你ioo");
        fw.write("哦奥黑狗", 0, 2);
        char[] chars = {'a', 's', 's', 'g', '是', '和'};
        fw.write("\r\n");
        fw.write(chars);
        fw.write(chars, 0, 2);
        fw.close();
    }
}
