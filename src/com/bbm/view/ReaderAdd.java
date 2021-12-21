package com.bbm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.bbm.db.ReaderDao;
import com.bbm.model.ReaderType;

public class ReaderAdd extends JFrame{
    private JPanel readerAddJP,genderJP,buttonJP;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton JRB1,JRB2;
    private JLabel IDJL,categoryJL,readerNameJL,genderJL,majorJLabel,phoneJLabel,deptJLabel,regJLabel;
    private JTextField IDJTF,readerNameJTF,majorJTF,phoneJTF,deptJTF,regtimeJTF;
    private JComboBox readertypeJCB;
    private JButton addJB,closeJB;

    public ReaderAdd(){
        setBounds(200,200,500,200);
        setTitle("读者信息添加");

        buttonJP = new JPanel();

        readerAddJP = new JPanel();

        readerAddJP.setBorder(new EmptyBorder(5,10,5,10));
        final GridLayout gridLayout = new GridLayout(4,4);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        readerAddJP.setLayout(gridLayout);
        getContentPane().add(readerAddJP);

        IDJL = new JLabel("读者编号");

        IDJL.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(IDJL);
        IDJTF = new JTextField();
        readerAddJP.add(IDJTF);

        readerNameJL = new JLabel("姓名：");
        readerNameJL.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(readerNameJL);
        readerNameJTF = new JTextField();
        readerAddJP.add(readerNameJTF);

        categoryJL = new JLabel("类型：");
        categoryJL.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(categoryJL);

        readertypeJCB = new JComboBox();
        readertypeJCB.addItem("—请选择—");
        readertypeJCB.addItem("学生");
        readertypeJCB.addItem("教师");
        readertypeJCB.addItem("访客");

        readerAddJP.add(readertypeJCB);

        genderJL = new JLabel("性别：");
        genderJL.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(genderJL);

        genderJP = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        genderJP.setLayout(flowLayout);
        readerAddJP.add(genderJP);
        JRB1 = new JRadioButton();
        genderJP.add(JRB1);
        JRB1.setSelected(true);
        buttonGroup.add(JRB1);
        JRB1.setText("男");
        JRB2 = new JRadioButton();
        genderJP.add(JRB2);
        buttonGroup.add(JRB2);
        JRB2.setText("女");

        majorJLabel = new JLabel("专业：");
        majorJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(majorJLabel);
        majorJTF = new JTextField();
        readerAddJP.add(majorJTF);

        phoneJLabel = new JLabel("电话：");
        phoneJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(phoneJLabel);
        phoneJTF = new JTextField();
        readerAddJP.add(phoneJTF);

        deptJLabel = new JLabel("系部：");
        deptJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(deptJLabel);
        deptJTF = new JTextField();
        readerAddJP.add(deptJTF);

        regJLabel = new JLabel("注册日期：");
        regJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        readerAddJP.add(regJLabel);
        regtimeJTF = new JTextField();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String str = format.format(new java.util.Date());
        regtimeJTF.setText(str);
        readerAddJP.add(regtimeJTF);

        addJB = new JButton("添加");
        //注册添加按钮事件
        addJB.addActionListener(new ReaderAddActionListener(JRB1));
        closeJB = new JButton("关闭");
        //注册关闭按钮事件
        closeJB.addActionListener(new CloseActionListener());
        buttonJP.add(addJB);
        buttonJP.add(closeJB);

        this.add(readerAddJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        this.setVisible(true);
        setResizable(false);
    }
    //“添加”按钮事件监听器
    class ReaderAddActionListener implements ActionListener{
        private JRadioButton button1;
        //重载构造方法，带有参数JRadioButton类对象，用来接收传入的性别按钮
        ReaderAddActionListener(JRadioButton button1){
            this.button1 = button1;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (IDJTF.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"读者编号不能为空！");
                return;
            }
            if (IDJTF.getText().length()!=8){
                JOptionPane.showMessageDialog(null,"读者编号位数应为8位");
                return;
            }
            if (readerNameJTF.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"读者姓名不能为空");
                return;
            }
            String ID = IDJTF.getText().trim();//读者编号
            //获取读者类型
            String readertype = (String)readertypeJCB.getSelectedItem();
            //获取读者姓名
            String name = readerNameJTF.getText().trim();
            String major = majorJTF.getText().trim();
            String gender = "女";
            //读者性别，在此调用此类时传入“男”性别按钮，此处的button1即代表“男”性别按钮，如被选择就代表性别为“男”，否则，性别为“女”。
            if(button1.isSelected()){
                gender = "男";
            }
            String phone = phoneJTF.getText().trim();
            String dept = deptJTF.getText().trim();
            String regdate = regtimeJTF.getText().trim();
            //调用ReaderDao的插入读者信息方法，返回整数值，如果为1，代表插入成功，否则插入失败
            int i = ReaderDao.insertReader(ID,readertype,name,major,gender,phone,dept,regdate);
            if (i == 1){
                JOptionPane.showMessageDialog(null,"添加成功");
                ReaderAdd.this.setVisible(false);
            }
        }
    }
    //"关闭"按钮事件监听器
    class CloseActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new ReaderAdd();
    }
}
