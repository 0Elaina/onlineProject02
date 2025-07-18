package com.itheima.a01myfunction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FunctionDemo4 {
    public static void main(String[] args) {
        new myUI();
    }
}

class myUI extends JFrame {

    JButton button = new JButton("点击");
    public myUI(){
        initJFrame();

        initView();
        this.setVisible(true);
    }

    public void initJFrame(){
        this.setTitle("test");
        this.setAlwaysOnTop(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    public void initView(){
        button.setBounds(250, 300, 100, 30);

        button.addActionListener(this::method);
        this.getContentPane().add(button);
    }

    public void method(ActionEvent e) {
        if(e.getSource() == button) System.out.println(6);
    }
}
