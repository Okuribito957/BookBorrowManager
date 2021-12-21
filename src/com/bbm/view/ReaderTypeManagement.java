package com.bbm.view;

import com.bbm.db.ReaderTypeDao;
import com.bbm.model.ReaderType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReaderTypeManagement extends JFrame {

    private JButton selectJB,addJB,updateJB,deleteJB,exitJB;
    private JPanel buttonJP,headJP,selectnorthJP,inputJP,tableJP,select_resultJP;
    private JLabel readertypeJL,readertypeidJL,readertypenameJL,numberofbooksavailableJL,loanperiodJL;
    private JTextField readertypeJTF,readertypeidJTF,readertypenameJTF,numberofbooksavailableJTF,loanperiodJTF;
    private JScrollPane jscrollPane;
    private JTable jtable;

    //定义信息表
    private String[] readersearch = {"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};
    private Object[][] getSelect(List<ReaderType> list){
        Object[][] results = new Object[list.size()][readersearch.length];
        for (int i = 0;i < list.size();i++){
            ReaderType readertype = list.get(i);
            results[i][0] = readertype.getId();
            results[i][1] = readertype.getName();
            results[i][2] = readertype.getMaxborrownum();
            results[i][3] = readertype.getLimit();
        }
        return results;
    }
    public ReaderTypeManagement(){
        setBounds(300,300,600,350);
        setTitle("读者类型管理");
        //北部
        headJP = new JPanel();
        selectnorthJP = new JPanel();
        selectnorthJP.setLayout(new BorderLayout());
        //北
        readertypeJL = new JLabel("读者类型");
        headJP.add(readertypeJL);
        readertypeJTF = new JTextField();//取值
        readertypeJTF.setColumns(20);
        headJP.add(readertypeJTF);
        selectJB = new JButton("查询");
        selectJB.addActionListener(new SelectActionListener());
        headJP.add(selectJB);
        selectnorthJP.add(headJP,BorderLayout.NORTH);
        //中中_查询结果面板
        select_resultJP = new JPanel();
        jscrollPane = new JScrollPane();
        jscrollPane.setPreferredSize(new Dimension(350, 150));
        Object[][] results = getSelect(ReaderTypeDao.selectReaderType());
        jtable = new JTable(results, readersearch);
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jscrollPane.setViewportView(jtable);
        select_resultJP.add(jscrollPane);
        selectnorthJP.add(select_resultJP,BorderLayout.CENTER);
        //中部
        inputJP = new JPanel();
        inputJP.setBorder(new EmptyBorder(5,10,5,10));
        GridLayout gridLayout = new GridLayout(2,4);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        inputJP.setLayout(gridLayout);
        //读者类型编号
        readertypeidJL = new JLabel("读者类型编号：");
        readertypeidJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(readertypeidJL);
        readertypeidJTF = new JTextField();
        readertypeidJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(readertypeidJTF);
        //读者类型名称
        readertypenameJL = new JLabel("读者类型名称：");
        readertypenameJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(readertypenameJL);
        readertypenameJTF = new JTextField();
        readertypenameJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(readertypenameJTF);
        //可借图书数量
        numberofbooksavailableJL = new JLabel("可借图书数量：");
        numberofbooksavailableJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(numberofbooksavailableJL);
        numberofbooksavailableJTF = new JTextField();
        numberofbooksavailableJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(numberofbooksavailableJTF);
        //可借图书期限
        loanperiodJL = new JLabel("可借图书期限：");
        loanperiodJL.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(loanperiodJL);
        loanperiodJTF = new JTextField();
        loanperiodJTF.setHorizontalAlignment(SwingConstants.CENTER);
        inputJP.add(loanperiodJTF);
        //南部
        buttonJP = new JPanel();
        addJB = new JButton("添加");
        addJB.addActionListener(new ReaderTypeAddActionListener());//注册添加按钮事件
        buttonJP.add(addJB);
        updateJB = new JButton("修改");
        updateJB.addActionListener(new ReaderTypeUpdateActionListener());//注册修改按钮事件
        buttonJP.add(updateJB);
        deleteJB = new JButton("删除");
        deleteJB.addActionListener(new ReaderTypeDeleteActionListener());//注册删除按钮事件
        buttonJP.add(deleteJB);
        exitJB = new JButton("退出");
        exitJB.addActionListener(new CloseActionListener());//注册退出按钮事件
        buttonJP.add(exitJB);

        this.add(selectnorthJP,BorderLayout.NORTH);
        this.add(inputJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        setVisible(true);
        //setResizable(false);
    }
    //查询读者信息事件
    class SelectActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object[][] results = getSelect(ReaderTypeDao.selectReaderType(readertypeJTF.getText().trim()));
            jtable = new JTable(results,readersearch);
            jscrollPane.setViewportView(jtable);
            jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtable.addMouseListener(new TableListener());
        }
    }
    //表格事件适配器
    class TableListener extends MouseAdapter{
        public void mouseClicked(final MouseEvent e){
            int selRow = jtable.getSelectedRow();
            readertypeidJTF.setText(jtable.getValueAt(selRow,0).toString().trim());
            readertypenameJTF.setText(jtable.getValueAt(selRow,1).toString().trim());
            numberofbooksavailableJTF.setText(jtable.getValueAt(selRow,2).toString().trim());
            loanperiodJTF.setText(jtable.getValueAt(selRow,3).toString().trim());
        }
    }
    //“添加”按钮事件监听器
    class ReaderTypeAddActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (readertypeidJTF.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"请输入读者类型编号");
                return;
            }
            if (readertypenameJTF.getText().length() == 0) {
                JOptionPane.showMessageDialog(null,"请输入读者类型名称");
                return;
            }
            if (numberofbooksavailableJTF.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"请输入可借图书数量");
                return;
            }
            if (loanperiodJTF.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"请输入可借图书期限");
                return;
            }
            Integer id = Integer.parseInt(readertypeidJTF.getText().trim());//取int值的特殊方法
            String typename = readertypenameJTF.getText().trim();
            String numberofbooksavailable = numberofbooksavailableJTF.getText().trim();
            Integer loanperiod = Integer.parseInt(loanperiodJTF.getText().trim());
            //调用ReaderTypeDao添加读者类型信息方法
            int i = ReaderTypeDao.insertReaderType(id,typename,numberofbooksavailable,loanperiod);
            if (i == 1){
                JOptionPane.showMessageDialog(null,"添加成功");
                Object[][] results = getSelect(ReaderTypeDao.selectReaderType());
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        }
    }
    //读者类型更新监听器
    class ReaderTypeUpdateActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer id = Integer.parseInt(readertypeidJTF.getText().trim());
            String typename = readertypenameJTF.getText().trim();
            Integer num = Integer.parseInt(numberofbooksavailableJTF.getText().trim());
            Integer limit = Integer.parseInt(loanperiodJTF.getText().trim());
            int i = ReaderTypeDao.updateReaderType(id,typename,num,limit);
            System.out.println(i);
            if (i == 1){  //i
                JOptionPane.showMessageDialog(null,"修改成功");
                Object[][] results = getSelect(ReaderTypeDao.selectReaderType());
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        }
    }
    //删除按钮事件监听器
    class ReaderTypeDeleteActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer id = Integer.parseInt(readertypeidJTF.getText().trim());
            int i = ReaderTypeDao.deleteReaderType(id);
            System.out.println(i);
            if (i == 1){
                JOptionPane.showMessageDialog(null,"删除成功");
                Object[][] results = getSelect(ReaderTypeDao.selectReaderType());
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                System.out.println(i);
                //i = 1;
            }
        }
    }
    //退出按钮事件监听器
    class CloseActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new ReaderTypeManagement();
    }
}
