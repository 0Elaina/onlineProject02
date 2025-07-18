package com.itheima.ui;

import com.itheima.beans.User;
import com.itheima.util.CaptchaUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginJFrame extends JFrame implements MouseListener {

    private final JButton loginButton = new JButton();
    private final JButton registerButton = new JButton();
    private final JTextField userNameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JTextField captchaField = new JTextField();
    private final String rightCaptcha = CaptchaUtil.getCaptcha();
    private final JLabel rightCaptchaLabel = new JLabel();

    static ArrayList<User> allUsers = new ArrayList<>();

    static {
        User user1 = new User("zhangsan", "123");
        User user2 = new User("lisi", "456");

        allUsers.add(user1);
        allUsers.add(user2);
    }

    public LoginJFrame() {
        initJFrame();

        initView();

        this.setVisible(true);
    }

    public void initJFrame() {
        this.setTitle("斗地主 登录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(633, 423);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    public void initView() {
        //用户名文字
        Font userNameFont = new Font("宋体", Font.BOLD, 13);
        JLabel userNameLabel = new JLabel("用户名: ");
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setFont(userNameFont);
        userNameLabel.setBounds(140, 55, 55, 22);
        this.getContentPane().add(userNameLabel);

        //用户名输入框
        userNameField.setBounds(223, 46, 200, 30);
        this.getContentPane().add(userNameField);

        //密码文字
        JLabel passwordLabel = new JLabel("密码: ");
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setBounds(197, 95, 40, 22);
        this.getContentPane().add(passwordLabel);

        //密码输入框
        passwordField.setBounds(263, 87, 160, 30);
        this.getContentPane().add(passwordField);

        //验证码文字
        JLabel captchaLabel = new JLabel("验证码: ");
        captchaLabel.setBackground(Color.WHITE);
        captchaLabel.setBounds(215, 142, 55, 22);
        this.getContentPane().add(captchaLabel);

        //验证码输入框
        captchaField.setBounds(291, 133, 100, 30);
        this.getContentPane().add(captchaField);

        //正确的验证码
        Font rightCaptchaFont = new Font(null, 1, 15);
        rightCaptchaLabel.setForeground(Color.RED);
        rightCaptchaLabel.setFont(rightCaptchaFont);
        rightCaptchaLabel.setText(rightCaptcha);
        rightCaptchaLabel.setBounds(400, 133, 100, 30);
        this.getContentPane().add(rightCaptchaLabel);
        rightCaptchaLabel.addMouseListener(this);

        //登录按钮
        loginButton.setBounds(123, 310, 128, 47);
        loginButton.setIcon(new ImageIcon("fightAgainstLandlord\\src\\com\\itheima\\image\\login\\登录按钮.png"));
        //去除按钮边框
        loginButton.setBorderPainted(false);
        //取出按钮背景
        loginButton.setContentAreaFilled(false);
        loginButton.addMouseListener(this);
        this.getContentPane().add(loginButton);

        //6.添加注册按钮
        registerButton.setBounds(400, 310, 128, 47);
        registerButton.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/login/注册按钮.png"));
        //去除按钮的边框
        registerButton.setBorderPainted(false);
        //去除按钮的背景
        registerButton.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        registerButton.addMouseListener(this);
        this.getContentPane().add(registerButton);

        //背景图片
        JLabel backgroundLabel = new JLabel(new ImageIcon("fightAgainstLandlord\\src\\com\\itheima\\image\\login\\background.png"));
        backgroundLabel.setBounds(0, 0, 633, 423);
        this.getContentPane().add(backgroundLabel);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String userNameInput = userNameField.getText();
        char[] passwordInputArr = passwordField.getPassword();
        StringBuilder sb = new StringBuilder();
        for (char c : passwordInputArr) sb.append(c);
        String passwordInput = sb.toString();
        String captchaInput = captchaField.getText().trim();


        if (e.getSource() == loginButton) {
            if (userNameInput.isEmpty() || passwordInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名或密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (captchaInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "验证码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!captchaInput.equals(rightCaptcha)) {
                showWarning("验证码错误");
                return;
            }

            User userInfo = new User(userNameInput, passwordInput);
            if (allUsers.contains(userInfo)) {
                this.dispose();
                new GameJFrame();
            } else {
                showWarning("用户名或密码错误");
                return;
            }
        }
        if (e.getSource() == registerButton) {
            System.out.println("register");
        }

        if (e.getSource() == rightCaptchaLabel) {
            String newCaptcha = CaptchaUtil.getCaptcha();
            rightCaptchaLabel.setText(newCaptcha);
            rightCaptchaLabel.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //按下不松
        if (e.getSource() == loginButton) {
            loginButton.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/login/登录按下.png"));
        } else if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //按下松开
        if (e.getSource() == loginButton) {
            loginButton.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/login/登录按钮.png"));
        } else if (e.getSource() == registerButton) {
            registerButton.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void showWarning(String content) {
        JDialog dialog = new JDialog();
        dialog.setTitle("错误");
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);

        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        dialog.getContentPane().add(warning);

        dialog.setVisible(true);
    }
}
