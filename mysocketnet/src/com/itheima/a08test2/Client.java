package com.itheima.a08test2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息

        Socket socket = new Socket("127.0.0.1", 25565);

        String str = "讲诵佛经嗯";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while((b = br.read()) != -1){
            System.out.print((char)b);
        }

        socket.close();
    }
}
