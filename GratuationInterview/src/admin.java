import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class admin {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
<<<<<<< HEAD
    public static void main(String[]args) {
=======
public static void main(String[]args) throws SQLException {
    try {
        System.out.println("�˺Ź���");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("���������ɹ�");
    } catch (ClassNotFoundException var2) {
        System.out.println("��������ʧ��!");
        var2.printStackTrace();
    }
    try {
        con = DriverManager.getConnection(url, username, password);
        stmt = con.createStatement();
        System.out.println("�˺Ź������ݿ����ӳɹ�");
    } catch (SQLException var1) {
        System.out.println("�˺Ź������ݿ�����ʧ��!");
    }
	admin a=new admin();
}
public admin() {
	JFrame frame=new JFrame("����Ա����");
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
    //�Ѳ˵���ӵ��˵���
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);
    menuBar.add(menu4);
    menuBar.add(menu5);
    //���ò˵���
    frame.setJMenuBar(menuBar);
    
    JPanel panel=new JPanel();
    Container container = frame.getContentPane();
	panel.setLayout(null);
	   
//	  Object[] columnNames = {"�˺�","����","���"};// ��������������
//	    // ��������������
//	    String[][] tableValues = {{"001","123",null},{"002","234",null},{"003","562",null}};
//	    // ����ָ�����������ݵı��
        final DefaultTableModel[] model = {new DefaultTableModel()};
        Vector data = new Vector(); // ����������������Ϊ�б�ֹһ�У������������������������ӷ���add(row)
        Vector names = new Vector();// ����������ʹ������add()�����������
        JTable table = new JTable(model[0]);
        names.add("�˺�");
        names.add("����");
        names.add("���");
    String viewtable = "select * from password";
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        try {
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }
<<<<<<< HEAD

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
        }
        admin a=new admin();
    }
    public admin() {
        try {
            System.out.println("登录：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败!");
        }
        JFrame frame=new JFrame("管理员界面");
        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("操作(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu2 = new JMenu("帮助(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu3 = new JMenu("查询(Q)");
        menu3.setMnemonic('Q');
        menu3.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu4 = new JMenu("统计(S)");
        menu4.setMnemonic('S');
        menu4.setFont(new Font("宋体",Font.PLAIN,16));
        JMenu menu5 = new JMenu("维护(M)");
        menu5.setMnemonic('M');
        menu5.setFont(new Font("宋体",Font.PLAIN,16));
        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //设置菜单栏
        frame.setJMenuBar(menuBar);

        JPanel panel=new JPanel();
        Container container = frame.getContentPane();
        panel.setLayout(null);

        JButton stuManageButton = new JButton("管理学生信息");
        stuManageButton.setFont(new Font("",Font.PLAIN,16));
        stuManageButton.setBounds(20, 20, 150, 35);
        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDataset();
                frame.dispose();
=======
        model[0].setDataVector(data, names); // ����ģ���е�Ԫ�أ������Զ���ʾ���б���
        JScrollPane jsp = new JScrollPane(table); // ���б����ɹ�����Panel�������Panel��ӵ�������
        jsp.setSize(200, 200);
        jsp.setLocation(10, 70);
        panel.add(jsp);
	    table.setBounds(10,70,200,200);
	    table.setRowHeight(30);
	    table.setFont(new Font("",Font.PLAIN,16));
	    table.getTableHeader().setBounds(10, 50, 250, 20);
	    
	    //�����ı���
	    JLabel userLabel = new JLabel("�˺�:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(300,40,250,25);
        panel.add(userLabel);
        
	    JTextField userText = new JTextField(20);
        userText.setBounds(350,40,165,25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("����:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(300,70,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(350,70,165,25);
        panel.add(passwordText);

        JButton addButton = new JButton("���");
        addButton.setFont(new Font("",Font.PLAIN,16));
        addButton.setBounds(300, 150, 70, 35);
        panel.add(addButton);
        
        JButton updateButton = new JButton("����");
        updateButton.setFont(new Font("",Font.PLAIN,16));
        updateButton.setBounds(400, 150, 70, 35);
        panel.add(updateButton);
        
        JButton deleteButton = new JButton("ɾ��");
        deleteButton.setFont(new Font("",Font.PLAIN,16));
        deleteButton.setBounds(500, 150, 70, 35);
        panel.add(deleteButton);
        

	    container.add(panel);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //����˺�����
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(!userText.getText().equals("")&&!passW.equals("")){
                    try {
                        if(passW.length()==8){
                            if(userText.getText().length()==11) {
                                String viewtable = "select S_stuID from student where S_stuID='"+userText.getText()+"'";
                                rs = stmt.executeQuery(viewtable);
                                if(rs.next()){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','����')";
                                    String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addstup);
                                    Vector rowData1 = new Vector();
                                    rowData1.add(userText.getText());
                                    rowData1.add(passW);
                                    rowData1.add("����");
                                    data.add(rowData1);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("�����˺�������ӳɹ�");
                                }
                                else{
                                    System.out.println("�ÿ����˺Ų�����");
                                }
                            }
                            else if(userText.getText().length()==6){
                                String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                rs = stmt.executeQuery(viewtable);
                                if(rs.next()){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','��ʦ')";
                                    String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addteap);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("��ʦ");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("��ʦ�˺�������ӳɹ�");
                                }
                                else{
                                    System.out.println("�õ�ʦ�˺Ų�����");
                                }
                            }
                            else if(userText.getText().length()==2){
                                String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','����Ա')";
                                String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                stmt.executeUpdate(addPass);
                                stmt.executeUpdate(addmanp);
                                Vector rowData2 = new Vector();
                                rowData2.add(userText.getText());
                                rowData2.add(passW);
                                rowData2.add("����Ա");
                                data.add(rowData2);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                                System.out.println("����Ա�˺�������ӳɹ�");
                            }
                            else{
                                System.out.println("�˺ų��Ȳ�ƥ��");
                            }
                        }
                     else {
                            System.out.println("����Ϊ��λ��");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    System.out.println("�˺�������ͬʱ���");
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
            }
        });
        panel.add(stuManageButton);

<<<<<<< HEAD
        JButton teaManageButton = new JButton("管理老师信息");
        teaManageButton.setFont(new Font("",Font.PLAIN,16));
        teaManageButton.setBounds(20, 60, 150, 35);
        teaManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new teacherManagement();
                frame.dispose();
=======
        //�����˺�����
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(!userText.getText().equals("")&&!passW.equals("")){
                    if (passW.length()==8){
                        String select = "select * from password where ID = '"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if (userText.getText().length()==11){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_stu = "update student set S_password = '"+passW+"' where S_stuID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_stu);
                                }
                                else if(userText.getText().length()==6){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_tea = "update teacher set T_password = '"+passW+"' where T_TeaID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_tea);
                                }
                                else if(userText.getText().length()==2){
                                    String update ="update password set password = '"+passW+"' where ID = '"+userText.getText()+"'";
                                    String update_man = "update manager set M_password = '"+passW+"' where M_manID = '"+userText.getText()+"'";
                                    stmt.executeUpdate(update);
                                    stmt.executeUpdate(update_man);
                                }
                            }
                            else{
                                if(userText.getText().length()==11) {
                                    String viewtable = "select S_stuID from student where S_stuID='"+userText.getText()+"'";
                                    rs = stmt.executeQuery(viewtable);
                                    if(rs.next()){
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','����')";
                                        String addstup = "update student set S_password = '"+passW+"' where S_stuID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addstup);
                                        Vector rowData1 = new Vector();
                                        rowData1.add(userText.getText());
                                        rowData1.add(passW);
                                        rowData1.add("����");
                                        data.add(rowData1);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
                                        System.out.println("�����˺�������ӳɹ�");
                                    }
                                    else{
                                        System.out.println("�ÿ����˺Ų�����");
                                    }
                                }
                                else if(userText.getText().length()==6){
                                    String viewtable = "select T_TeaID from teacher where T_TeaID='"+userText.getText()+"'";
                                    rs = stmt.executeQuery(viewtable);
                                    if(rs.next()){
                                        String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','��ʦ')";
                                        String addteap = "update teacher set T_password = '"+passW+"' where T_TeaID='"+userText.getText()+"'";
                                        stmt.executeUpdate(addPass);
                                        stmt.executeUpdate(addteap);
                                        Vector rowData2 = new Vector();
                                        rowData2.add(userText.getText());
                                        rowData2.add(passW);
                                        rowData2.add("��ʦ");
                                        data.add(rowData2);
                                        model[0] = new DefaultTableModel(data, names);
                                        table.setModel(model[0]);
                                        System.out.println("��ʦ�˺�������ӳɹ�");
                                    }
                                    else{
                                        System.out.println("�õ�ʦ�˺Ų�����");
                                    }
                                }
                                else if(userText.getText().length()==2){
                                    String addPass = "insert into password(ID,password,type) values('"+userText.getText()+"','"+passW+"','����Ա')";
                                    String addmanp = "insert into manager(M_manID,M_password) values('"+userText.getText()+"','"+passW+"')";
                                    stmt.executeUpdate(addPass);
                                    stmt.executeUpdate(addmanp);
                                    Vector rowData2 = new Vector();
                                    rowData2.add(userText.getText());
                                    rowData2.add(passW);
                                    rowData2.add("����Ա");
                                    data.add(rowData2);
                                    model[0] = new DefaultTableModel(data, names);
                                    table.setModel(model[0]);
                                    System.out.println("����Ա�˺�������ӳɹ�");
                                }
                                else{
                                    System.out.println("�˻�������");
                                }
                            }
                            String selectall = "select * from password";
                            data.clear();
                            rs = stmt.executeQuery(selectall);
                            while(rs.next()){
                                String pass = rs.getString("password");
                                String id = rs.getString("ID");
                                String type = rs.getString("type");
                                Vector rowData3 = new Vector();
                                rowData3.add(id);
                                rowData3.add(pass);
                                rowData3.add(type);
                                data.add(rowData3);
                                model[0] = new DefaultTableModel(data, names);
                                table.setModel(model[0]);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }

                    else{
                        System.out.println("�������Ϊ��λ��");
                    }
                }
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
            }
        });
        panel.add(teaManageButton);

<<<<<<< HEAD
        JButton titleButton = new JButton("管理题目信息");
        titleButton.setFont(new Font("",Font.PLAIN,16));
        titleButton.setBounds(20, 100, 150, 35);
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new titleDataset();
                frame.dispose();
            }
        });
        panel.add(titleButton);

        JLabel label=new JLabel("选择面试科目：");
        label.setBounds(20,140,100,25);
        label.setFont(new Font("",Font.PLAIN,16));
        JComboBox combo=new JComboBox();
        combo.setBounds(200,140,150,25);
        combo.addItem("英语");
        combo.addItem("数学");
        combo.addItem("计算机");
        combo.addItem("物理");
        combo.addItem("化学");
        combo.addItem("政治");
        panel.add(combo);
        panel.add(label);
        JButton commitButton = new JButton("提交");
        commitButton.setFont(new Font("",Font.PLAIN,16));
        commitButton.setBounds(80, 180, 150, 35);

        panel.add(commitButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(100, 100);

        //设置可见性
        frame.setVisible(true);
    }
=======
        //ɾ���˺�����
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String passW = String.valueOf(passwordText.getPassword());
            if (!userText.getText().equals("") && !passW.equals("")) {
                if (passW.length() == 8) {
                    if (userText.getText().length() == 11) {
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update student set S_password='' where S_stuID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
                                    System.out.println("�����˺�����ɾ���ɹ�");
                                } else {
                                    System.out.println("�˺����벻ƥ��");
                                }
                            } else {
                                System.out.println("�˺����벻����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else if (userText.getText().length() == 6) {
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update teacher set T_password='' where T_TeaID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
                                    System.out.println("��ʦ�˺�����ɾ���ɹ�");
                                } else {
                                    System.out.println("�˺����벻ƥ��");
                                }
                            } else {
                                System.out.println("�˺����벻����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length() ==2){
                        String select = "select password from password where ID='" + userText.getText() + "'";
                        try {
                            rs = stmt.executeQuery(select);
                            if (rs.next()) {
                                if (rs.getString("password").equals(passW)) {
                                    String delete = "delete from password where ID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete);
                                    String delete_stu = "update manager set M_password='' where M_manID = '" + userText.getText() + "'";
                                    stmt.executeUpdate(delete_stu);
                                    System.out.println("����Ա�˺�����ɾ���ɹ�");
                                } else {
                                    System.out.println("�˺����벻ƥ��");
                                }
                            } else {
                                System.out.println("�˺����벻����");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    data.clear();
                    String select = "select * from password";
                    try {
                        rs = stmt.executeQuery(select);
                        while(rs.next()){
                            String pass = rs.getString("password");
                            String id = rs.getString("ID");
                            String type = rs.getString("type");
                            Vector rowData4 = new Vector();
                            rowData4.add(id);
                            rowData4.add(pass);
                            rowData4.add(type);
                            data.add(rowData4);
                            model[0] = new DefaultTableModel(data, names);
                            table.setModel(model[0]);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("ɾ��ʧ�ܣ�");
                }
            } else {
                System.out.println("�������˺ź�����");
            }
        }
    });
	    //���ô�С
	    frame.setSize(600,500);

	    //����λ��
	    frame.setLocation(100, 100);

	    //���ÿɼ���
	    frame.setVisible(true);
}
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
}
