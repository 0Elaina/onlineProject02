package com.itheima.a10test4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 25565);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "mysocketnet/src/com/itheima/a10test4/clientdir/NEPV2-Steam-Wallpaper-1920x1080_3.jpg"
        ));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }

        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);

        bis.close();
        socket.close();
    }
}
