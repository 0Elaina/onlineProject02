package com.itheima.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessageDemo3 {
    //组播接收端
    public static void main(String[] args) throws IOException {
        //创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket(25565);

        //将当前本机添加到224.0.0.1这一组中
        InetAddress address = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(address);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ms.receive(dp);

        int len = dp.getLength();
        String str = new String(dp.getData(), 0, len);
        String ip = dp.getAddress().getHostAddress();
        String hostName = dp.getAddress().getHostName();

        System.out.println("ip: " + ip + ", hostName: " + hostName + ", message: " + str);

        ms.close();
    }
}
