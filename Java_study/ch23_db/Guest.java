/*
 * Author: Administrator
 * Created: 2016년 2월 25일 목요일 오전 11:07:09
 * Modified: 2016년 2월 25일 목요일 오전 11:07:09
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*; //DefaultTableModel 을 쓸 예정.


import java.sql.*; //db 연결.


class Guest extends JFrame implements ActionListener
{
	//vari
 
   JTextField tf_name, tf_id, tf_email, tf_title, tf_content;
   JTextArea ta_content;
   JButton bu_insert, bu_update, bu_list, bu_exit, bu_delete;
   JLabel laName,laId,laEmail,laTitle,laContent, laJemok;
   
   Object data[][]=new Object[0][5]; //0~5행
   String cols[]={"이름","ID","Email","Title","글내용"};
   DefaultTableModel model= new DefaultTableModel(data, cols){
      
      //셀 편집 못하게 하면, table 더클이 먹힌다.
      public boolean isCellEditable(int rows, int cols){
         return false;
      }
      
   };

   JTable table = new JTable(model);
   JScrollPane pane= new JScrollPane(table);
  
   
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/mydb";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   //객체 생성.
   UpdateTest updateTest = new UpdateTest();
      
   
   //cons
   public Guest(){
      
        
      
      laJemok = new JLabel("GuestBook");
      laJemok.setFont(new Font("Dialog",Font.BOLD, 20));
      laJemok.setForeground(Color.blue);
      
      laName=new JLabel("이름",JLabel.RIGHT);
      laName.setForeground(Color.blue);

      laId=new JLabel("ID",JLabel.RIGHT);
      laId.setForeground(Color.blue);
   
      laTitle=new JLabel("Title",JLabel.RIGHT);
      laTitle.setForeground(Color.blue);
      
      laEmail=new JLabel("Email",JLabel.RIGHT);
      laEmail.setForeground(Color.blue);

      laContent = new JLabel("글내용", JLabel.RIGHT);
      
      tf_name=new JTextField();
      tf_id=new JTextField();
      tf_email=new JTextField();
      tf_title=new JTextField();
      ta_content = new JTextArea();
            
      bu_insert= new JButton("Insert");
      bu_update= new JButton("Update");
      bu_delete= new JButton("Delete");
      bu_list= new JButton("List");
      bu_exit= new JButton("Exit");
      //
      getContentPane().setLayout(null); //커스텀 디자인.
      //
      laJemok.setBounds(150,30,250,30); //x,y,w,h
     
      laName.setBounds(80,70,50,20);
      laId.setBounds(80,100,50,20);
      laEmail.setBounds(80,130,50,20);
      laTitle.setBounds(80,160,50,20);
      laContent.setBounds(80,190,50,20);
      //
      tf_name.setBounds(150,70,150,20);
      tf_id.setBounds(150,100,100,20);
      tf_email.setBounds(150,130,170,20);
      tf_title.setBounds(150,160,155,20);
      ta_content.setBounds(150,190,170,80);
      ta_content.setBackground(Color.green);
      //
      bu_insert.setBounds(80,300,80,30);
      bu_update.setBounds(170,300,80,30);
      bu_delete.setBounds(260,300,80,30);
      bu_list.setBounds(350,300,80,30);
      bu_exit.setBounds(440,300,80,30);
      //
      pane.setBounds(10,350,570,200);
      //
      
      getContentPane().add(laJemok);
      getContentPane().add(laName);
      getContentPane().add(laId);
      getContentPane().add(laEmail);
      getContentPane().add(laTitle);
      getContentPane().add(laContent);
      //
      getContentPane().add(tf_name);
      getContentPane().add(tf_id);
      getContentPane().add(tf_email);
      getContentPane().add(tf_title);
      getContentPane().add(ta_content);
      //
      getContentPane().add(bu_insert);
      getContentPane().add(bu_update);
      getContentPane().add(bu_delete);
      getContentPane().add(bu_list);
      getContentPane().add(bu_exit);
      //
      getContentPane().add(pane); //table 
      
      //event 
      bu_insert.addActionListener(this);
      bu_delete.addActionListener(this);
      bu_update.addActionListener(this);
      bu_list.addActionListener(this);
      bu_exit.addActionListener(this);
      updateTest.bu_update.addActionListener(this);
      
      //table 에 마우스 등록.
      table.addMouseListener(new MyMouse());
      
      
      //Frame 설정.
      setVisible(true);
      setBounds(200,200,600,600);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //driver catch.
      
      try
      {
         Class.forName(DRIVER);
         System.out.println("driver 로딩 성공.");
      }
      catch(ClassNotFoundException ce)
      {
         System.out.println("driver 로딩 실패 : "+ce);
      }
      
      //db catch
      try
      {
         con= DriverManager.getConnection(URL,USER,PWD);
         System.out.println("db 연결 성공.");
         stmt = con.createStatement();
         
         
         
      }
      catch(Exception ex)
      {
         System.out.println("db 연결 실패 : "+ex);
      }
      
      disp();
   }//cons end
   
   //추가 전역 변수.
   int row=-1;
   String value = "";
   
   //inner class
   public class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table.getSelectedRow(); //행선택.
         
         value=(String)model.getValueAt(row, 1);

         System.out.println("value : "+value);
         System.out.println("row : "+row);
         
      }//mousePressed end
      
   }//MyMouse end

   
   //over
   public void actionPerformed(ActionEvent ae){
      
      if(ae.getSource() == bu_exit)
      {
       try{
         if(stmt != null){stmt.close();}
         if(con != null){con.close();}
       }catch(Exception ex3){}
      System.exit(0);
   }else if(ae.getSource() == bu_insert){
         //insert
         String name = tf_name.getText().trim();
         String id = tf_id.getText().trim();
         String email = tf_email.getText().trim();
         String title = tf_title.getText().trim();
         String content = ta_content.getText().trim();
         
         if(name.equals("") || name.length()<0)
         {
            JOptionPane.showMessageDialog(null, "name을 입력하시오.");
           tf_name.requestFocus();
            return;
         }//if1
         if(id.equals("") || id.length()<0)
         {
            JOptionPane.showMessageDialog(null, "id을 입력하시오.");
           tf_id.requestFocus();
            return;
         }//if2
         
         if(email.equals("") || email.length()<0)
         {
            JOptionPane.showMessageDialog(null, "email을 입력하시오.");
            tf_email.requestFocus();
            return;
         }//if3
         if(title.equals("") || title.length()<0)
         {
            JOptionPane.showMessageDialog(null, "title을 입력하시오.");
            tf_title.requestFocus();
            return;
         }//if4
         if(content.equals("") || content.length()<0)
         {
            JOptionPane.showMessageDialog(null, "content을 입력하시오.");
            ta_content.requestFocus();
            return;
         }//if5
         
         
         try
         {
          String sql = "insert into guest values('"+name+"','"+id+"','"+email+"','"+title+"','"+content+"')";  
         stmt.executeUpdate(sql);
         disp();
         }catch(Exception ex6){System.out.println("insert 예외 : "+ex6);}
         
         tf_name.setText("");
         tf_id.setText("");
         tf_email.setText("");
         tf_title.setText("");
         ta_content.setText("");
         
         tf_name.requestFocus();
         
         
      }else if(ae.getSource() == bu_update){
         //update 창에 데이터 뿌리기.
         if(row < 0)
         {
            JOptionPane.showMessageDialog(null, "수정할 row를 선택하시오.");
               return;
         }//if
         
         updateTest.setVisible(true);
         updateTest.setBounds(800,200,450,400);
         
         
         String imName= (String)model.getValueAt(row,0);
         String imId= (String)model.getValueAt(row,1);
         String imEmail= (String)model.getValueAt(row,2);
         String imTitle= (String)model.getValueAt(row,3);
         String imContent= (String)model.getValueAt(row,4);
         
         updateTest.tf_name.setText(imName);
         updateTest.tf_id.setText(imId);
         updateTest.tf_email.setText(imEmail);
         updateTest.tf_title.setText(imTitle);
         updateTest.ta_content.setText(imContent);
         
         
         row=-1;
         
         
      }else if(ae.getSource() == updateTest.bu_update){
        
         System.out.println("Test");
         
         //데이터 수정.
         String imName=updateTest.tf_name.getText().trim();
         String imId=updateTest.tf_id.getText().trim();
         String imEmail=updateTest.tf_email.getText().trim();
         String imTitle=updateTest.tf_title.getText().trim();
         String imContent=updateTest.ta_content.getText().trim();
         
         try{
         String sql = "update guest set name ='"+imName+"', id='"+imId+"', email='"+imEmail+"',Title = '"+imTitle+"', content='"+imContent+"' where id='" + imId + "'";
         stmt.executeUpdate(sql);
         
         updateTest.setVisible(false);
         
         disp();
         row= -1;
         value = "";
      
      }catch(Exception ex8){}
      }else if(ae.getSource() == bu_delete){
        if(row < 0)
         {
            System.out.println("row call");
            JOptionPane.showMessageDialog(null,"삭제할 행을 선택하시오.");
            return;
         }
         
       try{
         int anser = JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
         //창제목, 메세지, 버튼.
         
         switch(anser)
         {
         case JOptionPane.YES_OPTION :
               if(value != null || !value.equals("") || value.length() >0)  
               {
                  stmt.executeUpdate("delete from guest where id='"+value+"'");
               }//if
             break;
         case JOptionPane.NO_OPTION:
            break;
         }
      }catch(Exception e7){System.out.println("delete 예외 : "+e7);}
         disp();
         value="";
         row=-1;
         
         
      }else if(ae.getSource() == bu_list){
         System.out.println("list call");
         disp();
      }//else if end
      
   }//action end
   
   //custom
   public void disp(){
      model.setRowCount(0); //table 데이터 모두 지운다.
      try
      {
       rs =stmt.executeQuery("select * from guest");
         while(rs.next())
         {
            String name = rs.getString("name");
            String id = rs.getString("id");
            String title = rs.getString("title");
            String email = rs.getString("email");
            String content = rs.getString("content");
            
            String temp[] = {name,id,email,title,content};
            model.addRow(temp);
            
         }//while
           rs.close();
      }catch(Exception e)
      {}//catch end
    
   }//disp end
   
   //methud
   public static void main( String [] args ) 
   {
      new Guest();
   }// end main
   

}//class end
