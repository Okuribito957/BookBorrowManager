package com.bbm.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.bbm.db.ReaderDao;
import com.bbm.db.ReaderTypeDao;
import com.bbm.model.Reader;
import com.bbm.model.ReaderType;
import jdk.nashorn.internal.scripts.JO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ReaderSelectandUpdate extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel selectJP, select_conditonJP, select_resultJP, genderJP, updateJP, buttonJP;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton JRB1, JRB2;
    private JLabel IDJL, typeJL, readerNameJL, genderJL, phoneJL, deptJL, majorJL, regJL;
    private JTextField select_conditionJTF, IDJTF, readerNameJTF, phoneJTF, deptJTF, majorJTF, regJTF;
    private JComboBox conditionJCB, readertypeJCB;
    private JScrollPane jscrollPane;
    private JTable jtable;
    private JButton selectJB, updateJB, closeJB;

    //定义信息表
    private String[] readersearch = {"读者编号","类型","姓名","专业","性别", "电话", "系部", "注册日期"};
    private Object[][] getSelect(List<Reader> list){
        Object[][] results = new Object[list.size()][readersearch.length];
        for (int i = 0;i < list.size();i++){
            Reader reader = list.get(i);
            results[i][0] = reader.getReaderid();
            results[i][1] = reader.getTypename();
            results[i][2] = reader.getName();
            results[i][3] = reader.getMajor();
            results[i][4] = reader.getGender();
            results[i][5] = reader.getPhone();
            results[i][6] = reader.getDept();
            results[i][7] = reader.getRegdate();
        }
        return results;
    }

    //构造方法
    public ReaderSelectandUpdate() {
        setBounds(200, 200, 500, 500);
        setTitle("读者信息查询与修改");

        selectJP = new JPanel();
        selectJP.setLayout(new BorderLayout());
        select_conditonJP = new JPanel();
        conditionJCB = new JComboBox();
        String[] array = {"读者编号", "姓名", "类型", "系部"};
        for (int i = 0; i < array.length; i++) {
            conditionJCB.addItem(array[i]);
        }
        select_conditonJP.add(conditionJCB);
        //查询条件文本框
        select_conditionJTF = new JTextField();
        select_conditionJTF.setColumns(20);
        select_conditonJP.add(select_conditionJTF);
        //查询条件按钮
        selectJB = new JButton();
        selectJB.setText("查询");
        //注册查询按钮事件
        selectJB.addActionListener(new SelectActionListener());
        select_conditonJP.add(selectJB);
        selectJP.add(select_conditonJP, BorderLayout.NORTH);
        //查询结果面板
        select_resultJP = new JPanel();
        jscrollPane = new JScrollPane();
        jscrollPane.setPreferredSize(new Dimension(400, 200));
        Object[][] results = getSelect(ReaderDao.selectReader());
        jtable = new JTable(results,readersearch);
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jscrollPane.setViewportView(jtable);
        select_resultJP.add(jscrollPane);
        selectJP.add(select_resultJP,BorderLayout.CENTER);
        //读者信息修改面板
        updateJP = new JPanel();
        updateJP.setBorder(new EmptyBorder(5,10,5,10));
        GridLayout gridLayout = new GridLayout(4,4);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        updateJP.setLayout(gridLayout);
        IDJL = new JLabel("读者编号");
        IDJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(IDJL);
        IDJTF = new JTextField();
        updateJP.add(IDJTF);
        readerNameJL = new JLabel("姓名");
        readerNameJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(readerNameJL);
        readerNameJTF = new JTextField();
        updateJP.add(readerNameJTF);
        typeJL = new JLabel("类型");
        typeJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(typeJL);
        //下拉列表
        readertypeJCB = new JComboBox();
        //数据库取读者类型
        List<ReaderType> list = ReaderTypeDao.selectReaderType();
        for (int i = 0;i < list.size();i++){
            ReaderType rt = list.get(i);
            readertypeJCB.addItem(rt.getName());
        }
        updateJP.add(readertypeJCB);
        genderJL = new JLabel("性别");
        genderJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(genderJL);
        genderJP = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
        genderJP.setLayout(flowLayout);
        JRB1 = new JRadioButton();
        genderJP.add(JRB1);
        JRB1.setSelected(true);
        buttonGroup.add(JRB1);
        JRB1.setText("男");
        JRB2 = new JRadioButton();
        genderJP.add(JRB2);
        buttonGroup.add(JRB2);
        JRB2.setText("女");
        updateJP.add(genderJP);
        majorJL = new JLabel("专业：");
        majorJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(majorJL);
        majorJTF = new JTextField();
        updateJP.add(majorJTF);
        phoneJL = new JLabel("电话：");
        phoneJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(phoneJL);
        phoneJTF = new JTextField();
        updateJP.add(phoneJTF);
        deptJL = new JLabel("系部：");
        deptJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(deptJL);
        deptJTF = new JTextField();
        updateJP.add(deptJTF);
        regJL = new JLabel("注册日期：");
        regJL.setHorizontalAlignment(SwingConstants.CENTER);
        updateJP.add(regJL);
        regJTF = new JTextField();
        updateJP.add(regJTF);
        //按钮面板设计
        buttonJP = new JPanel();
        updateJB = new JButton("修改");
        //注册修改按钮事件
        updateJB.addActionListener(new ReaderUpdActionListener());
        closeJB = new JButton("关闭");
        //注册关闭按钮事件
        closeJB.addActionListener(new CloseActionListener());
        buttonJP.add(updateJB);
        buttonJP.add(closeJB);

        this.add(selectJP,BorderLayout.NORTH);
        this.add(updateJP,BorderLayout.CENTER);
        this.add(buttonJP,BorderLayout.SOUTH);
        this.setVisible(true);
        setResizable(false);
    }
    //按条件查询读者
    class SelectActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String condition = (String)conditionJCB.getSelectedItem();
            if (condition.equals("读者编号")){
                Object[][] results = getSelect(ReaderDao.selectReaderById(select_conditionJTF.getText().trim()));
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jtable.addMouseListener(new TableListener());
            }
            else if(condition.equals("姓名")){
                Object[][] results = getSelect(ReaderDao.selectReaderByName(select_conditionJTF.getText().trim()));
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jtable.addMouseListener(new TableListener());
            }
            else if (condition.equals("类型")){
                Object[][] results = getSelect(ReaderDao.selectReaderByType(select_conditionJTF.getText().trim()));
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jtable.addMouseListener(new TableListener());
            }
            else if (condition.equals("系部")){
                Object[][] results = getSelect(ReaderDao.selectReaderByDept(select_conditionJTF.getText().trim()));
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jtable.addMouseListener(new TableListener());
            }
        }
    }
    //表格事件适配器
    class TableListener extends MouseAdapter{
        public void mouseClicked(final MouseEvent e){
            int selRow = jtable.getSelectedRow();
            IDJTF.setText(jtable.getValueAt(selRow,0).toString().trim());
            readertypeJCB.setSelectedItem(jtable.getValueAt(selRow,1).toString().trim());//getValueAt(selRow,1))??
            readerNameJTF.setText(jtable.getValueAt(selRow,2).toString().trim());
            majorJTF.setText(jtable.getValueAt(selRow,3).toString().trim());
            if (jtable.getValueAt(selRow,4).toString().trim().equals("男")){
                JRB1.setSelected(true);
            }
            else{
                JRB2.setSelected(true);
            }
            phoneJTF.setText(jtable.getValueAt(selRow,5).toString().trim());
            deptJTF.setText(jtable.getValueAt(selRow,6).toString().trim());
            regJTF.setText(jtable.getValueAt(selRow,7).toString().trim());
        }
    }
    //读者更新监听器
    class ReaderUpdActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = IDJTF.getText().trim();
            String type = (String)readertypeJCB.getSelectedItem();
            String name = readerNameJTF.getText().trim();
            String major = majorJTF.getText().trim();
            String gender = "男";
            if (!JRB1.isSelected()) {
                gender = "女";
            }
            String phone = phoneJTF.getText().trim();
            String dept = deptJTF.getText().trim();
            String regdate = regJTF.getText().trim();
            int i = ReaderDao.updateReader(id,type,name,major,gender,phone,dept,regdate);
            System.out.println(i);
            if (i == 1){
                JOptionPane.showMessageDialog(null,"修改成功");
                Object[][] results = getSelect(ReaderDao.selectReader());
                jtable = new JTable(results,readersearch);
                jscrollPane.setViewportView(jtable);
                jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
        }
    }
    //”关闭“按钮事件监听器
    class CloseActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }



    public static void main(String[] args){
        new ReaderSelectandUpdate();
    }

}
