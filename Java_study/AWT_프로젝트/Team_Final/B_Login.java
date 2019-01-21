import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class B_Login extends JFrame implements ActionListener{
   
   //vari
   Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
   
   JPasswordField tf2;
   JButton b1,b2, b3;
   JTabbedPane tab;
   JLabel la1,la2,la3;
   JTextField tf1;
   JRadioButton ra1, ra2;
   ButtonGroup group;
   JPanel p1,p2;
   DefaultTableModel model;
   JTable table;
   JScrollPane pane;
   
   //db ���� vari
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   
   //cons
   public B_Login(){
      super("Login");
      //tab = new JTabbedPane();
      
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
      
      getContentPane().add(p1);
     // tab.addTab("�α���", null,p1,"�α���");
     // this.getContentPane().add("Center", tab);
      
      
      //�̺�Ʈ ���.
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
            
      setVisible(true);
      setBounds((res.width)/3,(res.height)/3,430, 260);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }//cons end
   
   //custom	
   
   //over---------------------------------------------------------------------------
   
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource()==b1)
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
      
      if(e.getSource()==b2){
         
         
         //��ü ���� (ȸ������â.)
         NewJoin newJoin = new NewJoin();
         
         newJoin.setVisible(true);
         newJoin.setBounds(500,100,340,500);
         
      }//if b2 end
      
      if(e.getSource()==b3){
         
         try{
            if(stmt != null){stmt.close();}
            if(con != null){con.close();}
         }catch(Exception ex3){}
         System.exit(0);
      }//if b3 end
      
      
   }//action end
   
   public static void main( String [] args ) 
   {
      new B_Login();
   }// end main
   
}//class end