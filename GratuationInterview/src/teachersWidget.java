import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import javax.swing.*;

public class teachersWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public String Tea_ID;
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static InetAddress group2;
    public static MulticastSocket msr2 = null;
    public static boolean flag = false;
    public static boolean flag2 = true;
    public static Integer count = 0;
    public static void main(String[] args) {
        teachersWidget w1=new teachersWidget("123");
    }
    public teachersWidget(String TeaID) {
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
        Tea_ID = TeaID;

        //��ʼ��һ��jframe
        JFrame frame = new JFrame("��ʦ��");

        //��ʼ��һ���˵���
        JMenuBar menuBar = new JMenuBar();

        //��ʼ���˵�
        JMenu menu1 = new JMenu("����(O)");
        menu1.setMnemonic('O');
        menu1.setFont(new Font("����", Font.PLAIN, 16));
        JMenuItem logout = new JMenuItem("ע��");
        menu1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
                String time1 = time.toString();
                String logoutInfo = "insert into log values('" + Tea_ID + "','-','" + time1 + "')";
                try {
                    stmt.executeUpdate(logoutInfo);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
                new login();
            }
        });

        //��ʼ��һ��panel
        JPanel panel = new JPanel();

        //��ʼ��һ������
        Container container = frame.getContentPane();
        //�Ѳ˵���ӵ��˵���
        menuBar.add(menu1);
//        menuBar.add(menu2);
//        menuBar.add(menu3);
//        menuBar.add(menu4);
//        menuBar.add(menu5);
        //���ò˵���
        frame.setJMenuBar(menuBar);

        panel.setLayout(null);

        JLabel label1 = new JLabel("���ţ�");
        label1.setBounds(50, 40, 100, 25);
        label1.setFont(new Font("", Font.PLAIN, 16));
        JLabel label2 = new JLabel("������");
        label2.setBounds(50, 70, 100, 25);
        label2.setFont(new Font("", Font.PLAIN, 16));
        JLabel label3 = new JLabel("רҵ��");
        label3.setBounds(50, 100, 100, 25);
        label3.setFont(new Font("", Font.PLAIN, 16));
        JTextArea label10 = new JTextArea("\n������Ϊ�ÿ����Դ���Ļش����Ѿ����⣬��������һ�⡱��ť��׼��������һ��Ŀ����\n\n�����Ըÿ����Ѿ�û���κ����ʣ���������һλ����׼��������һλ������Ϣ");
        label10.setLineWrap(true);
        label10.setBounds(30, 180, 250, 200);
        label10.setFont(new Font("", Font.PLAIN, 16));
        label10.setEditable(false);

        JLabel label5 = new JLabel("��Ŀ��Ϣ��");
        label5.setBounds(320, 20, 100, 25);
        label5.setFont(new Font("", Font.PLAIN, 16));
        JTextArea label6 = new JTextArea();
        //label9.setSize(5000,5000);
        label6.setLineWrap(true);
        label6.setBounds(320, 50, 250, 280);
        label6.setFont(new Font("", Font.PLAIN, 16));
        label6.setEditable(false);

        JLabel label9 = new JLabel(" ");
        label9.setBounds(100, 30, 100, 25);
        label9.setFont(new Font("", Font.PLAIN, 16));
        //��ֵ������
        JLabel label7 = new JLabel(" ");
        label7.setBounds(100, 60, 100, 25);
        label7.setFont(new Font("", Font.PLAIN, 16));
        //��ֵ��רҵ
        JLabel label8 = new JLabel(" ");
        label8.setBounds(100, 90, 100, 25);
        label8.setFont(new Font("", Font.PLAIN, 16));

        JButton bt2=new JButton("��һ��");
        bt2.setBounds(320, 350, 100, 35);
        bt2.setFont(new Font("����",Font.PLAIN,16));
        panel.add(bt2);
        JButton bt3=new JButton("��һλ");
        bt3.setBounds(450, 350, 100, 35);
        bt3.setFont(new Font("����",Font.PLAIN,16));
        panel.add(bt3);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        label6.setText("�ۺ�������ʵ��Ҫ���쿼�����ۺ����ʡ��������������ڼ�Ŀ���������֪ʶ�ṹ���������������������������Ӧ�������ȣ��ڻش��ʱ�򲢲�Ҫ��ʮ�־�׼�Ĵ𰸣�����Ҫ������������Լ����߼��Եĳ������������ۺ�����֮ǰ�����Ϣ���Ѽ���֪ʶ��Ĵ������Լ��ڼ���ϰ���Ǳز����ٵġ�");

        //�ָ���
        JSplitPane split1 = new JSplitPane();
        split1.setBounds(300, 0, 1, 500);
        panel.add(split1);
        //��panel��ӵ�����
        container.add(panel);
        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô�С
        frame.setSize(600, 500);
        //����λ��
        frame.setLocation(600, 300);

        //���ÿɼ���
        frame.setVisible(true);
        //���ô��ڴ�С���ɱ�
        frame.setResizable(false);
        //������Ϣ����
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group2 = InetAddress.getByName("224.0.0.2");//�鲥��ַ
                    int port = 8888;
                    msr2 = new MulticastSocket(port);
                    msr2.joinGroup(group2);//��������
                    byte[] buffer2 = new byte[8192];
                    int count = 0;
                    System.out.println("�������ݰ�������(����ʱ��: " + new Date() + ")" + group2);
                        DatagramPacket dp2 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp2);
                        String s2 = new String(dp2.getData(), 0, dp2.getLength());
                        //�����鲥���ݰ�
                        System.out.println(s2);
                        label9.setText(s2);
                        DatagramPacket dp3 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp3);
                        String s3 = new String(dp3.getData(), 0, dp3.getLength());
                        //�����鲥���ݰ�
                        System.out.println(s3);
                        label7.setText(s3);
                        DatagramPacket dp4 = new DatagramPacket(buffer2, buffer2.length);
                        msr2.receive(dp4);
                        String s4 = new String(dp4.getData(), 0, dp4.getLength());
                        //�����鲥���ݰ�
                        System.out.println(s4);
                        label8.setText(s4);
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    if (msr2 != null) {
                        try {
                            msr2.leaveGroup(group2);
                            msr2.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                        }
                    }
                }
            }
        });

            //��Ŀ��Ϣ����
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group = InetAddress.getByName("224.0.0.3");//�鲥��ַ
                    int port = 8888;
                    msr = new MulticastSocket(port);
                    msr.joinGroup(group);//��������
                    byte[] buffer = new byte[8192];
                    System.out.println("�������ݰ�������(����ʱ��: " + new Date() + ")" + group);
                        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                        msr.receive(dp);
                        String s = new String(dp.getData(), 0, dp.getLength());
                        //�����鲥���ݰ�
                        System.out.println(s);
                        label6.setText(s);
                } catch (Exception e3) {
                    e3.printStackTrace();
                } finally {
                    if (msr != null) {
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
    }
}
