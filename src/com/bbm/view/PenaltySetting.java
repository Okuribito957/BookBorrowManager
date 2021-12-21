package com.bbm.view;

import javax.swing.*;
import java.awt.*;

public class PenaltySetting extends JFrame {
    private JPanel setJP,buttonJP;
    private JLabel penaltysettingJL,unitJL;
    private JTextField penaltysettingJTF;
    private JButton setJB,exitJB;

    public PenaltySetting(){
        setBounds(200,200,350,100);
        setTitle("罚金设置");

        setJP = new JPanel();
        penaltysettingJL = new JLabel("罚金设置：");
        penaltysettingJL.setHorizontalAlignment(SwingConstants.CENTER);
        setJP.add(penaltysettingJL);
        penaltysettingJTF = new JTextField();
        penaltysettingJTF.setColumns(10);
        penaltysettingJTF.setHorizontalAlignment(SwingConstants.CENTER);
        setJP.add(penaltysettingJTF);
        unitJL = new JLabel("元/天");
        unitJL.setHorizontalAlignment(SwingConstants.CENTER);
        setJP.add(unitJL);

        buttonJP = new JPanel();
        setJB = new JButton("添加");
        buttonJP.add(setJB);
        exitJB = new JButton("退出");
        buttonJP.add(exitJB);

        this.add(setJP , BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new PenaltySetting();
    }
}
