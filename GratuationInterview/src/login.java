import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


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



>>>>>>> c1aeefb3f04ab20f4098d9c4dc5d773db1493b67
        //��¼
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passW = String.valueOf(passwordText.getPassword());
                if(userText.getText().equals("")){
//                    System.out.println("�������˺�");
                    JOptionPane.showMessageDialog(null,"�������˺�","��ʾ",JOptionPane.PLAIN_MESSAGE);
                }
                else if(passW.equals("")){
//                    System.out.println("����������");
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
                                        /*��½�ɹ���ת����





                                         */
                                    }
                                    else{
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
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
                        String select = "select T_TeaID,T_password from teacher where T_TeaID='"+userText.getText()+"'";
                        try {
                            rs = stmt.executeQuery(select);
                            if(rs.next()){
                                if(rs.getString("T_password")==null){
                                    System.out.println("δ��������");
                                }
                                else{
                                    if(rs.getString("T_password").equals(passW)){
                                        /*��½�ɹ���ת����





                                         */
                                    }
                                    else{
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
                                    }
                                }
                            }
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
                                        /*��½�ɹ���ת����





                                         */
                                    }
                                    else{
//                                        System.out.println("�������");
                                        JOptionPane.showMessageDialog(null,"�������","��ʾ",JOptionPane.PLAIN_MESSAGE);
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


