import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
=======
import javax.swing.*;
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2


public class login {
        public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
        public static String username = "manager";
        public static String password = "123456";
        public static Connection con;
        public static Statement stmt;
        public static ResultSet rs;
    public static void main(String[] args) {


        try {
            System.out.println("��¼��");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("���������ɹ�");
        } catch (ClassNotFoundException var2) {
            System.out.println("��������ʧ��!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("���ӳɹ�");
        } catch (SQLException var1) {
            System.out.println("����ʧ��!");
        }
        login s = new login();
    }

    public login() {
// ���� JFrame ʵ��
        JFrame frame = new JFrame("��¼");
        // Setting the width and height of frame
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������壬��������� HTML �� div ��ǩ
         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
         * ��������ǿ�������ı��ֶΣ���ť�����������
         */
        JPanel panel = new JPanel();
        // ������
<<<<<<< HEAD
        frame.add(panel);
        /*
         * �����û�����ķ����������������
         */

        // ���ý���ɼ�
        frame.setVisible(true);

=======
>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        panel.setLayout(null);

        // ���� JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setFont(new Font("",Font.PLAIN,16));
        userLabel.setBounds(100,60,250,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(140,60,165,25);
        panel.add(userText);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("",Font.PLAIN,16));
        passwordLabel.setBounds(60,100,80,25);
        panel.add(passwordLabel);


        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(140,100,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setFont(new Font("",Font.PLAIN,16));
        loginButton.setBounds(170, 180, 100, 35);
        panel.add(loginButton);

<<<<<<< HEAD
=======
        frame.add(panel);
        /*
         * �����û�����ķ����������������
         */

        // ���ý���ɼ�
        frame.setVisible(true);

        frame.setLocation(600, 300);
<<<<<<< HEAD
        //���ô��ڴ�С���ɱ�
        frame.setResizable(false);
=======

>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
        //��¼
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(userText.getText().equals("")){
<<<<<<< HEAD
                    JOptionPane.showMessageDialog(null,"�������˺�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
                else if(passW.equals("")){
=======
//                    System.out.println("�������˺�");
                    JOptionPane.showMessageDialog(null,"�������˺�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
                else if(passW.equals("")){
//                    System.out.println("����������");
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                    JOptionPane.showMessageDialog(null,"����������","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if(userText.getText().length()==11){
                        String select = "select S_stuID,S_password from student where S_stuID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("S_password")==null){
                                    System.out.println("δ��������");
                                }
                                else{
                                    if(rs.getString("S_password").equals(passW)){
                                        java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                                        String time1=time.toString();
                                        String logInfo="insert into log values('"+rs.getString("S_stuID")+"','"+rs.getString("S_password")+"','"+time1+"')";
                                        try{
                                            stmt.executeUpdate(logInfo);
                                        }catch (SQLException e1) {
                                            e1.printStackTrace();
                                        }
                                        frame.dispose();
                                        mainWidget m=new mainWidget(userText.getText());
                                    }
                                    else{
<<<<<<< HEAD
                                        JOptionPane.showMessageDialog(null,"�˺����벻ƥ��","��ʾ",JOptionPane.PLAIN_MESSAGE);
=======
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                                    }
                                }
                            }
                            else{
                                System.out.println("�ÿ���δ�Ǽ�");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length()==6){
                        String select = "select T_TeaID,T_password,T_flag from teacher where T_TeaID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("T_password")==null){
                                    System.out.println("δ��������");
                                }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                                else {
                                    if (rs.getString("T_password").equals(passW)) {
                                        int flag=rs.getInt("T_flag");
                                        if(flag==0){
                                            java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                                            String time1=time.toString();
                                            String logInfo="insert into log values('"+rs.getString("T_TeaID")+"','"+rs.getString("T_password")+"','"+time1+"')";
                                            try{
                                                stmt.executeUpdate(logInfo);
                                            }catch (SQLException e1) {
                                                e1.printStackTrace();
                                            }
                                            frame.dispose();
                                            new teachersWidget(userText.getText());
                                        }
                                        else{
                                            java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                                            String time1=time.toString();
                                            String logInfo="insert into log values('"+rs.getString("T_TeaID")+"','"+rs.getString("T_password")+"','"+time1+"')";
                                            try{
                                                stmt.executeUpdate(logInfo);
                                            }catch (SQLException e1) {
                                                e1.printStackTrace();
                                            }
                                            frame.dispose();
                                            new teacherMainWidget(userText.getText());
                                        }
                                    } else {
<<<<<<< HEAD
                                        JOptionPane.showMessageDialog(null,"�˺����벻ƥ��","��ʾ",JOptionPane.PLAIN_MESSAGE);
=======
                                        System.out.println("�������");
=======
                                else{
                                    if(rs.getString("T_password").equals(passW)){
                                        /*��½�ɹ���ת����





                                         */
                                    }
                                    else{
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                                    }
                                }                                }

                            else{
                                System.out.println("�õ�ʦδ�Ǽ�");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else if(userText.getText().length()==2){
                        String select = "select M_manID,M_password from manager where M_manID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("M_password")==null){
                                    System.out.println("δ��������");
                                }
                                else{
                                    if(rs.getString("M_password").equals(passW)){
                                        java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                                        String time1=time.toString();
                                        String logInfo="insert into log values('"+rs.getString("M_manID")+"','"+rs.getString("M_password")+"','"+time1+"')";
                                        try{
                                            stmt.executeUpdate(logInfo);
                                        }catch (SQLException e1) {
                                            e1.printStackTrace();
                                        }
                                        new admin();
                                        frame.dispose();
                                    }
                                    else{
<<<<<<< HEAD
                                        JOptionPane.showMessageDialog(null,"�˺����벻ƥ��","��ʾ",JOptionPane.PLAIN_MESSAGE);
=======
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
>>>>>>> 4850ae774c435ed590eb701117713f0e6a1b52c2
                                    }
                                }
                            }
                            else{
                                System.out.println("�ù���Ա������");
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

    }
}


