import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login {
    
    public static void main(String[] args) {    
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
        frame.add(panel);
        /* 
         * �����û�����ķ����������������
         */
        placeComponents(panel);

        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
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
        
        JLabel classLabel = new JLabel("���:");
        classLabel.setFont(new Font("",Font.PLAIN,16));
        classLabel.setBounds(100,140,80,25);
        panel.add(classLabel);
        
        JComboBox comboBox=new JComboBox();
        comboBox.setBounds(140,140,100,20);
        comboBox.addItem("student");
        comboBox.addItem("teacher");
        panel.add(comboBox);

    }

}