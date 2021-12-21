package com.bbm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteUser extends JFrame {

    private JPanel tableJP,buttonJP;
    private JButton deleteJB,exitJB;
    private JTable jtable;
    private JScrollPane jscrollPane;

    public DeleteUser(){
        setBounds(300,300,400,250);
        setTitle("删除用户");

        tableJP = new JPanel();
        tableJP.setBorder(new EmptyBorder(20,5,5,5));
        jscrollPane = new JScrollPane();
        jscrollPane.setPreferredSize(new Dimension(300, 100));
        String[] readersearch = {"用户编号", "用户名", "密码"};
        String[][] results = {
                {"1", "admin", "123456"},
                {"2", "张钧千", "zjq6666"},
        };
        jtable = new JTable(results, readersearch);
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jscrollPane.setViewportView(jtable);
        tableJP.add(jscrollPane);

        buttonJP = new JPanel();
        deleteJB = new JButton("删除");
        buttonJP.add(deleteJB);
        exitJB = new JButton("退出");
        buttonJP.add(exitJB);
        buttonJP.setBorder(new EmptyBorder(10,5,10,5));

        this.add(tableJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new DeleteUser();
    }
}
