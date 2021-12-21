package com.bbm.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BookSelectandUpdate extends JFrame{
    private static final long serialVersionUID = 1L;

    private JComboBox conditionJCB;
    private JPanel select_conditionJP,select_resultJP,buttonJP1,buttonJP2,bookselectJP,bookupdateJP,tab2JP,buttonJP;
    private JTextField select_conditionJTF,ISBNJTF,bookNameJTF,publishinghouseJTF,editionJTF,authorJTF,publicationdateJTF,priceJTF;
    private JTable select_resultJT;
    private JScrollPane jscrollPane;
    private JButton selectJB,exitJB,updateJB,closeJB;
    private JLabel ISBNJL,bookNameJL,publishinghouseJL,editionJL,classJL,authorJL,publicationdateJL,priceJL;
    private JComboBox  classJCB;

    public BookSelectandUpdate(){
        setSize(700,450);
        setTitle("图书信息查询与修改");
        //创建选项卡
        tab2JP = new JPanel();

        JTabbedPane jtabbedPane = new JTabbedPane();
        JPanel bookselectJP = new JPanel();
        jtabbedPane.addTab("图书信息查询",bookselectJP);//添加选项卡
        bookselectJP.setLayout(new  BorderLayout());
        JPanel bookupdateJP = new JPanel();
        jtabbedPane.addTab("图书信息修改",tab2JP);//添加选项卡  tab2JP
        bookupdateJP.setLayout(new GridLayout());
        this.add(jtabbedPane);

        //图书信息查询选项卡设计—采用边界布局
        //北部
        JPanel select_conditionJP = new JPanel();
        conditionJCB = new JComboBox();//下拉菜单
        conditionJCB.addItem("-请选择-");
        conditionJCB.addItem("ISBN");
        conditionJCB.addItem("书名");
        conditionJCB.addItem("作者");
        select_conditionJTF = new JTextField(8);//文本框
        select_conditionJP.add(conditionJCB);
        select_conditionJP.add(select_conditionJTF);
        bookselectJP.add(select_conditionJP,BorderLayout.NORTH);
        //中部
        select_resultJP = new JPanel();//查询结果表
        jscrollPane = new JScrollPane();
        jscrollPane.setPreferredSize(new Dimension(600,300));
        String[] booksearch = {"ISBN","类别","书名","作者","出版社","出版日期","版次","定价"};//表头
        String[][] results = {
                {"978730239000","计算机","sql","梁爽","清华大学出版社","2020-10-23","3","44"},
                {"978730239001","计算机","oracle","王岩","清华大学出版社","2011-10-23","2","45"},
                {"978730239002","社科类","思想政治","谢华","人民邮电大学出版社","2010-10-23","3","46"},
        };//表体
        select_resultJT = new JTable(results,booksearch);
        select_resultJT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jscrollPane.setViewportView(select_resultJT);
        select_resultJP.add(jscrollPane);
        bookselectJP.add(select_resultJP,BorderLayout.CENTER);
        //南部
        JPanel buttonJP1 =new JPanel();
        selectJB = new JButton("查询");
        exitJB = new JButton("退出");
        buttonJP1.add(selectJB);
        buttonJP1.add(exitJB);
        bookselectJP.add(buttonJP1,BorderLayout.SOUTH);


        //图书信息修改选项卡设计—采用网格布局
        bookupdateJP.setBorder(new EmptyBorder(5,10,5,100));
        final GridLayout gridLayout = new GridLayout(9,2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        bookupdateJP.setLayout(gridLayout);



        //ISBN
        ISBNJL = new JLabel("ISBN：");
        ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);//居中
        bookupdateJP.add(ISBNJL);//将标签添加到中间容器
        ISBNJTF = new JTextField();
        ISBNJTF.setColumns(20);
        bookupdateJP.add(ISBNJTF);//将文本框添加到中间容器

        //类别
        classJL = new JLabel("类别：");
        classJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(classJL);
        classJCB = new JComboBox();
        classJCB.addItem("-请选择-");
        classJCB.addItem("计算机");
        classJCB.addItem("人文");
        classJCB.addItem("社会科学");
        bookupdateJP.add(classJCB);
        //书名
        bookNameJL = new JLabel("书名：");//标签
        bookNameJL.setHorizontalAlignment(SwingConstants.CENTER);//居中
        bookupdateJP.add(bookNameJL);//添加到中间容器
        bookNameJTF = new JTextField();//文本框
        bookupdateJP.add(bookNameJTF);//添加到中间容器
        //作者
        authorJL = new JLabel("作者：");
        authorJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(authorJL);
        authorJTF = new JTextField();
        bookupdateJP.add(authorJTF);
        //出版社
        publishinghouseJL = new JLabel("出版社：");
        publishinghouseJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(publishinghouseJL);
        publishinghouseJTF = new JTextField();
        bookupdateJP.add(publishinghouseJTF);
        //出版日期
        publicationdateJL = new JLabel("出版日期：");
        publicationdateJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(publicationdateJL);
        publicationdateJTF = new JTextField();
        bookupdateJP.add(publicationdateJTF);
        //版次
        editionJL = new JLabel("版次：");
        editionJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(editionJL);
        editionJTF = new JTextField();
        bookupdateJP.add(editionJTF);
        //定价
        priceJL = new JLabel("定价：");
        priceJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookupdateJP.add(priceJL);
        priceJTF = new JTextField();
        bookupdateJP.add(priceJTF);
        //按钮

        buttonJP2 = new JPanel();
        updateJB = new JButton("修改");
        buttonJP2.add(updateJB);
        closeJB = new JButton("关闭");
        buttonJP2.add(closeJB);

        tab2JP.add(bookupdateJP,BorderLayout.CENTER);
        tab2JP.add(buttonJP2,BorderLayout.SOUTH);

        this.setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new BookSelectandUpdate();
    }
}
