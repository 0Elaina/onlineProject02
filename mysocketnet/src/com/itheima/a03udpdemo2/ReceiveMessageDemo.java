package com.itheima.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象
        DatagramSocket ds = new DatagramSocket(25565);

        //2.接收数据包
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);

            //3.解包数据
            int len = dp.getLength();
            String address = dp.getAddress().getHostAddress();
            String hostName = dp.getAddress().getHostName();
            int port = dp.getPort();
            String str = new String(dp.getData(), 0, len);

            System.out.println("ip为: " + address + ", 主机名为: " +
                    hostName + "的电脑从" + port + "端口发送了数据: " + str);
        }

    }
}
