package com.bbm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserAdd extends JFrame {

    private JPanel loginJP,buttonJP;
    private JLabel usernameJL,pwdJL;
    private JTextField usernameJTF,pwdJTF;
    private JButton addJB,cancelJB;

    public UserAdd(){
        setBounds(300,300,400,170);
        setTitle("添加用户");

        loginJP = new JPanel();
        loginJP.setBorder(new EmptyBorder(10,10,10,10));
        loginJP.setLayout(new GridLayout(2,2));
        usernameJL = new JLabel("用户名：");
        usernameJL.setHorizontalAlignment(SwingConstants.CENTER);
        loginJP.add(usernameJL);
        usernameJTF = new JTextField();
        usernameJTF.setHorizontalAlignment(SwingConstants.CENTER);
        loginJP.add(usernameJTF);
        pwdJL = new JLabel("密 码：");
        pwdJL.setHorizontalAlignment(SwingConstants.CENTER);
        loginJP.add(pwdJL);
        pwdJTF = new JTextField();
        pwdJTF.setHorizontalAlignment(SwingConstants.CENTER);
        loginJP.add(pwdJTF);

        //buttonJP
        buttonJP = new JPanel();
        addJB = new JButton("添加");
        buttonJP.add(addJB);
        cancelJB = new JButton("取消");
        buttonJP.add(cancelJB);

        this.add(loginJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new UserAdd();
    }
}
