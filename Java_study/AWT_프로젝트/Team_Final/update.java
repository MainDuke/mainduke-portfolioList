
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;


class update extends JFrame //ȸ�� ���� ������Ʈ Ŭ����
{
      //vari
      JTextField tf_name, tf_id, tf_email, tf_sex, tf_MemNo;  
           
      JButton bu_update;
      
      JLabel laName,laId,laEmail,laSex,laContent, laJemok, laMemNo;
      
  	//db ���� vari
  	String DRIVER ="com.mysql.jdbc.Driver";
  	String URL = "jdbc:mysql://localhost:3306/e_team";
  	String USER="root";
  	String PWD= "12345";
  	
  	Connection con = null;
  	Statement stmt= null;
  	ResultSet rs= null;
      //table
      Object data[][]=new Object[0][4]; //0~5��
      String cols[]={"bookNo","����","�뿩��¥","�뿩�Ⱓ"};
      DefaultTableModel model= new DefaultTableModel(data, cols){
         
         //�� ���� ���ϰ� �ϸ�, table ��Ŭ�� ������.
         public boolean isCellEditable(int rows, int cols){
            return false;
         }
         
      };
      
      JTable table = new JTable(model);
      JScrollPane pane= new JScrollPane(table);
      
      
      
      //cons
      
      public update(){
         
    	  System.out.println("������Ʈ ������ ȣ��");
    	  
         tf_MemNo = new JTextField();
         tf_MemNo.setEditable(false);
        
         tf_name=new JTextField();
        
         tf_id=new JTextField();
         tf_id.setEditable(false);
       
         tf_email=new JTextField();
        
         tf_sex=new JTextField();
         //tf_sex.setEditable(false);
                  
         
         bu_update= new JButton("����");
         
         //getContentPane().setBackground(new Color(100, 200, 150));
         
         laJemok = new JLabel("ȸ�� ����");
         laJemok.setFont(new Font("Dialog",Font.BOLD, 20));
         laJemok.setForeground(Color.green);
         
         laMemNo = new JLabel("ȸ�� ��ȣ", JLabel.RIGHT);
         laMemNo.setForeground(Color.blue);
         
         laName=new JLabel("�̸�",JLabel.RIGHT);
         laName.setForeground(Color.blue);
         
         laId=new JLabel("ID",JLabel.RIGHT);
         laId.setForeground(Color.blue);
         
         laSex=new JLabel("����",JLabel.RIGHT);
         laSex.setForeground(Color.blue);
         
         laEmail=new JLabel("Email",JLabel.RIGHT);
         laEmail.setForeground(Color.blue);
         
         laContent = new JLabel("�۳���", JLabel.RIGHT);
         
         getContentPane().setLayout(null); //Ŀ���� ������.
         //
         
         laJemok.setBounds(120,0,100,30); //x,y,w,h
         
         laMemNo.setBounds(0,40,80,20);
         laName.setBounds(30,70,50,20);
         laId.setBounds(30,100,50,20);
         laEmail.setBounds(30,130,50,20);
         laSex.setBounds(30,160,50,20);
         laContent.setBounds(30,190,50,20);
         //
         tf_MemNo.setBounds(100,40,150,20);
         tf_name.setBounds(100,70,150,20);
         tf_id.setBounds(100,100,100,20);
         tf_email.setBounds(100,130,170,20);
         tf_sex.setBounds(100,160,155,20);
         pane.setBounds(100,190,250,180);
         
         
         //
         bu_update.setBounds(230,0,80,30);
         //
         
	//table ���� ����
	table.getTableHeader().setReorderingAllowed(false);
	table.getTableHeader().setResizingAllowed(false);
	table.getTableHeader().setBackground(Color.white);
			
         getContentPane().add(laMemNo);
         getContentPane().add(laJemok);
         getContentPane().add(laName);
         getContentPane().add(laId);
         getContentPane().add(laEmail);
         getContentPane().add(laSex);
         getContentPane().add(laContent);
         //
         
         getContentPane().add(tf_MemNo);
         getContentPane().add(tf_name);
         getContentPane().add(tf_id);
         getContentPane().add(tf_email);
         getContentPane().add(tf_sex);
         getContentPane().add(pane);
         //
         getContentPane().add(bu_update);
         //
        // setBounds(200,200,400,500);
        // setVisible(true);
         
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
 			// System.out.println("DB���� ����");
 		}catch(SQLException ex){
 			System.out.println("SQL ���� :"+ex);
 		}//catch
         
         String memNo = tf_MemNo.getText();
 		
         System.out.println("������Ʈ memNo"+memNo);
 		
         try{
 		rs = stmt.executeQuery("select b.name, b.no, r.rentdate from book b, rent r where r.memNo="+memNo+" and r.no= b.no");

 		System.out.println("����");
		rs.beforeFirst();
		while(rs.next())
		{
			
			String no = rs.getString("no");
			String name = rs.getString("name");
			String rentdate = rs.getString("rantdate");
			String str= "7��";
			
			//cols[]={"bookNo","����","�뿩��¥","�뿩�Ⱓ"};
			String temp[] = {no, name, rentdate, str};
			
			model.addRow(temp);
			
		}//while
		rs.close();
      	}catch(Exception e){}
 		
         
      }//cons end
      
      public void book_disp(){

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
    			// System.out.println("DB���� ����");
    		}catch(SQLException ex){
    			System.out.println("SQL ���� :"+ex);
    		}//catch
            
            String memNo = tf_MemNo.getText();
    		
            System.out.println("������Ʈ memNo "+memNo);
    		
            try{
    		rs = stmt.executeQuery("select b.name, b.no, r.rentdate from book b, rent r where r.memNo="+memNo+" and r.no= b.no");

    		System.out.println("����");
   		rs.beforeFirst();
   		while(rs.next())
   		{
   			
   			String no = rs.getString("no");
   			String name = rs.getString("name");
   			String rentdate = rs.getString("rentdate");
   			String str= "7��";
   			
   			//cols[]={"bookNo","����","�뿩��¥","�뿩�Ⱓ"};
   			String temp[] = {no, name, rentdate, str};
   			
   			model.addRow(temp);
   			
   		}//while
   		rs.close();
         	}catch(Exception e){}
    		
      }//
      
      
      //methud
     /* 
		public static void main( String [] args ) 
		{
		new update();
		}// end main
		 */
   }//class end

