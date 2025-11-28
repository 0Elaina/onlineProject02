package com.itheima.a11test5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(25565);

        while(true){
            Socket socket = ss.accept();
            MyRunnable mr =  new MyRunnable(socket);

            new Thread(mr).start();
        }
    }
}
