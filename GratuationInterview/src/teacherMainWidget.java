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

public class teacherMainWidget {
	public static void main(String[] args) {
        teacherMainWidget w1=new teacherMainWidget();
    }
public teacherMainWidget() {
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
    JLabel label4=new JLabel("���Է�����");
    label4.setBounds(25,200,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JLabel label5=new JLabel("��Ŀ��Ϣ��");
    label5.setBounds(320,20,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    //�ָ���
    JSplitPane split1=new JSplitPane();
    split1.setBounds(300, 0,1, 500);
    panel.add(split1);
    //���Է��������
    JTextField gradeText = new JTextField(20);
    gradeText.setBounds(100,200,100,30);
    panel.add(gradeText);
    //��ť
    JButton bt1=new JButton("�ύ");
    bt1.setBounds(100, 250, 100, 35);
    bt1.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("��һ��");
    bt2.setBounds(400, 250, 100, 35);
    bt2.setFont(new Font("����",Font.PLAIN,16));;
    panel.add(bt2);
    
    //�ñ����ʾ��Ŀ
    Object[] columnNames = {"��Ŀ���","���","�鿴��ϸ"};// ��������������
    // ��������������
    String[][] tableValues = {{"��ѧ","1",null},{"Ӣ��","20",null},{"����","32",null}};
    // ����ָ�����������ݵı��
    JTable table = new JTable(tableValues,columnNames);
    table.setBounds(320,70,250,50);
    table.getTableHeader().setBounds(320, 50, 250, 20);
    panel.add(table.getTableHeader());
    panel.add(table);

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
}
}
