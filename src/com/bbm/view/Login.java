package com.bbm.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.bbm.model.Users;
import com.bbm.db.UserDao;


public class Login extends JFrame{
    private static final long serialVersionUID=1L;
    private JPanel textJP,loginJP,buttonJP;
    private Font f1 = new Font("黑体",Font.BOLD,32);
    private JLabel textJL,usernameJL,passwordJL;
    private JTextField usernameJTF;
    private JPasswordField pwdJTF;
    private JButton loginJB;
    private JButton resetJB;
    private static Users user;

    public Login(){
        setSize(260,180);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(width/2 - 130,height/2 - 90);

        setTitle("图书借阅系统登录界面");
        textJP = new JPanel();
        loginJP = new JPanel();
        buttonJP = new JPanel();

        textJL = new JLabel();
        textJL.setFont(f1);
        textJL.setText("图书借阅系统");
        textJP.add(textJL);

        this.add(textJP,BorderLayout.NORTH);

        loginJP.setLayout(new GridLayout(2,2));
        usernameJL = new JLabel("用户名：");
        usernameJL.setHorizontalAlignment(SwingConstants.CENTER);
        usernameJTF = new JTextField();
        passwordJL = new JLabel("密 码：");
        passwordJL.setHorizontalAlignment(SwingConstants.CENTER);
        pwdJTF = new JPasswordField();

        loginJP.add(usernameJL);
        loginJP.add(usernameJTF);
        loginJP.add(passwordJL);
        loginJP.add(pwdJTF);

        this.add(loginJP,BorderLayout.CENTER);

        loginJB = new JButton("登录");
        //添加登录事件
        loginJB.addActionListener(new LoginAction());
        resetJB = new JButton("重置");
        //添加重置事件
        resetJB.addActionListener(new ResetAction());

        buttonJP.add(loginJB);
        buttonJP.add(resetJB);

        this.add(buttonJP,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setResizable(false);
    }
    public static void setUser(Users user){
        Login.user = user;
    }
    public static Users getUser(Users user){
        return user;
    }

    class LoginAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!"".equals(usernameJTF.getText()) && !"".equals(new String(pwdJTF.getPassword()))){
                user = UserDao.check(usernameJTF.getText(),new String(pwdJTF.getPassword()));
                if (user.getName() != null){
                    try {
                        Library frame = new Library();
                        frame.setVisible(true);
                        //new ReaderTypeManagement();/* new此界面 */
                        Login.this.setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"您输入的用户名或密码错误！");
                    usernameJTF.setText("");
                    pwdJTF.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"请输入用户名和密码！");
            }

        }
    }
    class ResetAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            usernameJTF.setText("");
            pwdJTF.setText("");
        }
    }
    public static void main(String[] args){
        new Login();
    }
}

