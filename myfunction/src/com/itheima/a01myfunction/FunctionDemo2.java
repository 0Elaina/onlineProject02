package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5");

        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }
}
