import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class titleDataset {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
	public static void main(String[] args) {
        //�������ݿ�
        try {
            System.out.println("��Ŀ��Ϣ��");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("���������ɹ�");
        } catch (ClassNotFoundException var2) {
            System.out.println("��������ʧ��!");
            var2.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("��Ŀ��Ϣ���ݿ����ӳɹ�!");
        } catch (SQLException var1) {
            System.out.println("��Ŀ��Ϣ���ݿ�����ʧ��!");
        }
       titleDataset w1=new titleDataset();
    }

public titleDataset() {
    try {
        System.out.println("��Ŀ��Ϣ��");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("���������ɹ�");
    } catch (ClassNotFoundException var2) {
        System.out.println("��������ʧ��!");
        var2.printStackTrace();
    }
    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("��Ŀ��Ϣ���ݿ����ӳɹ�!");
    } catch (SQLException var1) {
        System.out.println("��Ŀ��Ϣ���ݿ�����ʧ��!");
    }
	//��ʼ��һ��jframe
    JFrame frame = new JFrame("��Ŀ��Ϣ");

    //��ʼ��һ���˵���
    JMenuBar menuBar = new JMenuBar();

    //��ʼ���˵�
    JMenu menu1 = new JMenu("����(O)");
    menu1.setMnemonic('O');  
    menu1.setFont(new Font("����",Font.PLAIN,16));
    JMenu menu2 = new JMenu("����(H)");
    menu2.setMnemonic('H'); 
    menu2.setFont(new Font("����",Font.PLAIN,16));
    JMenu menu3 = new JMenu("��ѯ(Q)");
    menu3.setMnemonic('Q'); 
    menu3.setFont(new Font("����",Font.PLAIN,16));
    JMenu menu4 = new JMenu("ͳ��(S)");
    menu4.setMnemonic('S'); 
    menu4.setFont(new Font("����",Font.PLAIN,16));
    JMenu menu5 = new JMenu("ά��(M)");
    menu5.setMnemonic('M'); 
    menu5.setFont(new Font("����",Font.PLAIN,16));
    //��ʼ��һ��panel
    JPanel panel = new JPanel();

    //��ʼ��һ������
    Container container = frame.getContentPane();
    //�Ѳ˵���ӵ��˵���
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);
    menuBar.add(menu4);
    menuBar.add(menu5);
    //���ò˵���
    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("��ţ�");
    label1.setBounds(25,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JTextField text1 = new JTextField(20);
    text1.setBounds(65,30,150,25);
    panel.add(text1);
    
    JLabel label2=new JLabel("�Ѷȣ�");
    label2.setBounds(25,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));   
    JTextField text2 = new JTextField(20);
    text2.setBounds(65,60,150,25);
    panel.add(text2);
    
    JLabel label3=new JLabel("���ࣺ");
    label3.setBounds(300,30,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JComboBox comboBox1=new JComboBox();
    comboBox1.setBounds(340,30,150,25);
    comboBox1.addItem("");
    comboBox1.addItem("רҵ��");
    comboBox1.addItem("Ӣ����");
    comboBox1.addItem("������");
    panel.add(comboBox1);
    
    JLabel label4=new JLabel("רҵ��");
    label4.setBounds(300,60,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JTextField text4 = new JTextField(20);
    text4.setBounds(340,60,150,25);
    panel.add(text4);
    
    JLabel label5=new JLabel("���ݣ�");
    label5.setBounds(25,90,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    JTextField text5= new JTextField(2000);
    text5.setBounds(65,90,400,150);
    panel.add(text5);
    
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    //�ָ���
    JSplitPane split1=new JSplitPane();
    split1.setBounds(600, 0,1, 800);
    panel.add(split1);
    
    
    //�ñ����ʾ��Ŀ
    Object[] columnNames = {"���","����","רҵ","�Ѷ�","����","flag"};// ��������������
    // ��������������
    String[][] tableValues = {{"1","רҵ��","��ѧ","4",null,"0"},{"20","Ӣ��","Ӣ��","2",null,"0"},{"55","����","����","3",null,"0"},{"23","רҵ��","�����","4",null,"0"},{"1","רҵ��","��ѧ","4",null,"0"},{"44","רҵ��","����","4",null,"0"},{"24","Ӣ��","Ӣ��","3",null,"0"}};
    // ����ָ�����������ݵı��

    final DefaultTableModel[] model = {new DefaultTableModel()};
    Vector data = new Vector(); // ����������������Ϊ�б�ֹһ�У������������������������ӷ���add(row)
    Vector names = new Vector();// ����������ʹ������add()�����������
    JTable table = new JTable(model[0]);
    //��ʾ���ݿ���Ϣ
    names.add("���");
    names.add("����");
    names.add("רҵ");
    names.add("�Ѷ�");
    names.add("����");
    names.add("flag");
    //רҵ����Ŀ
    String viewtable = "select * from majque";
    try {
        rs = stmt.executeQuery(viewtable);
        while(rs.next()){
            String No = rs.getString("M_No");
            String major = rs.getString("M_Major");
            String level = rs.getString("M_level");
            String content = rs.getString("M_content");
            String flag = rs.getString("M_flag");
            Vector row = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
            row.add(No);
            row.add("רҵ��");
            row.add(major);
            row.add(level);
            row.add(content);
            row.add(flag);
            data.add(row);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //Ӣ������Ŀ
    String vieweng = "select * from engque";
    try {
        rs = stmt.executeQuery(vieweng);
        while(rs.next()){
            String No = rs.getString("E_No");
            String level = rs.getString("E_level");
            String content = rs.getString("E_content");
            String flag = rs.getString("E_flag");
            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
            row2.add(No);
            row2.add("Ӣ����");
            row2.add("");
            row2.add(level);
            row2.add(content);
            row2.add(flag);
            data.add(row2);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //��������Ŀ
    String viewpol = "select * from polque";
    try {
        rs = stmt.executeQuery(viewpol);
        while(rs.next()){
            String No = rs.getString("P_No");
            String level = rs.getString("P_level");
            String content = rs.getString("P_content");
            String flag = rs.getString("P_flag");
            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
            row2.add(No);
            row2.add("������");
            row2.add("");
            row2.add(level);
            row2.add(content);
            row2.add(flag);
            data.add(row2);
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }


    model[0].setDataVector(data, names); // ����ģ���е�Ԫ�أ������Զ���ʾ���б���
    JScrollPane jsp = new JScrollPane(table); // ���б����ɹ�����Panel�������Panel��ӵ�������
    jsp.setSize(600, 150);
    jsp.setLocation(0, 320);
    panel.add(jsp);

    table.setBounds(0,320,600,150);
    table.getTableHeader().setBounds(0, 300, 600, 20);
    panel.add(table.getTableHeader());



    //��Ӱ�ť
    JButton bt1=new JButton("���");
    bt1.setBounds(0, 250, 100, 35);
    bt1.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("����");
    bt2.setBounds(100, 250, 100, 35);
    bt2.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt2);
    JButton bt3=new JButton("ɾ��");
    bt3.setBounds(200, 250, 100, 35);
    bt3.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt3);
    JButton bt4=new JButton("���");
    bt4.setBounds(300, 250, 100, 35);
    bt4.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt4);
    JButton bt5=new JButton("�ر�");
    bt5.setBounds(400, 250, 100, 35);
    bt5.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt5);
    JButton bt6=new JButton("����");
    bt6.setBounds(500, 250, 100, 35);
    bt6.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt6);
    
    //����
    JLabel Clabel1=new JLabel("��ţ�");
    Clabel1.setBounds(620,60,100,25);
    Clabel1.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext1 = new JTextField(20);
    Ctext1.setBounds(660,60,150,25);
    panel.add(Ctext1);
    
    JLabel Clabel2=new JLabel("�Ѷȣ�");
    Clabel2.setBounds(620,90,100,25);
    Clabel2.setFont(new Font("",Font.PLAIN,16));   
    JTextField Ctext2 = new JTextField(20);
    Ctext2.setBounds(660,90,150,25);
    panel.add(Ctext2);
    
    JLabel Clabel3=new JLabel("���ࣺ");
    Clabel3.setBounds(620,120,100,25);
    Clabel3.setFont(new Font("",Font.PLAIN,16));
//    JTextField Ctext3 = new JTextField(20);
//    Ctext3.setBounds(660,120,150,25);
//    panel.add(Ctext3);
    
    JLabel Clabel4=new JLabel("רҵ��");
    Clabel4.setBounds(620,150,100,25);
    Clabel4.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext4 = new JTextField(20);
    Ctext4.setBounds(660,150,150,25);
    panel.add(Ctext4);
    
    JLabel Clabel5=new JLabel("����");
    Clabel5.setBounds(620,30,100,25);
    Clabel5.setFont(new Font("",Font.PLAIN,16));

    JComboBox comboBox=new JComboBox();
    comboBox.setBounds(660,120,150,25);
    comboBox.addItem("");
    comboBox.addItem("רҵ��");
    comboBox.addItem("Ӣ����");
    comboBox.addItem("������");
    panel.add(comboBox);


    panel.add(Clabel1);
    panel.add(Clabel2);
    panel.add(Clabel3);
    panel.add(Clabel4);
    panel.add(Clabel5);
    //��ѯ��ť
    JButton Cbt1=new JButton("��ѯ");
    Cbt1.setBounds(620, 250, 100, 35);
    Cbt1.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(Cbt1);
    JButton Cbt2=new JButton("����");
    Cbt2.setBounds(750, 250, 100, 35);
    Cbt2.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(Cbt2);
    //��panel��ӵ�����
    container.add(panel);

    //�����Ŀ
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            if (text1.getText().length()<=4&&!text1.getText().equals("")&&!text2.getText().equals("")&&!text5.getText().equals("")){
                if(comboBox1.getSelectedItem().equals("רҵ��")){
                    if (!text4.getText().equals("")){
                        String add_queInfo = "insert into majque(M_No,M_content,M_level,M_major) values('"+text1.getText()+"','"+text5.getText()+"'" +
                                ",'"+text2.getText()+"','"+text4.getText()+"')";
                        try {
                            stmt.executeUpdate(add_queInfo);
                            Vector rowData1 = new Vector();
                            rowData1.add(text1.getText());
                            rowData1.add("רҵ��");
                            rowData1.add(text4.getText());
                            rowData1.add(text2.getText());
                            rowData1.add(text5.getText());
                            data.add(rowData1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
//                            System.out.println("רҵ����ӳɹ�");
                            JOptionPane.showMessageDialog(null,"רҵ����Ŀ��ӳɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                            System.out.println("רҵ�����ʧ��");
                        }
                    }
                else{
//                        System.out.println("��ѡ��רҵ");
                        JOptionPane.showMessageDialog(null,"��ѡ��רҵ","��ʾ",JOptionPane.PLAIN_MESSAGE);
                    }
            }
                else if (comboBox1.getSelectedItem().equals("Ӣ����")){
                    String add_queInfo = "insert into engque(E_No,E_content,E_level) values('"+text1.getText()+"','"+text5.getText()+"'" +
                            ",'"+text2.getText()+"')";
                    try {
                        stmt.executeUpdate(add_queInfo);
                        Vector rowData2 = new Vector();
                        rowData2.add(text1.getText());
                        rowData2.add("Ӣ����");
                        rowData2.add("");
                        rowData2.add(text2.getText());
                        rowData2.add(text5.getText());
                        data.add(rowData2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
//                        System.out.println("Ӣ������ӳɹ�");
                        JOptionPane.showMessageDialog(null,"Ӣ������Ŀ��ӳɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        System.out.println("Ӣ�������ʧ��");
                    }
                }
                else if (comboBox1.getSelectedItem().equals("������")){
                    String add_queInfo = "insert into polque(P_No,P_content,P_level) values('"+text1.getText()+"','"+text5.getText()+"'" +
                            ",'"+text2.getText()+"')";
                    try {
                        stmt.executeUpdate(add_queInfo);
                        Vector rowData3 = new Vector();
                        rowData3.add(text1.getText());
                        rowData3.add("������");
                        rowData3.add("");
                        rowData3.add(text2.getText());
                        rowData3.add(text5.getText());
                        data.add(rowData3);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
//                        System.out.println("��������ӳɹ�");
                        JOptionPane.showMessageDialog(null,"��������Ŀ��ӳɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        System.out.println("���������ʧ��");
                    }
                }
                else{
//                    System.out.println("��ѡ����Ŀ����");
                    JOptionPane.showMessageDialog(null,"��ѡ����Ŀ����","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
        }
            else{
                System.out.println("��Ϣ�����Ϲ淶");
            }

        }
    });

    //������Ŀ��Ϣ
    bt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")) {
                if (comboBox1.getSelectedItem().equals("רҵ��")){
                    String selectInfo = "select M_No from majque where M_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //�����Ѷ�
                            if(!text2.getText().equals("")){
                                String updateMlevel = "update majque set M_level = '"+text2.getText()+"' where M_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateMlevel);
                            }
                            //��������
                            if(!text5.getText().equals("")){
                                String updateMcontent = "update majque set M_content = '"+text5.getText()+"' where M_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateMcontent);
                            }
                            System.out.println("���³ɹ�");
                        }
                        else{
                            System.out.println("��Ų����ڣ�����ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (comboBox1.getSelectedItem().equals("Ӣ����")){
                    String selectInfo = "select E_No from engque where E_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //�����Ѷ�
                            if(!text2.getText().equals("")){
                                String updateElevel = "update engque set E_level = '"+text2.getText()+"' where E_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateElevel);
                            }
                            //��������
                            if(!text5.getText().equals("")){
                                String updateEcontent = "update engque set E_content = '"+text5.getText()+"' where E_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateEcontent);
                            }
                            System.out.println("���³ɹ�");
                        }
                        else{
                            System.out.println("��Ų����ڣ�����ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(comboBox1.getSelectedItem().equals("������")){
                    String selectInfo = "select P_No from polque where P_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            //�����Ѷ�
                            if(!text2.getText().equals("")){
                                String updatePlevel = "update polque set P_level = '"+text2.getText()+"' where P_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updatePlevel);
                            }
                            //��������
                            if(!text5.getText().equals("")){
                                String updateEcontent = "update polque set P_content = '"+text5.getText()+"' where P_No = '"+text1.getText()+"'";
                                stmt.executeUpdate(updateEcontent);
                            }
                            System.out.println("���³ɹ�");
                        }
                        else{
                            System.out.println("��Ų����ڣ�����ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
//                    System.out.println("��ѡ����Ŀ����");
                    JOptionPane.showMessageDialog(null,"��ѡ����Ŀ����","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                //רҵ����Ŀ
                String viewtable = "select * from majque";
                try {
                    rs = stmt.executeQuery(viewtable);
                    while(rs.next()){
                        String No = rs.getString("M_No");
                        String major = rs.getString("M_Major");
                        String level = rs.getString("M_level");
                        String content = rs.getString("M_content");
                        String flag = rs.getString("M_flag");
                        Vector row = new Vector();
                        row.add(No);
                        row.add("רҵ��");
                        row.add(major);
                        row.add(level);
                        row.add(content);
                        row.add(flag);
                        data.add(row);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //Ӣ������Ŀ
                String vieweng = "select * from engque";
                try {
                    rs = stmt.executeQuery(vieweng);
                    while(rs.next()){
                        String No = rs.getString("E_No");
                        String level = rs.getString("E_level");
                        String content = rs.getString("E_content");
                        String flag = rs.getString("E_flag");
                        Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                        row2.add(No);
                        row2.add("Ӣ����");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //��������Ŀ
                String viewpol = "select * from polque";
                try {
                    rs = stmt.executeQuery(viewpol);
                    while(rs.next()){
                        String No = rs.getString("P_No");
                        String level = rs.getString("P_level");
                        String content = rs.getString("P_content");
                        String flag = rs.getString("P_flag");
                        Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                        row2.add(No);
                        row2.add("������");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    });


    //�����Ŀ��Ϣ
    bt4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
            //רҵ����Ŀ
            String viewtable = "select * from majque";
            try {
                rs = stmt.executeQuery(viewtable);
                while(rs.next()){
                    String No = rs.getString("M_No");
                    String major = rs.getString("M_Major");
                    String level = rs.getString("M_level");
                    String content = rs.getString("M_content");
                    String flag = rs.getString("M_flag");
                    Vector row = new Vector();
                    row.add(No);
                    row.add("רҵ��");
                    row.add(major);
                    row.add(level);
                    row.add(content);
                    row.add(flag);
                    data.add(row);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //Ӣ������Ŀ
            String vieweng = "select * from engque";
            try {
                rs = stmt.executeQuery(vieweng);
                while(rs.next()){
                    String No = rs.getString("E_No");
                    String level = rs.getString("E_level");
                    String content = rs.getString("E_content");
                    String flag = rs.getString("E_flag");
                    Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                    row2.add(No);
                    row2.add("Ӣ����");
                    row2.add("");
                    row2.add(level);
                    row2.add(content);
                    row2.add(flag);
                    data.add(row2);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            //��������Ŀ
            String viewpol = "select * from polque";
            try {
                rs = stmt.executeQuery(viewpol);
                while(rs.next()){
                    String No = rs.getString("P_No");
                    String level = rs.getString("P_level");
                    String content = rs.getString("P_content");
                    String flag = rs.getString("P_flag");
                    Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                    row2.add(No);
                    row2.add("������");
                    row2.add("");
                    row2.add(level);
                    row2.add(content);
                    row2.add(flag);
                    data.add(row2);
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });

    //ɾ����Ŀ��Ϣ
    bt3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!text1.getText().equals("")) {
                if (comboBox1.getSelectedItem().equals("רҵ��")){
                    String selectInfo = "select M_No from majque where M_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteM = "delete from majque where M_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteM);
//                            System.out.println("ɾ���ɹ�");
                            JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            System.out.println("��Ų����ڣ�ɾ��ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (comboBox1.getSelectedItem().equals("Ӣ����")){
                    String selectInfo = "select E_No from engque where E_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteE = "delete from engque where E_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteE);
//                            System.out.println("ɾ���ɹ�");
                            JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            System.out.println("��Ų����ڣ�ɾ��ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(comboBox1.getSelectedItem().equals("������")){
                    String selectInfo = "select P_No from polque where P_No='"+text1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectInfo);
                        if(rs.next()){
                            String deleteP = "delete from polque where P_No ='"+text1.getText()+"'";
                            stmt.executeUpdate(deleteP);
                            JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ",JOptionPane.PLAIN_MESSAGE);
//                            System.out.println("ɾ���ɹ�");
                        }
                        else{
                            System.out.println("��Ų����ڣ�ɾ��ʧ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    System.out.println("��ѡ����Ŀ����");
                }
                if(!data.isEmpty()){
                    data.clear();
                    model[0] = new DefaultTableModel(data, names);
                    table.setModel(model[0]);
                }
                //רҵ����Ŀ
                String viewtable = "select * from majque";
                try {
                    rs = stmt.executeQuery(viewtable);
                    while(rs.next()){
                        String No = rs.getString("M_No");
                        String major = rs.getString("M_Major");
                        String level = rs.getString("M_level");
                        String content = rs.getString("M_content");
                        String flag = rs.getString("M_flag");
                        Vector row = new Vector();
                        row.add(No);
                        row.add("רҵ��");
                        row.add(major);
                        row.add(level);
                        row.add(content);
                        row.add(flag);
                        data.add(row);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //Ӣ������Ŀ
                String vieweng = "select * from engque";
                try {
                    rs = stmt.executeQuery(vieweng);
                    while(rs.next()){
                        String No = rs.getString("E_No");
                        String level = rs.getString("E_level");
                        String content = rs.getString("E_content");
                        String flag = rs.getString("E_flag");
                        Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                        row2.add(No);
                        row2.add("Ӣ����");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //��������Ŀ
                String viewpol = "select * from polque";
                try {
                    rs = stmt.executeQuery(viewpol);
                    while(rs.next()){
                        String No = rs.getString("P_No");
                        String level = rs.getString("P_level");
                        String content = rs.getString("P_content");
                        String flag = rs.getString("P_flag");
                        Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                        row2.add(No);
                        row2.add("������");
                        row2.add("");
                        row2.add(level);
                        row2.add(content);
                        row2.add(flag);
                        data.add(row2);
                        model[0] = new DefaultTableModel(data, names);
                        table.setModel(model[0]);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            else{
//                System.out.println("���������");
                JOptionPane.showMessageDialog(null,"���������","��ʾ",JOptionPane.PLAIN_MESSAGE);
            }
        }
    });

    //flag����
    bt6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //רҵ��
            String setflagM = "update majque set M_flag = 0";
            try {
                stmt.executeUpdate(setflagM);
                //Ӣ����
                String setflagE = "update engque set E_flag = 0";
                stmt.executeUpdate(setflagE);
                //������
                String setflagP = "update polque set P_flag = 0";
                stmt.executeUpdate(setflagP);
                int r = table.getRowCount();
                for (int i = 0;i<r;i++){
                    model[0].setValueAt(0,i,5);
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    });


    //������Ŀ��Ϣ
    Cbt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
            if (comboBox.getSelectedItem().equals("")){
                if (Ctext4.getText().equals("")){
                    if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //ÿ������ֻ��Ψһһ��
                        //רҵ��
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("רҵ��Ų�����");
                            }
                            //Ӣ����
                            String selectE = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            if (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                data1.add(E_No);
                                data1.add("Ӣ����");
                                data1.add("");
                                data1.add(E_level);
                                data1.add(E_content);
                                data1.add(E_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("Ӣ����Ų�����");
                            }
                            //������
                            String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            if (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("������");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("������Ų�����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //�Ѷ�Ϊx����*3
                        //רҵ��
                        try {
                            String select = "select * from majque where M_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("���Ѷ�רҵ�ⲻ����");
                            }
                            //Ӣ����
                            String selectE = "select * from engque where E_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            if (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                data1.add(E_No);
                                data1.add("Ӣ����");
                                data1.add("");
                                data1.add(E_level);
                                data1.add(E_content);
                                data1.add(E_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("���Ѷ�Ӣ���ⲻ����");
                            }
                            //������
                            String selectP = "select * from polque where P_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            if (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("������");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("���Ѷ������ⲻ����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //���ҵ���ţ��ٶԱ��Ѷ��Ƿ���ͬ*3
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            while (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                if (M_level.equals(Ctext2.getText())){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("δ���ҵ���ؼ�¼");
                                }
                            }

                            //Ӣ����
                            String selectE = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectE);
                            while (rs.next()){
                                String E_No = rs.getString("E_No");
                                String E_content = rs.getString("E_content");
                                String E_level = rs.getString("E_level");
                                String E_flag = rs.getString("E_flag");
                                Vector data1 = new Vector();
                                if (E_level.equals(Ctext2.getText())){
                                    data1.add(E_No);
                                    data1.add("Ӣ����");
                                    data1.add("");
                                    data1.add(E_level);
                                    data1.add(E_content);
                                    data1.add(E_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("δ���ҵ���ؼ�¼");
                                }
                            }
                            //������
                            String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(selectP);
                            while (rs.next()){
                                String P_No = rs.getString("P_No");
                                String P_content = rs.getString("P_content");
                                String P_level = rs.getString("P_level");
                                String P_flag = rs.getString("P_flag");
                                if (P_level.equals(Ctext2.getText())){
                                    Vector data1 = new Vector();
                                    data1.add(P_No);
                                    data1.add("������");
                                    data1.add("");
                                    data1.add(P_level);
                                    data1.add(P_content);
                                    data1.add(P_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                                else{
                                    System.out.println("δ���ҵ���ؼ�¼");
                                }
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                else {
                    //��רҵ������רҵ����ƥ��������
                    String select = "select * from majque where M_Major = '"+Ctext4.getText()+"'";
                    try {
                        rs = stmt.executeQuery(select);
                        while (rs.next()){
                            String M_No = rs.getString("M_No");
                            String M_content = rs.getString("M_content");
                            String M_level = rs.getString("M_level");
                            String M_Major = rs.getString("M_Major");
                            String M_flag = rs.getString("M_flag");
                            if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)&&Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("רҵ��")){
                if (Ctext4.getText().equals("")){
                    if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //��ʾרҵ��������
                        //רҵ����Ŀ
                        String viewtable = "select * from majque";
                        try {
                            rs = stmt.executeQuery(viewtable);
                            while(rs.next()){
                                String No = rs.getString("M_No");
                                String major = rs.getString("M_Major");
                                String level = rs.getString("M_level");
                                String content = rs.getString("M_content");
                                String flag = rs.getString("M_flag");
                                Vector row = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                                row.add(No);
                                row.add("רҵ��");
                                row.add(major);
                                row.add(level);
                                row.add(content);
                                row.add(flag);
                                data.add(row);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                        //ֻ��Ψһһ��
                        //רҵ��
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("רҵ��Ų�����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //רҵ���Ѷ�Ϊx����
                        try {
                            String select = "select * from majque where M_level = '"+Ctext2.getText()+"'";
                            rs = stmt.executeQuery(select);
                            while (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                        //���ҵ���ţ��ٶԱ��Ѷ��Ƿ���ͬ
                        try {
                            String select = "select * from majque where M_No = '"+Ctext1.getText()+"'";
                            rs = stmt.executeQuery(select);
                            if (rs.next()){
                                String M_No = rs.getString("M_No");
                                String M_content = rs.getString("M_content");
                                String M_level = rs.getString("M_level");
                                String M_Major = rs.getString("M_Major");
                                String M_flag = rs.getString("M_flag");
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else{
                                System.out.println("רҵ���ѶȲ�����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                else {
                    //��רҵ����ƥ��������
                    //��רҵ������רҵ����ƥ��������
                    String select = "select * from majque where M_Major = '"+Ctext4.getText()+"'";
                    try {
                        rs = stmt.executeQuery(select);
                        while (rs.next()){
                            String M_No = rs.getString("M_No");
                            String M_content = rs.getString("M_content");
                            String M_level = rs.getString("M_level");
                            String M_Major = rs.getString("M_Major");
                            String M_flag = rs.getString("M_flag");
                            if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                Vector data1 = new Vector();
                                data1.add(M_No);
                                data1.add("רҵ��");
                                data1.add(M_Major);
                                data1.add(M_level);
                                data1.add(M_content);
                                data1.add(M_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                            else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                                if (Ctext1.getText().equals(M_No)&&Ctext2.getText().equals(M_level)){
                                    Vector data1 = new Vector();
                                    data1.add(M_No);
                                    data1.add("רҵ��");
                                    data1.add(M_Major);
                                    data1.add(M_level);
                                    data1.add(M_content);
                                    data1.add(M_flag);
                                    data.add(data1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                }
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("Ӣ����")){
                if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")) {
                    //��ʾӢ����������
                    String vieweng = "select * from engque";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        while (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                            row2.add(No);
                            row2.add("Ӣ����");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //ֻ��Ψһһ��
                    String vieweng = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        if (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                            row2.add(No);
                            row2.add("Ӣ����");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //�Ѷ�Ϊx����
                    String vieweng = "select * from engque where E_level = '"+Ctext2.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        while (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                            row2.add(No);
                            row2.add("Ӣ����");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //���ҵ���ţ��ٶԱ��Ѷ��Ƿ���ͬ
                    String vieweng = "select * from engque where E_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(vieweng);
                        if (rs.next()) {
                            String No = rs.getString("E_No");
                            String level = rs.getString("E_level");
                            String content = rs.getString("E_content");
                            String flag = rs.getString("E_flag");
                            if (level.equals(Ctext2.getText())){
                                Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                                row2.add(No);
                                row2.add("Ӣ����");
                                row2.add("");
                                row2.add(level);
                                row2.add(content);
                                row2.add(flag);
                                data.add(row2);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("����ѶȲ�ƥ��");
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if (comboBox.getSelectedItem().equals("������")){
                if (Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //��ʾ������������
                    //��������Ŀ
                    String viewpol = "select * from polque";
                    try {
                        rs = stmt.executeQuery(viewpol);
                        while(rs.next()){
                            String No = rs.getString("P_No");
                            String level = rs.getString("P_level");
                            String content = rs.getString("P_content");
                            String flag = rs.getString("P_flag");
                            Vector row2 = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                            row2.add(No);
                            row2.add("������");
                            row2.add("");
                            row2.add(level);
                            row2.add(content);
                            row2.add(flag);
                            data.add(row2);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&Ctext2.getText().equals("")){
                    //ֻ��Ψһһ��
                    String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        if (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            Vector data1 = new Vector();
                            data1.add(P_No);
                            data1.add("������");
                            data1.add("");
                            data1.add(P_level);
                            data1.add(P_content);
                            data1.add(P_flag);
                            data.add(data1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //�Ѷ�Ϊx����
                    String selectP = "select * from polque where P_level = '"+Ctext2.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        while (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            Vector data1 = new Vector();
                            data1.add(P_No);
                            data1.add("������");
                            data1.add("");
                            data1.add(P_level);
                            data1.add(P_content);
                            data1.add(P_flag);
                            data.add(data1);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (!Ctext1.getText().equals("")&&!Ctext2.getText().equals("")){
                    //���ҵ���ţ��ٶԱ��Ѷ��Ƿ���ͬ
                    String selectP = "select * from polque where P_No = '"+Ctext1.getText()+"'";
                    try {
                        rs = stmt.executeQuery(selectP);
                        if (rs.next()){
                            String P_No = rs.getString("P_No");
                            String P_content = rs.getString("P_content");
                            String P_level = rs.getString("P_level");
                            String P_flag = rs.getString("P_flag");
                            if (P_level.equals(Ctext2.getText())){
                                Vector data1 = new Vector();
                                data1.add(P_No);
                                data1.add("������");
                                data1.add("");
                                data1.add(P_level);
                                data1.add(P_content);
                                data1.add(P_flag);
                                data.add(data1);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                            else{
                                System.out.println("δ���ҵ���ؼ�¼");
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    });

    //����
    Cbt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            Ctext1.setText("");
            Ctext2.setText("");
            comboBox.setSelectedItem("");
            Ctext4.setText("");
            if(!data.isEmpty()){
                data.clear();
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
        }
    });

    //���ùرշ�ʽ
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //���ô�С
    frame.setSize(900,700);

    //����λ��
    frame.setLocation(400, 200);

    //���ÿɼ���
    frame.setVisible(true);
}
}
