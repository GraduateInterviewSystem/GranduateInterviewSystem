import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

import javax.swing.*;

public class teachersWidget {
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static InetAddress group2;
    public static MulticastSocket msr2 = null;
    public static boolean flag = false;
    public static boolean flag2 = true;
    public static void main(String[] args) {
        teachersWidget w1=new teachersWidget();
    }
    public teachersWidget() {
        //��ʼ��һ��jframe
        JFrame frame = new JFrame("��ʦ��");

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

        JLabel label1=new JLabel("���ţ�");
        label1.setBounds(50,30,100,25);
        label1.setFont(new Font("",Font.PLAIN,16));
        JLabel label2=new JLabel("������");
        label2.setBounds(50,60,100,25);
        label2.setFont(new Font("",Font.PLAIN,16));
        JLabel label3=new JLabel("רҵ��");
        label3.setBounds(50,90,100,25);
        label3.setFont(new Font("",Font.PLAIN,16));

        JLabel label5=new JLabel("��Ŀ��Ϣ��");
        label5.setBounds(320,20,100,25);
        label5.setFont(new Font("",Font.PLAIN,16));
        JTextArea label6=new JTextArea();
        //label9.setSize(5000,5000);
        label6.setLineWrap(true);
        label6.setBounds(320,50,250,280);
        label6.setFont(new Font("",Font.PLAIN,16));

        JLabel label9=new JLabel(" ");
        label9.setBounds(100,30,100,25);
        label9.setFont(new Font("",Font.PLAIN,16));
        //��ֵ������
        JLabel label7=new JLabel(" ");
        label7.setBounds(100,60,100,25);
        label7.setFont(new Font("",Font.PLAIN,16));
        //��ֵ��רҵ
        JLabel label8=new JLabel(" ");
        label8.setBounds(100,90,100,25);
        label8.setFont(new Font("",Font.PLAIN,16));

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        label6.setText("�ۺ�������ʵ��Ҫ���쿼�����ۺ����ʡ��������������ڼ�Ŀ���������֪ʶ�ṹ���������������������������Ӧ�������ȣ��ڻش��ʱ�򲢲�Ҫ��ʮ�־�׼�Ĵ𰸣�����Ҫ������������Լ����߼��Եĳ������������ۺ�����֮ǰ�����Ϣ���Ѽ���֪ʶ��Ĵ������Լ��ڼ���ϰ���Ǳز����ٵġ�");
        //�ָ���
        //�ָ���
        JSplitPane split1=new JSplitPane();
        split1.setBounds(300, 0,1, 500);
        panel.add(split1);




//        //�ñ����ʾ��Ŀ
//        Object[] columnNames = {"��Ŀ���","���","�鿴��ϸ"};// ��������������
//        // ��������������
//        String[][] tableValues = {{"��ѧ","1",null},{"Ӣ��","20",null},{"����","32",null}};
//        // ����ָ�����������ݵı��
//        JTable table = new JTable(tableValues,columnNames);
//        table.setBounds(320,70,250,50);
//        table.getTableHeader().setBounds(320, 50, 250, 20);
//        panel.add(table.getTableHeader());
//        panel.add(table);

        //��panel��ӵ�����
        container.add(panel);


        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //���ô�С
        frame.setSize(600,500);

        //����λ��
        frame.setLocation(100, 100);

        //���ÿɼ���
        frame.setVisible(true);
        //������Ϣ����
        while(true){
            try {
                group2 = InetAddress.getByName("224.0.0.2");//�鲥��ַ
                int port = 8888;
                msr2 = new MulticastSocket(port);
                msr2.joinGroup(group2);//��������
                byte[] buffer2 = new byte[8192];
                int count = 0;
                System.out.println("�������ݰ�������(����ʱ��: "+new Date()+")" + group2);
                while (flag2) {
                    DatagramPacket dp2 = new DatagramPacket(buffer2, buffer2.length);
                    msr2.receive(dp2);
                    String s2 = new String(dp2.getData(),0,dp2.getLength());
                    //�����鲥���ݰ�
                    System.out.println(s2);
                    label9.setText(s2);
                    DatagramPacket dp3 = new DatagramPacket(buffer2, buffer2.length);
                    msr2.receive(dp3);
                    String s3 = new String(dp3.getData(),0,dp3.getLength());
                    //�����鲥���ݰ�
                    System.out.println(s3);
                    label7.setText(s3);
                    DatagramPacket dp4 = new DatagramPacket(buffer2, buffer2.length);
                    msr2.receive(dp4);
                    String s4 = new String(dp4.getData(),0,dp4.getLength());
                    //�����鲥���ݰ�
                    System.out.println(s4);
                    label8.setText(s4);
                    flag2 = false;
                    flag = true;

                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }finally {
                if (msr2 != null) {
                    try {
                        msr2.leaveGroup(group2);
                        msr2.close();
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            }
            //��Ŀ��Ϣ����
            try {
                group = InetAddress.getByName("224.0.0.1");//�鲥��ַ
                int port = 8888;
                msr = new MulticastSocket(port);
                msr.joinGroup(group);//��������
                byte[] buffer = new byte[8192];
                System.out.println("�������ݰ�������(����ʱ��: "+new Date()+")" + group);
                int count = 0;
                while (flag) {
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                    msr.receive(dp);
                    String s = new String(dp.getData(),0,dp.getLength());
                    //�����鲥���ݰ�
                    System.out.println(s);
                    label6.setText(s);
                    count++;
                    if (count >= 3) {
                        flag = false;
                        flag2 = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
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

}
}

