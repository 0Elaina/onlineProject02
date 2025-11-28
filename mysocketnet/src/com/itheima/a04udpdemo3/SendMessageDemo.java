package com.itheima.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //组播发送端
        //创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket();

        String str = "soihgosjg";
        InetAddress address = InetAddress.getByName("224.0.0.1");
        byte[] bytes = str.getBytes();
        int port = 25565;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
        ms.send(dp);

        ms.close();
    }
}
