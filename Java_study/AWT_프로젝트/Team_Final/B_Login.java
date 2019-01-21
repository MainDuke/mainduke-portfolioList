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
   
   //db 관련 vari
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
      
      b1= new JButton("로그인");
      b2= new JButton("회원가입");
      b3= new JButton("종료");
      
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
     // tab.addTab("로그인", null,p1,"로그인");
     // this.getContentPane().add("Center", tab);
      
      
      //이벤트 등록.
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
         // ID 안 입력 했을때 경고창.-----------------------------------
         String loId=tf1.getText().trim();
         if(loId.length()<1)
         {
            JOptionPane.showMessageDialog(this, "ID를 입력하시오.");
            tf1.requestFocus();
            return;
         }//if
         
         String loPwd=tf2.getText();
         
         if(loPwd.length() <1)
         {
            JOptionPane.showMessageDialog(this, "PWD을 입력하시오.");
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
               if(loId.equals("admin"))	//로그인 아이디가 admin 일 경우, main 생성자 매개변수를 바꾼다.
               {
                  int a= 00; //인트형, 매개변수.
                  JOptionPane.showMessageDialog(null,name+"님 안녕하세요!\n 도서 관리 프로그램에 '관리자'로 로그인 하셨습니다.");
                  Main main = new Main(loId, a);
                  dispose();
               }else{
                  
                  JOptionPane.showMessageDialog(null,name+"님 안녕하세요!\n 도서 관리 프로그램에 로그인 하셨습니다.");
                  
                  Main main = new Main(loId);
                  dispose();
               }//else end //아이디 판별
            }else if(!id.equals(loId) || !pwd.equals(loPwd)){
               
               JOptionPane.showMessageDialog(this, "ID 또는 PWD 가 틀렸습니다.");
               return;
            }
            
            
         }catch(Exception ex97){}
         
         
         
         
      }//if
      
      if(e.getSource()==b2){
         
         
         //객체 생성 (회원가입창.)
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