package com.itheima.mydynamicproxy1;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("chicken");
        Star star = ProxyUtil.createProxy(bigStar);

        String result = star.sing("jinitaimei");
        System.out.println(result);

        System.out.println(star.dance());
    }
}
