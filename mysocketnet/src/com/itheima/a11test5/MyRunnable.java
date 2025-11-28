package com.itheima.a11test5;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {
    Socket socket;

    MyRunnable(Socket socket) {this.socket = socket;}

    @Override
    public void run() {
        try {
            String fileName = UUID.randomUUID().toString().replace("-", "");
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                    "mysocketnet/src/com/itheima/a11test5/serverdir/" + fileName + ".jpg"
            ));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            bos.flush();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();
            bos.close();
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
