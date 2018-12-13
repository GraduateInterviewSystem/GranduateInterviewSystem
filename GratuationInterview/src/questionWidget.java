import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class questionWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static JTextArea  label6;
    public static DatagramPacket dp;
    public static byte[] buffer;
    public static String s;
    public static void main(String[] args) {
        questionWidget w1=new questionWidget();
    }
    public questionWidget() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("���������ɹ�");
        } catch (ClassNotFoundException var2) {
            System.out.println("��������ʧ��!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("���ݿ����ӳɹ�");
        } catch (SQLException var1) {
            System.out.println("���ݿ�����ʧ��!");
        }
        //��ʼ��һ��jframe
        JFrame frame = new JFrame("ѧ����");

        //��ʼ��һ��panel
        JPanel panel = new JPanel();

        //��ʼ��һ������
        Container container = frame.getContentPane();


        JLabel label5=new JLabel("��Ŀ��Ϣ��");
        label5.setBounds(50,30,100,25);
        label5.setFont(new Font("",Font.PLAIN,16));
        label6=new JTextArea();
        label6.setLineWrap(true);
        label6.setBounds(80,60,450,200);
        label6.setFont(new Font("",Font.PLAIN,16));
        label6.setEditable(false);
        JTextArea label10=new JTextArea();
        label10.setLineWrap(true);
        label10.setBounds(80,300,450,50);
        label10.setFont(new Font("",Font.PLAIN,16));
        label10.setEditable(false);
        label10.setBackground(Color.lightGray);

        JButton bt3=new JButton("׼������");
        bt3.setBounds(450, 350, 100, 35);
        bt3.setFont(new Font("����",Font.PLAIN,16));
        panel.add(bt3);
        JMenu menu2 = new JMenu("����(H)");
        menu2.setMnemonic('H');
        menu2.setFont(new Font("����",Font.PLAIN,16));

        panel.add(menu2);
        panel.add(label5);
        panel.add(label6);
        panel.add(label10);
        label6.setText("�ۺ�������ʵ��Ҫ���쿼�����ۺ����ʡ��������������ڼ�Ŀ���������֪ʶ�ṹ���������������������������Ӧ�������ȣ��ڻش��ʱ�򲢲�Ҫ��ʮ�־�׼�Ĵ𰸣�����Ҫ������������Լ����߼��Եĳ������������ۺ�����֮ǰ�����Ϣ���Ѽ���֪ʶ��Ĵ������Լ��ڼ���ϰ���Ǳز����ٵġ�");
        label10.setText("�����Ѿ�׼���ô����׼���ûش���һ����Ŀ��������׼����������ť��׼��������һ��Ŀ����");
        panel.setLayout(null);


        //��panel��ӵ�����
        container.add(panel);


        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //���ô�С
        frame.setSize(600,500);

        //����λ��
        frame.setLocation(600, 250);

        //���ÿɼ���
        frame.setVisible(true);

        //���ô��ڴ�С���ɱ�
        frame.setResizable(false);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group = InetAddress.getByName("224.0.0.3");//�鲥��ַ
                    int port = 8888;
                    msr = new MulticastSocket(port);
                    msr.joinGroup(group);//��������
                    byte[] buffer = new byte[8192];
                    System.out.println("�������ݰ�������(����ʱ��: "+new Date()+")");
                    //����һ��ָ����������С�����ݰ�

                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                        msr.receive(dp);
                        String s = new String(dp.getData(),0,dp.getLength());
                        //�����鲥���ݰ�
                        System.out.println(s);
                        label6.setText(s);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }finally{
                    if(msr!=null){
                        try {
                            msr.leaveGroup(group);
                            msr.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                        }
                    }
                }
            }
        });

        //broadcast();
    }
    public void broadcast(){
        try {
            group = InetAddress.getByName("224.0.0.3");//�鲥��ַ
            int port = 8888;
            msr = new MulticastSocket(port);
            msr.joinGroup(group);//��������
            byte[] buffer = new byte[8192];
            System.out.println("�������ݰ�������(����ʱ��: "+new Date()+")");
            //����һ��ָ����������С�����ݰ�
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                msr.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                //�����鲥���ݰ�
                System.out.println(s);
                label6.setText(s);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(msr!=null){
                try {
                    msr.leaveGroup(group);
                    msr.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        }
    }
}
