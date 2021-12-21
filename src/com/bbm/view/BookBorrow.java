package com.bbm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.SimpleDateFormat;

public class BookBorrow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel readermessageJP,bookborrowJP,select_resultJP,button2JP;
    private JLabel readeridJL,nameJL,typeJL,ISBNJL,booknameJL,publishinghouseJL,editionJL,nowtimeJT,classJL,authorJL,publicationdateJL,priceJL,operatorJL;
    private JTextField readeridJTL,nameJTL,typeJTL,ISBNJTF,booknameJTF,publishinghouseJTF,editionJTF,nowtimeJTF,classJTF,authorJTF,publicationdateJTF,priceJTF,operatorJTF;
    private JTable tableJT;
    private JScrollPane jscrollPane;
    private JButton borrowJB,closeJB;

    public BookBorrow(){
        setBounds(400,400,700,700);
        setTitle("图书借阅");
        //创建两个标题边框
        JPanel readermessageJP = new JPanel();
        TitledBorder tb1 = new TitledBorder("读者借阅信息");
        readermessageJP.setBorder(tb1);
        add(readermessageJP,BorderLayout.NORTH);
        JPanel bookborrowJP = new JPanel();
        TitledBorder tb2 = new TitledBorder("图书借阅");
        bookborrowJP.setBorder(tb2);
        add(bookborrowJP,BorderLayout.CENTER);
        //tb1内部
        //小组件
        readeridJL = new JLabel("读者编号：");
        readeridJL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(readeridJL);
        readeridJTL = new JTextField();
        readeridJTL.setColumns(10);
        readeridJTL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(readeridJTL);
        nameJL = new JLabel("姓名：");
        nameJL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(nameJL);
        nameJTL = new JTextField();
        nameJTL.setColumns(10);
        nameJTL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(nameJTL);
        typeJL = new JLabel("类型");
        typeJL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(typeJL);
        typeJTL= new JTextField();
        typeJTL.setColumns(10);
        typeJTL.setHorizontalAlignment(SwingConstants.CENTER);
        readermessageJP.add(typeJTL);
        //表
        select_resultJP = new JPanel();//查询结果表
        jscrollPane = new JScrollPane();
        jscrollPane.setPreferredSize(new Dimension(500,90));
        String[] booksearch = {"ISBN","书名","借书日期"};
        String[][] results = {
                {"978730239000","sql","2020-10-23"}
        };//表体
        tableJT = new JTable(results,booksearch);
        jscrollPane.setViewportView(tableJT);
        select_resultJP.add(jscrollPane);
        readermessageJP.add(select_resultJP);
        select_resultJP.setBorder(new EmptyBorder(5,10,30,10));//问题！线在这会断开！
        //tb2内部
        final GridLayout gridLayout = new GridLayout(5,4);
        gridLayout.setVgap(5);
        gridLayout.setHgap(5);
        bookborrowJP.setLayout(gridLayout);

        bookborrowJP.setBorder(tb1);
        //ISBN
        ISBNJL = new JLabel("ISBN：");
        ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(ISBNJL);
        ISBNJTF = new JTextField();
        ISBNJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(ISBNJTF);
        //类别
        classJL = new JLabel("类别：");
        classJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(classJL);
        classJTF = new JTextField();
        classJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(classJTF);
        //书名
        booknameJL = new JLabel("书名：");
        booknameJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(booknameJL);
        booknameJTF = new JTextField();
        booknameJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(booknameJTF);
        //作者
        authorJL = new JLabel("作者：");
        authorJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(authorJL);
        authorJTF = new JTextField();
        authorJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(authorJTF);
        //出版社
        publishinghouseJL = new JLabel("出版社:");
        publishinghouseJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(publishinghouseJL);
        publishinghouseJTF = new JTextField();
        publishinghouseJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(publishinghouseJTF);
        //出版日期
        publicationdateJL = new JLabel("出版日期：");
        publicationdateJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(publicationdateJL);
        publicationdateJTF = new JTextField();
        publicationdateJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(publicationdateJTF);
        //版次
        editionJL = new JLabel("版次：");
        editionJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(editionJL);
        editionJTF = new JTextField();
        editionJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(editionJTF);
        //定价
        priceJL = new JLabel("定价：");
        priceJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(priceJL);
        priceJTF = new JTextField();
        priceJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(priceJTF);
        //当前日期
        nowtimeJT = new JLabel("当前日期：");
        nowtimeJT.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(nowtimeJT);
        nowtimeJTF = new JTextField();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(new java.util.Date());
        nowtimeJTF.setText(str);
        bookborrowJP.add(nowtimeJTF);
        //操作人员
        operatorJL = new JLabel("操作人员：");
        operatorJL.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(operatorJL);
        operatorJTF = new JTextField();
        operatorJTF.setHorizontalAlignment(SwingConstants.CENTER);
        bookborrowJP.add(operatorJTF);
        //按钮组
        JPanel button2JP = new JPanel();
        borrowJB = new JButton("借阅");
        button2JP.add(borrowJB);
        closeJB = new JButton("关闭");
        button2JP.add(closeJB);
        add(button2JP,BorderLayout.SOUTH);


        setVisible(true);
        setResizable(false);

    }
    public static void main(String[] args){
        new BookBorrow();
    }
}
