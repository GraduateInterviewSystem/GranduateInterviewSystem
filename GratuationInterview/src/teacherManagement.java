import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class teacherManagement {
	public static void main(String[] args) {
		teacherManagement w1=new teacherManagement();
    }
public teacherManagement() {
	//��ʼ��һ��jframe
    JFrame frame = new JFrame("��ʦ��Ϣ����");

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
    
    JLabel label1=new JLabel("������");
    label1.setBounds(25,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JTextField text1 = new JTextField(20);
    text1.setBounds(65,30,150,25);
    panel.add(text1);
    
    JLabel label2=new JLabel("���ţ�");
    label2.setBounds(25,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));   
    JTextField text2 = new JTextField(20);
    text2.setBounds(65,60,150,25);
    panel.add(text2);
    
    JLabel label3=new JLabel("רҵ��");
    label3.setBounds(300,30,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JTextField text3 = new JTextField(20);
    text3.setBounds(340,30,150,25);
    panel.add(text3);
    
    
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);

    //�ָ���
    JSplitPane split1=new JSplitPane();
    split1.setBounds(500, 0,1, 800);
    panel.add(split1);
    
    
    //�ñ����ʾ��Ŀ
    Object[] columnNames = {"����","����","רҵ"};// ��������������
    // ��������������
    String[][] tableValues = {{"����","001","����"},{"����","002","Ӣ��"},{"��������","003","����"}};
    // ����ָ�����������ݵı��
    JTable table = new JTable(tableValues,columnNames);
    table.setBounds(0,190,500,150);
    table.setRowHeight(30);
    table.setFont(new Font("����",Font.PLAIN,16));
    table.getTableHeader().setBounds(0, 160, 500, 30);
    table.getTableHeader().setFont(new Font("����",Font.PLAIN,16));
    panel.add(table.getTableHeader());
    panel.add(table);
    //��Ӱ�ť
    JButton bt1=new JButton("���");
    bt1.setBounds(0, 100, 100, 35);
    bt1.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("����");
    bt2.setBounds(100, 100, 100, 35);
    bt2.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt2);
    JButton bt3=new JButton("ɾ��");
    bt3.setBounds(200, 100, 100, 35);
    bt3.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt3);
    JButton bt4=new JButton("���");
    bt4.setBounds(300, 100, 100, 35);
    bt4.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt4);
    JButton bt5=new JButton("�ر�");
    bt5.setBounds(400, 100, 100, 35);
    bt5.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt5);

    
    //����
    JLabel Clabel1=new JLabel("���ţ�");
    Clabel1.setBounds(520,60,100,25);
    Clabel1.setFont(new Font("",Font.PLAIN,16));
    JTextField Ctext1 = new JTextField(20);
    Ctext1.setBounds(560,60,150,25);
    panel.add(Ctext1);
    
    JLabel Clabel2=new JLabel("������");
    Clabel2.setBounds(520,90,100,25);
    Clabel2.setFont(new Font("",Font.PLAIN,16));   
    JTextField Ctext2 = new JTextField(20);
    Ctext2.setBounds(560,90,150,25);
    panel.add(Ctext2);
    

    JLabel Clabel3=new JLabel("����");
    Clabel3.setBounds(520,30,100,25);
    Clabel3.setFont(new Font("",Font.PLAIN,16));
    

    panel.add(Clabel1);
    panel.add(Clabel2);
    panel.add(Clabel3);
 
    //��ѯ��ť
    JButton Cbt1=new JButton("��ѯ");
    Cbt1.setBounds(520, 250, 100, 35);
    Cbt1.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(Cbt1);
    JButton Cbt2=new JButton("����");
    Cbt2.setBounds(650, 250, 100, 35);
    Cbt2.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(Cbt2);
    //��panel��ӵ�����
    container.add(panel);


    //���ùرշ�ʽ
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //���ô�С
    frame.setSize(800,500);

    //����λ��
    frame.setLocation(100, 100);

    //���ÿɼ���
    frame.setVisible(true);
}
}
