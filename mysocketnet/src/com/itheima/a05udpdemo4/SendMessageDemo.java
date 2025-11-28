package com.itheima.a05udpdemo4;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //广播发送端
        //不要运行这个代码
        DatagramSocket ds = new DatagramSocket();

        String str = "hsiofjsofj";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 25565);
        ds.send(dp);
        ds.close();
    }
}
