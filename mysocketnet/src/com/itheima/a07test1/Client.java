package com.itheima.a07test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 25565);
        OutputStream os = socket.getOutputStream();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的信息：");
            String str = sc.nextLine();
            if ("exit".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }
        socket.close();
    }
}
