import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

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
import javax.swing.table.DefaultTableModel;

public class teacherMainWidget {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=utf-8";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
	public static void main(String[] args) {
        //连接数据库
        try {
            System.out.println("教师可视端：");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException var2) {
            System.out.println("加载驱动失败!");
            var2.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("连接成功");
        } catch (SQLException var1) {
            System.out.println("连接失败");
        }
	    teacherMainWidget w1=new teacherMainWidget();
    }
public teacherMainWidget() {
    //初始化一个jframe
    JFrame frame = new JFrame("教师端");

    //初始化一个菜单栏
    JMenuBar menuBar = new JMenuBar();

    //初始化菜单
    JMenu menu1 = new JMenu("操作(O)");
    menu1.setMnemonic('O');  
    menu1.setFont(new Font("宋体",Font.PLAIN,16));
    JMenu menu2 = new JMenu("帮助(H)");
    menu2.setMnemonic('H'); 
    menu2.setFont(new Font("宋体",Font.PLAIN,16));
    JMenu menu3 = new JMenu("查询(Q)");
    menu3.setMnemonic('Q'); 
    menu3.setFont(new Font("宋体",Font.PLAIN,16));
    JMenu menu4 = new JMenu("统计(S)");
    menu4.setMnemonic('S'); 
    menu4.setFont(new Font("宋体",Font.PLAIN,16));
    JMenu menu5 = new JMenu("维护(M)");
    menu5.setMnemonic('M'); 
    menu5.setFont(new Font("宋体",Font.PLAIN,16));
    //初始化一个panel
    JPanel panel = new JPanel();

    //初始化一个容器
    Container container = frame.getContentPane();
    //把菜单添加到菜单栏
    menuBar.add(menu1);
    menuBar.add(menu2);
    menuBar.add(menu3);
    menuBar.add(menu4);
    menuBar.add(menu5);
    //设置菜单栏
    frame.setJMenuBar(menuBar);
    
    panel.setLayout(null);
    
    JLabel label1=new JLabel("考号：");
    label1.setBounds(50,30,100,25);
    label1.setFont(new Font("",Font.PLAIN,16));
    JLabel label2=new JLabel("姓名：");
    label2.setBounds(50,60,100,25);
    label2.setFont(new Font("",Font.PLAIN,16));
    JLabel label3=new JLabel("专业：");
    label3.setBounds(50,90,100,25);
    label3.setFont(new Font("",Font.PLAIN,16));
    JLabel label4=new JLabel("面试分数");
    label4.setBounds(25,200,100,25);
    label4.setFont(new Font("",Font.PLAIN,16));
    JLabel label5=new JLabel("题目信息");
    label5.setBounds(320,20,100,25);
    label5.setFont(new Font("",Font.PLAIN,16));
    //set传值给考号
    JLabel label6=new JLabel("20161414623");
    label6.setBounds(100,30,100,25);
    label6.setFont(new Font("",Font.PLAIN,16));
    //传值给姓名
    JLabel label7=new JLabel("dqy");
    label7.setBounds(100,60,100,25);
    label7.setFont(new Font("",Font.PLAIN,16));
    //传值给专业
    JLabel label8=new JLabel("cs");
    label8.setBounds(100,90,100,25);
    label8.setFont(new Font("",Font.PLAIN,16));
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    panel.add(label5);
    panel.add(label6);
    panel.add(label7);
    panel.add(label8);
    //分割线
    JSplitPane split1=new JSplitPane();
    split1.setBounds(300, 0,1, 500);
    panel.add(split1);
    //面试分数输入框
    JTextField gradeText = new JTextField(20);
    gradeText.setBounds(100,200,100,30);
    panel.add(gradeText);
    //按钮
    JButton bt1=new JButton("提交");
    bt1.setBounds(100, 250, 100, 35);
    bt1.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt1);
    JButton bt2=new JButton("下一题");
    bt2.setBounds(400, 250, 100, 35);
    bt2.setFont(new Font("宋体",Font.PLAIN,16));;
    panel.add(bt2);

    //用表格显示题目

    Object[] columnNames = {"题目类别","题号","查看详细"};// 定义表格列名数组
    final DefaultTableModel[] model = {new DefaultTableModel()};
    Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
    Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
    JTable table = new JTable(model[0]);
    //显示数据库信息
    names.add("题目类别");
    names.add("题号");
    names.add("查看详细");
    model[0].setDataVector(data, names);
    // 创建指定列名和数据的表格
    JScrollPane jsp = new JScrollPane(table); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中
    jsp.setSize(250, 90);
    jsp.setLocation(320, 70);
    panel.add(jsp);
    table.setBounds(320,70,250,50);
    table.getTableHeader().setBounds(320, 50, 250, 20);
    panel.add(table.getTableHeader());

    //把panel添加到容器
    container.add(panel);

    //设置关闭方式
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //设置大小
    frame.setSize(600,500);

    //设置位置
    frame.setLocation(100, 100);

    //设置可见性
    frame.setVisible(true);

    //显示题目信息
    ResultSet rs1;
    String select = "select * from queno where S_stuID='"+label6.getText()+"'";
    try {
        rs = stmt.executeQuery(select);
        if (rs.next()){
//            if(!data.isEmpty()) {
//                data.clear();
//                model[0] = new DefaultTableModel(data, names);
//                table.setModel(model[0]);
//            }
            String majNo = rs.getString("majNo");
            System.out.println(majNo);
            String polNo = rs.getString("polNo");
            System.out.println(polNo);
            String EngNo = rs.getString("EngNo");
            String selectMaj ="select M_content from majque where M_No = '"+majNo+"'";
            rs1 = stmt.executeQuery(selectMaj);
            if (rs1.next()){
                String maj_content = rs1.getString("M_content");
                System.out.println(maj_content);
                Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
                row.add("专业类");
                row.add(majNo);
                row.add(maj_content);
                data.add(row);
            }
            String selectEng ="select E_content from engque where E_No = '"+EngNo+"'";
            rs1 = stmt.executeQuery(selectEng);
            if (rs1.next()){
                String eng_content = rs1.getString("E_content");
                Vector row2 = new Vector();
                row2.add("英语类");
                row2.add(EngNo);
                row2.add(eng_content);
                data.add(row2);
            }
            String selectpol ="select P_content from polque where P_No = '"+polNo+"'";
            rs1 = stmt.executeQuery(selectpol);
            if (rs1.next()){
                String pol_content = rs1.getString("P_content");
                Vector row3 = new Vector();
                row3.add("政治类类");
                row3.add(polNo);
                row3.add(pol_content);
                data.add(row3);
            }
            model[0] = new DefaultTableModel(data, names);
            table.setModel(model[0]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //下一题




    //提交分数
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int grade = Integer.parseInt(gradeText.getText());
            if(!gradeText.getText().equals("")&&grade<100&&grade>=0){
//                String select="select S_intGrade from student where S_stuID = '"+考号label的值+"'";
//                rs = stmt.executeQuery(select);
//                  if(rs.next()){
//                      if(rs.getString("S_intGrade").equals("")){
//                          String add_grade = "update student set S_intGrade = '"+gradeText.getText()+"' where S_stuID = "+考号label的值+"'";
//                          String update_flag ="update student set S_flag = 1  where S_stuID = "+考号label的值+"'";
//                try {
//                    stmt.executeUpdate(add_grade);
//                    stmt.executeUpdate(update_flag);
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//                      }
//                  }
//                  else{
//                      System.out.println("已打分");
//                  }
//
            }
        }
    });
}
}

