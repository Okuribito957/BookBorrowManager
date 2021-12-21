package com.bbm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChangePassword extends JFrame {
    private JPanel windowJP,tableJP,buttonJP;
    private JLabel usernameJL,oldpwdJL,newpwdJL,connewpwdJL;
    private JTextField usernameJTF,oldpwdJTF,newpwdJTF,connewpwdJTF;
    private JButton confirmJB,cancelJB;
    public ChangePassword(){
        setBounds(200,200,400,250);
        setTitle("修改密码");

        windowJP = new JPanel();
        tableJP = new JPanel();
        tableJP.setBorder(new EmptyBorder(10,10,10,10));
        final GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        tableJP.setLayout(gridLayout);
        getContentPane().add(tableJP);
        //用户名
        usernameJL = new JLabel("用户名：");
        usernameJL.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(usernameJL);
        usernameJTF = new JTextField();
        usernameJTF.setColumns(10);
        usernameJTF.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(usernameJTF);
        //原密码
        oldpwdJL = new JLabel("原密码：");
        oldpwdJL.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(oldpwdJL);
        oldpwdJTF = new JTextField();
        oldpwdJTF.setColumns(10);
        oldpwdJTF.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(oldpwdJTF);
        //新密码
        newpwdJL = new JLabel("新密码：");
        newpwdJL.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(newpwdJL);
        newpwdJTF = new JTextField();
        newpwdJTF.setColumns(10);
        newpwdJTF.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(newpwdJTF);
        //确认新密码
        connewpwdJL = new JLabel("确认新密码：");
        connewpwdJL.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(connewpwdJL);
        connewpwdJTF = new JTextField();
        connewpwdJTF.setColumns(10);
        connewpwdJTF.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(connewpwdJTF);
        //buttonJP
        buttonJP = new JPanel();
        confirmJB = new JButton("确认");
        buttonJP.add(confirmJB);
        cancelJB = new JButton("取消");
        buttonJP.add(cancelJB);

        this.add(tableJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);

        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new ChangePassword();
    }
}
