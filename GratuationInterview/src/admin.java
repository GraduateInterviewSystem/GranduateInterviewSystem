import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;


public class admin {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
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
    String viewtable = "select * from password";
    try {
        try {
            rs = stmt.executeQuery(viewtable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
        }
    }

	    JTable table = new JTable(tableValues,columnNames);
	    table.setBounds(10,70,250,100);
	    table.setRowHeight(30);
	    table.setFont(new Font("",Font.PLAIN,16));
	    table.getTableHeader().setBounds(10, 50, 250, 20);
	    panel.add(table.getTableHeader());
	    panel.add(table);
	    
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
        
        JLabel classLabel = new JLabel("���:");
        classLabel.setFont(new Font("",Font.PLAIN,16));
        classLabel.setBounds(300,100,80,25);
        panel.add(classLabel);
        
//        JComboBox comboBox=new JComboBox();
//        comboBox.setBounds(350,100,100,20);
//        comboBox.addItem("student");
//        comboBox.addItem("teacher");
//        panel.add(comboBox);

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
                        if(userText.getText().length()==11||userText.getText().length()==6||userText.getText().length()==2) {
                            String addPass = "insert into password(ID,password) values('"+userText.getText()+"','"+passW+"')";
                            stmt.executeUpdate(addPass);

                        }
                        else{
                            System.out.println("�˺ų��Ȳ�ƥ��");
                        }



                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
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
}
