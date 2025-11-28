package com.itheima.a09test3;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        // 服务器：接收客户端上传的文件，上传完毕之后给出反馈。
        Socket socket = new Socket("127.0.0.1", 25565);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "mysocketnet/src/com/itheima/a09test3/clientdir/NEPV2-Steam-Wallpaper-1920x1080_3.jpg"
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
