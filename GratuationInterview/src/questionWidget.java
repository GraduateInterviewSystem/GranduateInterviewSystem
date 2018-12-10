import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

import javax.swing.*;

public class questionWidget {
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static void main(String[] args) {
        questionWidget w1=new questionWidget();
    }
    public questionWidget() {
        //��ʼ��һ��jframe
        JFrame frame = new JFrame("ѧ����");

        //��ʼ��һ��panel
        JPanel panel = new JPanel();

        //��ʼ��һ������
        Container container = frame.getContentPane();


        JLabel label5=new JLabel("��Ŀ��Ϣ��");
        label5.setBounds(50,30,100,25);
        label5.setFont(new Font("",Font.PLAIN,16));
        JTextArea label6=new JTextArea();
        //label9.setSize(5000,5000);
        label6.setLineWrap(true);
        label6.setBounds(80,60,450,300);
        label6.setFont(new Font("",Font.PLAIN,16));

        panel.add(label5);
        panel.add(label6);
        label6.setText("�ۺ�������ʵ��Ҫ���쿼�����ۺ����ʡ��������������ڼ�Ŀ���������֪ʶ�ṹ���������������������������Ӧ�������ȣ��ڻش��ʱ�򲢲�Ҫ��ʮ�־�׼�Ĵ𰸣�����Ҫ������������Լ����߼��Եĳ������������ۺ�����֮ǰ�����Ϣ���Ѽ���֪ʶ��Ĵ������Լ��ڼ���ϰ���Ǳز����ٵġ�");
        panel.setLayout(null);

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
        try {
            group = InetAddress.getByName("224.0.0.1");//�鲥��ַ
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
