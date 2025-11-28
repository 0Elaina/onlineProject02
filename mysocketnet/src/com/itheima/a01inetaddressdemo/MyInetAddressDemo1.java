package com.itheima.a01inetaddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        /*
        static InetAddress getByName(String host)                   确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
        String getHostName()                                        获取此IP地址的主机名
        String getHostAddress()                                     返回文本显示中的IP地址字符串
         */
        InetAddress address = InetAddress.getByName("LAPTOP-TJSJHLUM");
        System.out.println(address);

        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
