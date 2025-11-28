package com.itheima.a02upddemo;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象
        //细节：
        //绑定端口，通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用
        //有参：指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        String str = "睡觉哦给机会佛奥韩国";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 25565);

        //3.发送数据
        ds.send(dp);

        //4.释放资源
        ds.close();
    }
}
