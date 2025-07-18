package com.itheima.a01myfunction;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionDemo1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 9, 7, 5};

        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });

        Arrays.sort(arr, (o1, o2) -> o1 - o2);

        Arrays.sort(arr, FunctionDemo1::subtraction);

        System.out.println(Arrays.toString(arr));
    }
    public static int subtraction(int o1, int o2){
        return o2 - o1;
    }
}
