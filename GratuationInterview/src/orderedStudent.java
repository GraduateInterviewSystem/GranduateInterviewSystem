import java.awt.Container;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
import java.util.Vector;
//
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class orderedStudent {
    public static String url = "jdbc:mysql://localhost:3306/interview?useUnicode=true&characterencoding=GBK";
    public static String username = "manager";
    public static String password = "123456";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[]args){
        orderedStudent o=new orderedStudent();
    }
   public orderedStudent() {
        //�������ݿ�
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
        JFrame frame = new JFrame("�ܷ�����");

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
        JMenuItem rank=new JMenuItem("�ܷ�����");
        menu4.add(rank);
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



        final DefaultTableModel[] model = {new DefaultTableModel()};
        Vector data = new Vector(); // ����������������Ϊ�б�ֹһ�У������������������������ӷ���add(row)
        Vector names = new Vector();// ����������ʹ������add()�����������
        JTable table = new JTable(model[0]);

        //��ʾ���ݿ���Ϣ
        names.add("����");
        names.add("����");
        names.add("�Ա�");
        names.add("����רҵ");
        names.add("���֤��");
        names.add("��ϵ��ʽ");
        names.add("����ѧУ");
        names.add("רҵ�ɼ�");
        names.add("���γɼ�");
        names.add("Ӣ��ɼ�");
        names.add("���Գɼ�");
        names.add("�ֳܷɼ�");
        names.add("flag");
        String viewtable = "select *,S_majGrade+S_engGrade+S_polGrade+S_intGrade as totalScore from student order by S_majGrade+S_engGrade+S_polGrade+S_intGrade desc";
        try {
            rs = stmt.executeQuery(viewtable);
            while(rs.next()){
                String stu_id = rs.getString("S_stuID");
                String name = rs.getString("S_name");
                String polGrade = rs.getString("S_polGrade");
                String EngGrade = rs.getString("S_EngGrade");
                String majGrade = rs.getString("S_majGrade");
                String major = rs.getString("S_major");
                String intGrade = rs.getString("S_intGrade");
                String School = rs.getString("S_School");
                String ID = rs.getString("S_ID");
                String sex = rs.getString("S_sex");
                String phone = rs.getString("S_phone");
                String flag = rs.getString("S_flag");
                String totalGrade=rs.getString("totalScore");
                Vector row = new Vector(); // ������������ʹ������add()���Ԫ�أ�����������String��Object�ȣ��м��о�new����������
                row.add(stu_id);
                row.add(name);
                row.add(sex);
                row.add(major);
                row.add(ID);
                row.add(phone);
                row.add(School);
                row.add(majGrade);
                row.add(polGrade);
                row.add(EngGrade);
                row.add(intGrade);
                row.add(totalGrade);
                row.add(flag);

                data.add(row);
                model[0] = new DefaultTableModel(data, names);
                table.setModel(model[0]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model[0].setDataVector(data, names); // ����ģ���е�Ԫ�أ������Զ���ʾ���б���
        JScrollPane jsp = new JScrollPane(table); // ���б����ɹ�����Panel�������Panel��ӵ�������
        jsp.setSize(1000, 500);
        jsp.setLocation(10, 0);
        panel.add(jsp);
        table.setBounds(10,20,1000,100);
        table.setFont(new Font("����",Font.PLAIN,16));
        table.setRowHeight(30);
        table.getTableHeader().setBounds(10,0,1000,20);
        table.getTableHeader().setFont(new Font("����",Font.PLAIN,16));






       frame.add(panel);
        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        //���ô�С
        frame.setSize(1050,500);

        //����λ��
       frame.setLocation(400, 200);

        //���ÿɼ���
        frame.setVisible(true);
    }
}
