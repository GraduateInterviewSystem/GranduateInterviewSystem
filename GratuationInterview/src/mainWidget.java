import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

<<<<<<< HEAD

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

=======
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
public class mainWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public String stu_ID;
    public static JFrame frame = new JFrame("ѧ����");
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static questionWidget w1;
    public mainWidget(String userID){
        stu_ID=userID;
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
        mainWidget(stmt);
    }
	public void mainWidget(Statement stmt) {
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
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Timestamp time=new java.sql.Timestamp(System.currentTimeMillis());
                String time1=time.toString();
                String logoutInfo="insert into log values('"+stu_ID+"','-','"+time1+"')";
                try{
                    stmt.executeUpdate(logoutInfo);
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
                closeThis();
                new login();
            }
        });
        panel.add(logout);
        logout.setFocusPainted(false);
        
        JButton start = new JButton("ѡ��");
        start.setFocusPainted(false);
        start.setFont(new Font("����",Font.PLAIN,25));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String queryInfo="select S_major from student where S_stuID='"+stu_ID+"'";
                String major="";
                try {
                    rs = stmt.executeQuery(queryInfo);
                    if(rs.next()){
                        major=rs.getString("S_major");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                ArrayList<Integer> list=new ArrayList();
                list.add(1);
                list.add(2);
                list.add(3);
                int engNo;
                Random rand=new Random();
                int index1=rand.nextInt(3);
                int n1=list.get(index1);
                System.out.println("Ӣ����Ѷȣ�"+n1);
                while(true){
                    String choose1="select E_No from engque where E_level="+n1+" and E_flag=0";
                    try {
                        rs = stmt.executeQuery(choose1);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        if (rs.next()) {
                            engNo=rs.getInt("E_No");
                            System.out.println("engNo:"+engNo);
                            String updateFlag = "update engque set E_flag=1 where E_No=" + engNo;
                            stmt.executeUpdate(updateFlag);
                            break;
                        }
                        else{
                            String updateFlags = "update engque set E_flag=0 where E_level=" + n1 ;
                            stmt.executeUpdate(updateFlags);
                        }
                    }catch (SQLException e1){
                        e1.printStackTrace();
                    }

                }
                list.remove(index1);
                int index2=rand.nextInt(2);
                int n2=list.get(index2);
                System.out.println("���ο��Ѷȣ�"+n2);
                int polNo;
                while(true){
                    String choose2="select P_No from polque where P_level="+n2+" and P_flag=0";
                    try {
                        rs = stmt.executeQuery(choose2);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        if (rs.next()) {
                            polNo=rs.getInt("P_No");
                            System.out.println("polnum:"+polNo);
                            String updateFlag = "update polque set P_flag=1 where P_No=" + polNo;
                            stmt.executeUpdate(updateFlag);
                            break;
                        }
                        else{
                            String updateFlags = "update polque set P_flag=0 where P_level=" + n2 ;
                            stmt.executeUpdate(updateFlags);
                        }
                    }catch (SQLException e1){
                        e1.printStackTrace();
                    }

                }
                list.remove(index2);
                int n3=list.get(0);
                System.out.println("רҵ���Ѷȣ�"+n3);
                int majNo;
                while(true){
                    String choose3="select M_No from majque where M_Major='"+major+"'and M_level="+n3+" and M_flag=0";
                    try {
                        rs = stmt.executeQuery(choose3);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        if (rs.next()) {
                            majNo=rs.getInt("M_No");
                            System.out.println("majNum:"+majNo);
                            String updateFlag = "update majque set M_flag=1 where M_No=" + majNo;
                            stmt.executeUpdate(updateFlag);
                            break;
                        }
                        else{
                            String updateFlags = "update majque set M_flag=0 where M_level=" + n3 ;
                            stmt.executeUpdate(updateFlags);
                        }
                    }catch (SQLException e1){
                        e1.printStackTrace();
                    }

                }
                String insert="insert into queno values("+stu_ID+","+majNo+","+polNo+","+engNo+")";
                try {
                    stmt.executeUpdate(insert);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                new questionWidget();
    //            w1.broadcast();
                frame.dispose();
            }
        });

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
        frame.add(panel);

        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //���ô�С
        frame.setSize(600,500);

        //����λ��
        frame.setLocation(400, 200);

        //���ÿɼ���
        frame.setVisible(true);
<<<<<<< HEAD
  }
    public static void closeThis(){
        frame.dispose();
=======
>>>>>>> 4498caa156ac25db4b5753417aad8318df51e1b6
    }
}
