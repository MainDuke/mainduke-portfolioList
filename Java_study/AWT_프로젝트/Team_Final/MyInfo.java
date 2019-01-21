
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.sql.*;

class MyInfo extends JFrame implements ActionListener
{ 
      
   String myId = "";
   
   //����
      JLabel la_name, la_id, la_pwd, la_email, la_sex,la_title;
      JTextField tf_name, tf_id, tf_pwd, tf_email;
      Checkbox man, woman;
      CheckboxGroup group;
      JButton bu_edit, bu_cancel;
      
      
      
      //db ���� vari
      String DRIVER ="com.mysql.jdbc.Driver";
      String URL = "jdbc:mysql://localhost:3306/e_team";
      String USER="root";
      String PWD= "12345";
      
      Connection con = null;
      Statement stmt= null;
      ResultSet rs= null;
      
      
      //������
      public MyInfo(){}
     
      public MyInfo(String id){
       super("My Page");  
         
         myId= id;
        System.out.println("myid : "+ myId);
         
         la_name = new JLabel("�̸�", JLabel.RIGHT);
         la_id = new JLabel("���̵�",JLabel.RIGHT);
         la_pwd = new JLabel("��й�ȣ",JLabel.RIGHT);
         la_email = new JLabel("�̸���",JLabel.RIGHT);
         la_sex = new JLabel("����",JLabel.RIGHT);
         la_title = new JLabel("ȸ�� ����", JLabel.RIGHT);
         
         tf_name = new JTextField();
         tf_name.setEditable(false);  
         tf_id = new JTextField();
         tf_id.setEditable(false);  
         tf_pwd = new JTextField();
         tf_email = new JTextField();
         
         
         group=new CheckboxGroup();  
         
         man = new Checkbox("��",group,true);
         woman = new Checkbox("��",group,false);
        
         bu_edit = new JButton("����");
         bu_cancel = new JButton("���");
         
         String data1[][] = new String[0][1];
         String cols1[] = {"��ȭ��"};
         DefaultTableModel model = new DefaultTableModel(data1,cols1);
         JTable table = new JTable(model);
         JScrollPane roomInfoPane = new JScrollPane(table);
         
         
         getContentPane().setLayout(null); //��ġ�� ���α׷��Ӱ� �Ϸ���
         
         getContentPane().add(la_name).setBounds(30,30,70,50);
         getContentPane().add(la_id).setBounds(30,80,70,50);
         getContentPane().add(la_pwd).setBounds(30,130,70,50);
         getContentPane().add(la_email).setBounds(30,180,70,50);
         getContentPane().add(la_sex).setBounds(30,230,70,50);
         getContentPane().add(la_title).setBounds(150,0,70,50);
         
         
         getContentPane().add(tf_name).setBounds(110,40,250,30); 
         getContentPane().add(tf_id).setBounds(110,90,250,30);
         getContentPane().add(tf_pwd).setBounds(110,140,250,30);  
         getContentPane().add(tf_email).setBounds(110,190,250,30);
         
         getContentPane().add(man).setBounds(110,240,30,30);
         getContentPane().add(woman).setBounds(150,240,30,30);
         
         getContentPane().add(bu_edit).setBounds(140,300,60,30);  
         getContentPane().add(bu_cancel).setBounds(200,300,60,30);
         
         bu_edit.addActionListener(this);
         bu_cancel.addActionListener(this);
         
         setBounds(1300,300,450,450);
         setVisible(true);
         
         //---db����----------------------------------------------------  
         try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("����̹� �ε� ����");
         }catch(ClassNotFoundException ex1){
            System.out.println("����̹� �ε� ���� :"+ex1);
         }
         try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
            stmt=con.createStatement();//Statement ����
            
            System.out.println("DB���� ����");
         }catch(SQLException ex2){
            System.out.println("SQL ���� :"+ex2);
         }//catch
         
         
         
         //�⺻ ���� �ҷ�����.
         
         String mypage_name="";
         String mypage_id="";
         String mypage_email="";
         String mypage_pwd="";
         String mypage_sex="";
         
         try{
         rs= stmt.executeQuery("select * from member where id ='"+myId+"'");
         while(rs.next())
         {
            mypage_pwd = rs.getString("pwd");
            mypage_email = rs.getString("email");
            mypage_id = rs.getString("id");
            mypage_name = rs.getString("name");
            mypage_sex = rs.getString("sex");
            
         }
      }catch(Exception ex96){}
         tf_name.setText(mypage_name);
         tf_id.setText(mypage_id);
         tf_pwd.setText("");
         tf_email.setText(mypage_email);
         
         if(mypage_sex.equals("����"))
         {
            group.setSelectedCheckbox(man);
                     
         }else if(mypage_sex.equals("����"))
         {
            group.setSelectedCheckbox(woman);
            
         
         }
         
         
         //���� ��� , dispose �س���.
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         
      }
      //=============================================================================
      
      //overriding
      public void actionPerformed(ActionEvent e){
         if(e.getSource()==bu_edit){
            String spwd=tf_pwd.getText().trim();
            String semail=tf_email.getText().trim();
            
            
            if(spwd.equals("") || spwd.length()<0){
               JOptionPane.showMessageDialog(null, "PWD�� �Է��Ͻÿ�.");
               tf_pwd.requestFocus();
               return;
            }//if
            
            if(semail.equals("") || semail.length()<0){
               JOptionPane.showMessageDialog(null, "email�� �Է��Ͻÿ�.");
               tf_email.requestFocus();
               return;
            }//if
            
            
            
            //������ ����.
            
            String imId = tf_id.getText().trim();
            String imPwd=tf_pwd.getText().trim();
            String imEmail=tf_email.getText().trim();
            
            try{
               String sql = "update member set pwd='"+imPwd+"', email='"+imEmail+"' where id='" + imId + "'";
               stmt.executeUpdate(sql);
               
               dispose();
               JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
               return;
               
            }catch(Exception ex8){}//t-c
            
            
            
            
         }else if(e.getSource()==bu_cancel){
            try{
               if(stmt!=null){stmt.close();}
               if(con!=null){con.close();}
            }catch(Exception ex3){}
            
            dispose();
            
            
         }
      }//actionPerformed()
      //=================================================================
      
      
      
      
      //main
      /*
      public static void main( String [] args ){
      new MyInfo();
      
      }// end main
       */
   }//class

