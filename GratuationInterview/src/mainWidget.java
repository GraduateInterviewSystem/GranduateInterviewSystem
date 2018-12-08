import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class mainWidget {
    public static MulticastSocket msr = null;
    public static InetAddress group;
	public static void main(String[] args) {
        mainWidget w1=new mainWidget();
    }
	public mainWidget() {
		//��ʼ��һ��jframe
        JFrame frame = new JFrame("ѧ����");

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

        //��ʼ��һ����ť
        JButton logout = new JButton("ע��");
        logout.setFont(new Font("����",Font.PLAIN,16));
        logout.setBounds(400,250, 100, 35);
        panel.add(logout);
        logout.setFocusPainted(false);
        
        JButton start = new JButton("ѡ��");
        start.setFocusPainted(false);
        start.setFont(new Font("����",Font.PLAIN,25));
        start.setBounds(250,100, 100, 75);
        panel.add(start);
 
        //�Ѳ˵���ӵ��˵���
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        //���ò˵���
        frame.setJMenuBar(menuBar);
        
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
            group = InetAddress.getByName("224.0.0.2");//�鲥��ַ
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
