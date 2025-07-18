package com.itheima.a01mystream;

import java.util.stream.Stream;

public class StreamDemo5 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5).forEach(num -> System.out.print(num + " "));
    }
}
