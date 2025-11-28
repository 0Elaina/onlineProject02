package com.itheima.a10test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        //防止文件重名
        ServerSocket ss = new ServerSocket(25565);
        Socket socket = ss.accept();

        String fileName = UUID.randomUUID().toString().replace("-", "");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                "mysocketnet/src/com/itheima/a10test4/serverdir/" + fileName + ".jpg"
        ));
        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.flush();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        bos.close();
        socket.close();
        ss.close();
    }
}
