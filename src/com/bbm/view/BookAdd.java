package com.bbm.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BookAdd extends JFrame{
    //序列化
    private static final long serialVersionUID = 1L;
    //定义面板
    private JPanel bookAddJP,buttonJP;
    private ButtonGroup buttonGroup = new ButtonGroup();
    //定义标签
    private JLabel ISBNJL,bookNameJL,publishinghouseJL,editionJL,classJL,authorJL,publicationdateJL,priceJL;
    //定义文本框
    private JTextField ISBNJTF,bookNameJTF,publishinghouseJTF,editionJTF,authorJTF,publicationdateJTF,priceJTF;
    //定义按钮
    private JButton addJB,resetJB,closeJB;
    //定义图书类别下拉菜单
    private JComboBox  classJCB;
    //构造方法
    public BookAdd(){
        //窗口位置与大小
        setBounds(200,200,500,300);
        //窗口标题
        setTitle("图书信息添加");
        //按钮面板
        buttonJP = new JPanel();
        //主面板设计
        bookAddJP = new JPanel();
        bookAddJP.setBorder(new EmptyBorder(20,10,20,10));//面板边框
        final GridLayout gridLayout = new GridLayout(4,4);//定义网格布局组件四行四列
        gridLayout.setVgap(10);//组件间的垂直间距
        gridLayout.setHgap(10);//组件间的水平间距
        bookAddJP.setLayout(gridLayout);
        getContentPane().add(bookAddJP);
        //创建ISBN标签和文本框并添加到窗口
        ISBNJL = new JLabel("ISBN：");
        ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);//居中
        bookAddJP.add(ISBNJL);//将标签添加到中间容器
        ISBNJTF = new JTextField();
        bookAddJP.add(ISBNJTF);//将文本框添加到中间容器
        //创建类别标签并添加到窗口
        classJL = new JLabel("类别：");
        classJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(classJL);
        //创建图书类别下拉列表
        classJCB = new JComboBox();
        classJCB.addItem("-请选择-");
        classJCB.addItem("计算机");
        classJCB.addItem("人文");
        classJCB.addItem("社会科学");
        bookAddJP.add(classJCB);//将下拉列表添加到中间容器
        //创建书名标签和文本框并添加到窗口
        bookNameJL = new JLabel("书名：");//标签
        bookNameJL.setHorizontalAlignment(SwingConstants.CENTER);//居中
        bookAddJP.add(bookNameJL);//添加到中间容器
        bookNameJTF = new JTextField();//文本框
        bookAddJP.add(bookNameJTF);//添加到中间容器
        //创建作者标签和文本框并添加到窗口
        authorJL = new JLabel("作者：");
        authorJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(authorJL);
        authorJTF = new JTextField();
        bookAddJP.add(authorJTF);
        //创建出版社标签和文本框并添加到窗口
        publishinghouseJL = new JLabel("出版社：");
        publishinghouseJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(publishinghouseJL);
        publishinghouseJTF = new JTextField();
        bookAddJP.add(publishinghouseJTF);
        //创建出版日期标签和文本框并添加到窗口
        publicationdateJL = new JLabel("出版日期：");
        publicationdateJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(publicationdateJL);
        publicationdateJTF = new JTextField();
        bookAddJP.add(publicationdateJTF);
        //创建版次标签和文本框并添加到窗口
        editionJL = new JLabel("版次：");
        editionJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(editionJL);
        editionJTF = new JTextField();
        bookAddJP.add(editionJTF);
        //创建定价标签和文本框并添加到窗口
        priceJL = new JLabel("定价：");
        priceJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookAddJP.add(priceJL);
        priceJTF = new JTextField();
        bookAddJP.add(priceJTF);
        //按钮面板设计
        addJB = new JButton("添加");
        buttonJP.add(addJB);
        resetJB = new JButton("重置");
        buttonJP.add(resetJB);
        closeJB = new JButton("关闭");
        buttonJP.add(closeJB);
        //面板在顶层容器的布局
        this.add(bookAddJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        //显示该界面
        this.setVisible(true);
        //关闭最大化按钮
        setResizable(false);
    }
    public static void main(String[] args){
        new BookAdd();
    }
}