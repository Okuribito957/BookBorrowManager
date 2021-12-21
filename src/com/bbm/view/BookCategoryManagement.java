package com.bbm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookCategoryManagement extends JFrame {
    private JPanel selectJP,tableJP,inputJP,button1JP,button2JP;
    private JLabel bookcategoryJL,bookcategoryidJL,bookcategorynameJL;
    private JTextField bookcategoryJTF,bookcategoryidJTF,bookcategorynameJTF;
    private JButton selectJB,addJB,updateJB,deleteJB,exitJB;
    private JTable tableJT;
    private JScrollPane jscrollpane;

    public BookCategoryManagement(){
        setBounds(300,300,400,330);
        setTitle("图书类别管理");
        //头部面板
        selectJP = new JPanel();
        JPanel selectandinputJP = new JPanel();
        selectandinputJP.setLayout(new BorderLayout());
        bookcategoryJL = new JLabel("图书类别：");
        bookcategoryJL.setHorizontalAlignment(SwingConstants.CENTER);
        selectJP.add(bookcategoryJL);
        bookcategoryJTF = new JTextField();
        bookcategoryJTF.setColumns(10);
        bookcategoryJTF.setHorizontalAlignment(SwingConstants.CENTER);
        selectJP.add(bookcategoryJTF);
        button1JP = new JPanel();
        selectJB = new JButton("查询");
        button1JP.add(selectJB);
        selectJP.add(button1JP);
        //table
        tableJP = new JPanel();
        jscrollpane = new JScrollPane();
        jscrollpane.setPreferredSize(new Dimension(200, 100));
        String[] readersearch = {"编号", "类型"};
        String[][] results = {
                {"1", "计算机"},
                {"2", "社科类"},
                {"3", "小说"},
                {"4", "名著"},
                {"5", "java"},
                {"6", "python"},
                {"7", "sql"},
                {"8", "网络技术"},
        };
        tableJT = new JTable(results, readersearch);
        tableJT.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jscrollpane.setViewportView(tableJT);
        //bookcategoryJL.setHorizontalAlignment(SwingConstants.CENTER);
        tableJP.add(jscrollpane);
        selectandinputJP.add(tableJP,BorderLayout.NORTH);
        //输入部分
        inputJP = new JPanel();
        inputJP.setBorder(new EmptyBorder(10,10,10,10));
        GridLayout gridLayout = new GridLayout(2,2);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        inputJP.setLayout(gridLayout);
        //图书类别编号
        bookcategoryidJL = new JLabel("图书类别编号：");
        bookcategoryidJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(bookcategoryidJL);
        bookcategoryidJTF = new JTextField();
        bookcategoryidJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(bookcategoryidJTF);
        //图书类别名称
        bookcategorynameJL = new JLabel("图书类别名称：");
        bookcategorynameJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(bookcategorynameJL);
        bookcategorynameJTF = new JTextField();
        bookcategorynameJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(bookcategorynameJTF);
        //按钮组
        button2JP = new JPanel();
        addJB = new JButton("添加");
        button2JP.add(addJB);
        updateJB = new JButton("修改");
        button2JP.add(updateJB);
        deleteJB = new JButton("删除");
        button2JP.add(deleteJB);
        exitJB = new JButton("退出");
        button2JP.add(exitJB);
        selectandinputJP.add(inputJP,BorderLayout.CENTER);

        this.add(selectJP, BorderLayout.NORTH);
        this.add(selectandinputJP,BorderLayout.CENTER);
        this.add(button2JP,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new BookCategoryManagement();
    }
}
