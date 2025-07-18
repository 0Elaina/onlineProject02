package com.itheima.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.IntFunction;

public class FunctionDemo7 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);

        list.stream().toArray(new IntFunction<Integer[]>(){
            @Override
            public Integer[] apply(int value){
                return new Integer[0];
            }
        });

        list.stream().toArray(Integer[]::new);
    }
}
