package com.itheima.a08test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(25565);

        Socket socket = ss.accept();

        int b;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while((b = br.read()) != -1){
            System.out.print((char)b);
        }

        OutputStream os = socket.getOutputStream();
        String str = "解耦i妇女上来看";
        os.write(str.getBytes());

        socket.close();
        ss.close();
    }
}
