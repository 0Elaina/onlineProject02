package com.itheima.mytest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Test04 {
    public static void main(String[] args) throws IOException {
        /*
        文本文件中有以下的数据：
        2-1-9-4-7-8
        将文件中的数据进行排序，变成以下的数据：
        1-2-4-7-8-9
         */
        FileReader fr = new FileReader("myio\\src\\com\\itheima\\testFiles\\111\\a.txt");
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }
        fr.close();
        Integer[] arr = Arrays.stream(sb.toString()
                        .split("-"))
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                }).sorted().toArray(Integer[]::new);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
