package com.itheima.a01myfunction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FunctionDemo4another {
    public static void main(String[] args) {
        new myUI1();
    }
}

class myUI1 extends myJFrame{
    JButton button = new JButton("点击");
    public myUI1(){
        initJFrame();

        initView();
        this.setVisible(true);
    }

    public void initJFrame(){
        this.setTitle("test");
        this.setSize(350, 500);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initView(){
        button.setBounds(150, 300, 100, 30);

        button.addActionListener(super::method);
        this.getContentPane().add(button);
    } 
};

class myJFrame extends JFrame{
    public void method(ActionEvent e){
        System.out.println(6);
    }
};
