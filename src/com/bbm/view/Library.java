package com.bbm.view;

import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Library extends JFrame {
    private static final long serialVersionUID = 1L;
    public Library(){
        setSize(800,600);
        setTitle("图书借阅系统");
        JMenuBar jmenuBar = createJMenuBar();
        setJMenuBar(jmenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private JMenuBar createJMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu readerManageJMenu = new JMenu("读者信息管理");
        JMenuItem readerAddJMI = new JMenuItem("读者信息添加");
        //注册读者信息添加事件
        readerAddJMI.addActionListener(new ReaderAddListener());
        readerManageJMenu.add(readerAddJMI);
        JMenuItem readerSelUpdJMI = new JMenuItem("读者信息查询与修改");
        //注册读者信息查询修改事件
        readerSelUpdJMI.addActionListener(new ReaderSelectandUpdateListener());
        readerManageJMenu.add(readerSelUpdJMI);

        JMenu bookMangeJMenu = new JMenu("图书信息管理");
        JMenuItem bookAddJMI = new JMenuItem("图书信息添加");
        //注册图书信息添加事件
        bookAddJMI.addActionListener(new BookAddListener());
        bookMangeJMenu.add(bookAddJMI);
        JMenuItem BookSelUpdJMI = new JMenuItem("图书信息查询与修改");
        //注册图书信息查询与修改事件
        BookSelUpdJMI.addActionListener(new BookSelectandUpdateListener());
        bookMangeJMenu.add(BookSelUpdJMI);

        JMenu bookBorrowJMenu = new JMenu("图书借阅管理");
        JMenuItem bookBorrowJMI = new JMenuItem("图书借阅");
        //注册图书借阅事件
        bookBorrowJMI.addActionListener(new BookBorrowListener());
        bookBorrowJMenu.add(bookBorrowJMI);
        JMenuItem bookReturnJMI = new JMenuItem("图书归还");
        //注册图书归还事件
        bookReturnJMI.addActionListener(new BookReturnListener());
        bookBorrowJMenu.add(bookReturnJMI);

        JMenu baseInfoJMenu = new JMenu("基础信息维护");
        JMenuItem readerTypeJMI = new JMenuItem("读者类型设置");
        //注册读者类型设置事件
        readerTypeJMI.addActionListener(new ReaderTypeMenagementListener());
        baseInfoJMenu.add(readerTypeJMI);
        JMenuItem bookTypeJMI = new JMenuItem("图书类别设置");
        //注册图书类别设置事件
        bookTypeJMI.addActionListener(new BookCategoryManagementListener());
        baseInfoJMenu.add(bookTypeJMI);
        JMenuItem fineSetJMI = new JMenuItem("罚金设置");
        //注册罚金设置事件
        fineSetJMI.addActionListener(new PenaltySettingListener());
        baseInfoJMenu.add(fineSetJMI);

        JMenu userManageJMenu = new JMenu("用户管理");
        JMenuItem updPwdJMI = new JMenuItem("修改密码");
        //注册修改密码事件
        updPwdJMI.addActionListener(new ChangePasswordListener());
        userManageJMenu.add(updPwdJMI);
        JMenuItem userAddJMI = new JMenuItem("用户添加");
        //注册用户添加事件
        userAddJMI.addActionListener(new UserAddListener());
        userManageJMenu.add(userAddJMI);
        JMenuItem userDelJMI = new JMenuItem("用户删除");
        //注册用户删除事件
        userDelJMI.addActionListener(new DeleteUserListener());
        userManageJMenu.add(userDelJMI);

        jMenuBar.add(readerManageJMenu);
        jMenuBar.add(bookMangeJMenu);
        jMenuBar.add(bookBorrowJMenu);
        jMenuBar.add(baseInfoJMenu);
        jMenuBar.add(userManageJMenu);

        return jMenuBar;
    }
    //读者信息添加事件监听器
    class ReaderAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ReaderAdd();
        }
    }
    //读者信息查询修改事件监听器
    class ReaderSelectandUpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ReaderSelectandUpdate();
        }
    }
    //图书信息添加事件监听器
    class BookAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookAdd();
        }
    }
    //图书信息查询与修改事件监听器
    class BookSelectandUpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookSelectandUpdate();
        }
    }
    //图书借阅事件监听器
    class BookBorrowListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookBorrow();
        }
    }
    //图书归还事件监听器
    class BookReturnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookReturn();
        }
    }
    //读者类型设置事件监听器
    class ReaderTypeMenagementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ReaderTypeManagement();
        }
    }
    //图书类别设置事件监听器
    class BookCategoryManagementListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new BookCategoryManagement();
        }
    }
    //罚金设置事件监听器
    class PenaltySettingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new PenaltySetting();
        }
    }
    //修改密码事件监听器
    class ChangePasswordListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ChangePassword();
        }
    }
    //用户添加事件监听器
    class UserAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new UserAdd();
        }
    }
    //用户删除事件监听器
    class DeleteUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new DeleteUser();
        }
    }





    public static void main(String[] args){
        new Library();
    }
}
