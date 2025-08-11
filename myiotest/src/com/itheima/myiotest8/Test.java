package com.itheima.myiotest8;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        保存格式为:username=zhangsan&password=123&count=0
        让用户键盘录入用户名和密码
        比较用户录入的和正确的用户名密码是否一致
        如果一致则打印登陆成功
        如果不一致则打印登陆失败，连续输错三次被锁定
         */
        BufferedReader br = new BufferedReader(new FileReader("myiotest\\src\\com\\itheima\\myiotest8\\userinfo.txt"));
        String rightMessage = br.readLine();
        br.close();
        String rightUsername = rightMessage.split("&")[0].split("=")[1];
        String rightPassword = rightMessage.split("&")[1].split("=")[1];
        int count = Integer.parseInt(rightMessage.split("&")[2].split("=")[1]);

        if (count == 3) {
            System.out.println("错误次数太多，账号已锁定");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String username = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (username.equals(rightUsername) && password.equals(rightPassword)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
                count++;
                System.out.println("目前还有" + (3 - count) + "次登录机会");
                BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\src\\com\\itheima\\myiotest8\\userinfo.txt"));
                bw.write("username=" + rightUsername + "&password=" + rightPassword + "&count=" + count);
                bw.close();
            }
        }
    }
}
