/*
 * Author: Administrator
 * Created: 2016�� 3�� 10�� ����� ���� 9:02:18
 * Modified: 2016�� 3�� 10�� ����� ���� 9:02:18
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JInternalFrame;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.Dimension;

class A_MaterFrame extends JFrame implements ActionListener
{
   Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
   
   
//Vari====================================================
   JPanel loginPane;
   JLayeredPane jlpMaster;
   JDesktopPane desktop;
   
   
//Login Design �Դϴ�.====================================
   JPasswordField tf2;
   JButton b1,b2, b3;
   JTabbedPane tab;
   JLabel la1,la2,la3;
   JTextField tf1;
   JRadioButton ra1, ra2;
   ButtonGroup group;
   JPanel p1;
   DefaultTableModel model;
   JTable table;
   JScrollPane pane;

 
//NewJoin Design �Դϴ�.====================================
   int cherk = -1; //�ߺ� Ȯ�� ����
   JLabel la_name, la_id, la_pwd, la_email, la_sex, la_title;
   JTextField tf_name, tf_id, tf_pwd, tf_email;
   //Checkbox man, woman;
   //CheckboxGroup group;
   JButton bu_join, bu_cancel, bu_idCherk;
   JPanel p2;
   
   
//db ���� vari============================================
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
//========cons start========================================================================================================================================
//�̳� ������ ����. ���
//JInternalFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) 
JInternalFrame jf = new JInternalFrame("Login",false,false,false,false);
JInternalFrame jf2 = new JInternalFrame("NewJoin",false,false,false,false);
public A_MaterFrame(){
      super("�������� ���α׷�");
      
      //compnent design.
      //JDesktopPane �̳� �������� ������ �ִ� ���̴�.
      desktop = new JDesktopPane();
            
     
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//inner Frame---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Login Design   .add�̺�Ʈ(this)�� �̳� Ŭ�������� �׳� Ÿ���� �ϸ� �ȴ�.

p1= new JPanel();
la1 = new JLabel("ID",JLabel.RIGHT);
la2 = new JLabel("PWD",JLabel.RIGHT);
table = new JTable(model);
pane = new JScrollPane(table);
table.getTableHeader().setReorderingAllowed(false);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setBackground(Color.white);
tf1= new JTextField();
tf2= new JPasswordField();
b1= new JButton("�α���");
b2= new JButton("ȸ������");
b3= new JButton("����");
p1.setLayout(null);

la1.setBounds(0,40,100,30);
tf1.setBounds(120,40,150,30);

la2.setBounds(0,80,100,30);
tf2.setBounds(120,80,150,30);

b1.setBounds(285,40,75,70);
b2.setBounds(115,130,100,30);
b3.setBounds(225,130,100,30);

p1.add(la1);
p1.add(tf1);

p1.add(la2);
p1.add(tf2);

p1.add(b1);
p1.add(b2);
p1.add(b3);

jf.getContentPane().add(p1);

     
   jf.setBounds((res.width)/4,(res.height)/4,430,260);
   jf.setVisible(true);

/*
setVisible(true);
setBounds((res.width)/3,(res.height)/3,430, 260);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 */

//inner Frame---------------------------------------------------------------------------------------------------------------------------------------------------------------------

//ȸ�� ���� â ���� !!

   p2= new JPanel();
   la_title = new JLabel("ȸ�� ����");
   la_title.setFont(new Font("Dialog",Font.BOLD, 20));
   la_title.setForeground(Color.blue);
   
   la_name = new JLabel("�̸�", JLabel.RIGHT);
   la_id = new JLabel("���̵�",JLabel.RIGHT);
   la_pwd = new JLabel("PWD",JLabel.RIGHT);
   la_email = new JLabel("�̸���",JLabel.RIGHT);
   la_sex = new JLabel("����",JLabel.RIGHT);
   
   tf_name = new JTextField("");
   tf_id = new JTextField("");
   tf_pwd = new JTextField("");
   tf_email = new JTextField("");
   
   //group=new CheckboxGroup();  
   
   //man = new Checkbox("��",group,true);
   //woman = new Checkbox("��",group,false);
   
   bu_join = new JButton("ȸ�� ���");
   bu_cancel = new JButton("���");
   bu_idCherk = new JButton("�ߺ� Ȯ��");
   
   
   p2.setLayout(null); //��ġ�� ���α׷��Ӱ� �Ϸ���
   
   //Ÿ��Ʋ
   p2.add(la_title).setBounds(100,4,130,20);
   //��
   p2.add(la_name).setBounds(18,62,50,50);
   p2.add(la_id).setBounds(25,122,50,50);
   p2.add(la_pwd).setBounds(18,182,50,50);
   p2.add(la_email).setBounds(25,242,50,50);
   p2.add(la_sex).setBounds(18,302,50,50);
   
   //�ؽ�Ʈ �ʵ�.
   p2.add(tf_name).setBounds(82,72,140,25); 
   p2.add(tf_id).setBounds(82,132,140,25);
   p2.add(tf_pwd).setBounds(82,192,140,25);  
   p2.add(tf_email).setBounds(82,252,140,25);
   
   //���� ��ư.
   //p2.add(man).setBounds(105,310,30,30);
  // p2.add(woman).setBounds(130,310,30,30);
      
   //��ư ��ġ.
   p2.add(bu_join).setBounds(65,400,100,30);  
   p2.add(bu_cancel).setBounds(180,400,95,30);
   p2.add(bu_idCherk).setBounds(226,130,90,25);
   
   
   jf2.getContentPane().add(p2);
   jf2.setBounds((res.width)/4+430,(res.height)/4-150,340,500);
   //jf2.setVisible(true);
      
   //�̺�Ʈ ���
   bu_join.addActionListener(this);
   bu_cancel.addActionListener(this);
   bu_idCherk.addActionListener(this);
   
//inner Frame---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//DB set----Start-----------------------------------------------------------------------------------------------------------------------------------------------------------------
//driver catch
try{
   Class.forName(DRIVER);
}catch(ClassNotFoundException ce){ System.out.println("driver �ε� ���� : from login "+ce);}

try{//DB catch
   con= DriverManager.getConnection(URL,USER,PWD);
   stmt = con.createStatement();
}catch(Exception ex){
   System.out.println("db ���� ���� : "+ex);}

//DB set-----End----------------------------------------------------------------------------------------------------------------------------------------------------------------

      
      desktop.add(jf);
      desktop.add(jf2);
      this.add(desktop);
      //�̺�Ʈ ���  
      
      
      //�̺�Ʈ ���.
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
      
      
      addWindowListener(new MyWin());
      
      setType(javax.swing.JFrame.Type.UTILITY); //������ Ÿ���� �ٲ��ش�.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      //setBounds(res.width/10,res.height/13,(res.width)*8/10,res.height*8/10);
      setSize((res.width)*8/10,res.height*8/10);  
      
}//cons end---------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------

   
   //inner class 
   public class MyWin extends WindowAdapter{
      
      public void windowClosing(WindowEvent we){
         dispose();
      }//wc end
      
   }//inner end
   
//overriding==========Start================================================================================================================================
   public void actionPerformed(ActionEvent ae){
      
      
//Login Button Action======================================================================================================================================      
      if(ae.getSource()==b1)
      {
         // ID �� �Է� ������ ���â.-----------------------------------
         String loId=tf1.getText().trim();
         if(loId.length()<1)
         {
            JOptionPane.showMessageDialog(this, "ID�� �Է��Ͻÿ�.");
            tf1.requestFocus();
            return;
         }//if
         
         String loPwd=tf2.getText();
         
         if(loPwd.length() <1)
         {
            JOptionPane.showMessageDialog(this, "PWD�� �Է��Ͻÿ�.");
            tf2.requestFocus();
            return;
         }//if 
         
         try{
            
            String id = "";
            String pwd= "";
            String name = "";
            
            rs= stmt.executeQuery("select name,id,pwd from member where id ='"+loId+"' and pwd ='"+loPwd+"'");
            while(rs.next())
            {
               id = rs.getString("id");
               pwd= rs.getString("pwd");
               name = rs.getString("name");
            }
            if(id.equals(loId) && pwd.equals(loPwd))
            {
               if(loId.equals("admin"))	//�α��� ���̵� admin �� ���, main ������ �Ű������� �ٲ۴�.
               {
                  int a= 00; //��Ʈ��, �Ű�����.
                  JOptionPane.showMessageDialog(null,name+"�� �ȳ��ϼ���!\n ���� ���� ���α׷��� '������'�� �α��� �ϼ̽��ϴ�.");
                  Main main = new Main(loId, a);
                  dispose();
               }else{
                  
                  JOptionPane.showMessageDialog(null,name+"�� �ȳ��ϼ���!\n ���� ���� ���α׷��� �α��� �ϼ̽��ϴ�.");
                  
                  Main main = new Main(loId);
                  dispose();
               }//else end //���̵� �Ǻ�
            }else if(!id.equals(loId) || !pwd.equals(loPwd)){
               
               JOptionPane.showMessageDialog(this, "ID �Ǵ� PWD �� Ʋ�Ƚ��ϴ�.");
               return;
            }
         }catch(Exception ex97){}   
      }//if
      
      if(ae.getSource()==b2){
         //��ü ���� (ȸ������â.)
         //NewJoin newJoin = new NewJoin();
         
         //newJoin.setVisible(true);
         //newJoin.setBounds(500,100,340,500);
         jf2.setVisible(true);
     }//if b2 end
      if(ae.getSource()==b3){
         
         try{
            if(stmt != null){stmt.close();}
            if(con != null){con.close();}
         }catch(Exception ex3){}
         System.exit(0);
     
       
         }//if b3 end
//Login Button Action===================================================================================================================================  
      
}//==================================================================================================================================end ActionPerformed
//overriding==========End================================================================================================================================
   
   public static void main( String [] args ) 
   {
      new A_MaterFrame();
   }// end main
   
}//class end
