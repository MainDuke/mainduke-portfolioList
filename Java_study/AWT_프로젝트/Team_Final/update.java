
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;


class update extends JFrame //회원 정보 업데이트 클래스
{
      //vari
      JTextField tf_name, tf_id, tf_email, tf_sex, tf_MemNo;  
           
      JButton bu_update;
      
      JLabel laName,laId,laEmail,laSex,laContent, laJemok, laMemNo;
      
  	//db 관련 vari
  	String DRIVER ="com.mysql.jdbc.Driver";
  	String URL = "jdbc:mysql://localhost:3306/e_team";
  	String USER="root";
  	String PWD= "12345";
  	
  	Connection con = null;
  	Statement stmt= null;
  	ResultSet rs= null;
      //table
      Object data[][]=new Object[0][4]; //0~5행
      String cols[]={"bookNo","제목","대여날짜","대여기간"};
      DefaultTableModel model= new DefaultTableModel(data, cols){
         
         //셀 편집 못하게 하면, table 더클이 먹힌다.
         public boolean isCellEditable(int rows, int cols){
            return false;
         }
         
      };
      
      JTable table = new JTable(model);
      JScrollPane pane= new JScrollPane(table);
      
      
      
      //cons
      
      public update(){
         
    	  System.out.println("업데이트 생성자 호출");
    	  
         tf_MemNo = new JTextField();
         tf_MemNo.setEditable(false);
        
         tf_name=new JTextField();
        
         tf_id=new JTextField();
         tf_id.setEditable(false);
       
         tf_email=new JTextField();
        
         tf_sex=new JTextField();
         //tf_sex.setEditable(false);
                  
         
         bu_update= new JButton("수정");
         
         //getContentPane().setBackground(new Color(100, 200, 150));
         
         laJemok = new JLabel("회원 수정");
         laJemok.setFont(new Font("Dialog",Font.BOLD, 20));
         laJemok.setForeground(Color.green);
         
         laMemNo = new JLabel("회원 번호", JLabel.RIGHT);
         laMemNo.setForeground(Color.blue);
         
         laName=new JLabel("이름",JLabel.RIGHT);
         laName.setForeground(Color.blue);
         
         laId=new JLabel("ID",JLabel.RIGHT);
         laId.setForeground(Color.blue);
         
         laSex=new JLabel("성별",JLabel.RIGHT);
         laSex.setForeground(Color.blue);
         
         laEmail=new JLabel("Email",JLabel.RIGHT);
         laEmail.setForeground(Color.blue);
         
         laContent = new JLabel("글내용", JLabel.RIGHT);
         
         getContentPane().setLayout(null); //커스텀 디자인.
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
         
	//table 수정 막기
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
         
       //---db연결----------------------------------------------------  
 		try{
 			Class.forName("com.mysql.jdbc.Driver");
 			System.out.println("드라이버 로딩 성공");
 		}catch(ClassNotFoundException ex1){
 			System.out.println("드라이버 로딩 실패 :"+ex1);
 		}
 		try{
 			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
 			stmt=con.createStatement();//Statement 생성
 			// System.out.println("DB연결 성공");
 		}catch(SQLException ex){
 			System.out.println("SQL 예외 :"+ex);
 		}//catch
         
         String memNo = tf_MemNo.getText();
 		
         System.out.println("업데이트 memNo"+memNo);
 		
         try{
 		rs = stmt.executeQuery("select b.name, b.no, r.rentdate from book b, rent r where r.memNo="+memNo+" and r.no= b.no");

 		System.out.println("하하");
		rs.beforeFirst();
		while(rs.next())
		{
			
			String no = rs.getString("no");
			String name = rs.getString("name");
			String rentdate = rs.getString("rantdate");
			String str= "7일";
			
			//cols[]={"bookNo","제목","대여날짜","대여기간"};
			String temp[] = {no, name, rentdate, str};
			
			model.addRow(temp);
			
		}//while
		rs.close();
      	}catch(Exception e){}
 		
         
      }//cons end
      
      public void book_disp(){

          //---db연결----------------------------------------------------  
    		try{
    			Class.forName("com.mysql.jdbc.Driver");
    			System.out.println("드라이버 로딩 성공");
    		}catch(ClassNotFoundException ex1){
    			System.out.println("드라이버 로딩 실패 :"+ex1);
    		}
    		try{
    			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
    			stmt=con.createStatement();//Statement 생성
    			// System.out.println("DB연결 성공");
    		}catch(SQLException ex){
    			System.out.println("SQL 예외 :"+ex);
    		}//catch
            
            String memNo = tf_MemNo.getText();
    		
            System.out.println("업데이트 memNo "+memNo);
    		
            try{
    		rs = stmt.executeQuery("select b.name, b.no, r.rentdate from book b, rent r where r.memNo="+memNo+" and r.no= b.no");

    		System.out.println("하하");
   		rs.beforeFirst();
   		while(rs.next())
   		{
   			
   			String no = rs.getString("no");
   			String name = rs.getString("name");
   			String rentdate = rs.getString("rentdate");
   			String str= "7일";
   			
   			//cols[]={"bookNo","제목","대여날짜","대여기간"};
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

