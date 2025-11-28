package com.itheima.a10test4;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        UUID name = UUID.randomUUID();
        System.out.println(name);
        System.out.println(name.toString().replace("-", ""));
    }
}
