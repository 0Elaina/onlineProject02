package com.itheima.a05udpdemo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(25565);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);

        int len = dp.getLength();
        String str = new String(dp.getData(), 0, len);
        String ip = dp.getAddress().getHostAddress();
        String hostName = dp.getAddress().getHostName();
        int port = dp.getPort();

        System.out.println("ip: " + ip + ", hostName: " + hostName + ", port: " + port + ", message: " + str);
    }
}
