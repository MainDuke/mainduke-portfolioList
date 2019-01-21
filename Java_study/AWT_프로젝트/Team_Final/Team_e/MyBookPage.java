
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.util.*;

public class MyBookPage extends JFrame implements ActionListener{
   
   //변수
   JPanel p1;
   JButton b_ban, b_yon, b_out, bu_mypage, bu_list;
   JLabel la_ing, la_ed;
   JScrollPane pane1, pane2;
   JTable table1, table2;
   
   
   String data1[][] = new String[3][5];
   String cols1[] = {"등록번호","책제목","저자","출판사","반납일"};
   DefaultTableModel model1 = new DefaultTableModel(data1,cols1);
   
   
   
   String data2[][] = new String[10][4];
   String cols2[] = {"등록번호","책제목","저자","출판사"};
   DefaultTableModel model2 = new DefaultTableModel(data2,cols2);
   
  
   
   //db 관련 vari
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   //전역변수
   int row=-1;
   String value="";
   MyInfo my;
   String loginId = "";
   
   
   public MyBookPage(){}
   
   public MyBookPage(String id){
      super("책정보");
      
      loginId = id;
      
      p1 = new JPanel();
      b_ban = new JButton("반납");
      b_yon = new JButton("연장");
      b_out = new JButton("로그아웃");
      bu_mypage = new JButton("내정보");
      bu_list = new JButton("새로고침");
      
      la_ing = new JLabel("내가 빌린 책");
      la_ed = new JLabel("내가 빌렸던 책");

      
      table1 = new JTable(model1);
      table2 = new JTable(model2);
      
      pane1 = new JScrollPane(table1);
      pane2 = new JScrollPane(table2);  
      
      table1.getTableHeader().setReorderingAllowed(false);//열 변경 못하게
      table1.getTableHeader().setResizingAllowed(false);//크기조절 못하게
      table2.getTableHeader().setReorderingAllowed(false);//열 변경 못하게
      table2.getTableHeader().setResizingAllowed(false);//크기조절 못하게

      p1.setLayout(null);
      
      p1.add(bu_list).setBounds(620,220,90,40);
      p1.add(bu_mypage).setBounds(580,10,80,40);
      p1.add(b_out).setBounds(670,10,90,40);
      p1.add(b_yon).setBounds(620,120,90,40);
      p1.add(b_ban).setBounds(620,170,90,40);
      p1.add(la_ing).setBounds(100,50,100,40);
      p1.add(la_ed).setBounds(100,350,100,40);

      
      p1.add(pane1).setBounds(30,100,500,200);
      p1.add(pane2).setBounds(30,400,580,200);

      
      getContentPane().add(p1);
      
      //setSize(800,800);
      //setVisible(true);
      
      //b_out.addActionListener(this);
      b_yon.addActionListener(this);
      b_ban.addActionListener(this);
      bu_mypage.addActionListener(this);
      bu_list.addActionListener(this);
      
      
      //table1 에 마우스 등록.
      table1.addMouseListener(new MyMouse());
      
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
      history();
      disp();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }//con end
   
   //inner class=====================================================
   class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table1.getSelectedRow(); //행선택.
         value=(String)model1.getValueAt(row, 0);//row, 고정값
         
         System.out.println("value : "+value);
         
      }//mousePressed end
   }//MyMouse end
   //==========================================================	
   
public void history(){
   model2.setRowCount(0); //table 데이터 모두 지운다.
   try
   {
      rs =stmt.executeQuery("select * from "+loginId+";");
         
      while(rs.next())
      {
         String Ino = rs.getString("no");
         String Iname = rs.getString("name");
         String Iwriter = rs.getString("writer");
         String Ipublisher = rs.getString("publisher");
         
         String temp[] = {Ino, Iname, Iwriter, Ipublisher};
         model2.addRow(temp);
      }//while
      rs.close();
   }catch(Exception e90){}
      
}//history
   
   public void disp(){
      model1.setRowCount(0); //table 데이터 모두 지운다.
      try
      {
         System.out.println("마이북 disp 호출 되었다.");
         String ImMemNo = "";
            
         
         System.out.println("loginId : "+loginId);
         rs =stmt.executeQuery("select memNo from member where id= '"+loginId+"'");
         while(rs.next())
         {
            ImMemNo = rs.getString("memNo");
            
         }//while
         
         System.out.println("ImMemNo : "+ImMemNo);
         
         rs =stmt.executeQuery("select b.*, if(ifnull(r.rentdate, 0)=0, '', DATE_FORMAT((r.rentdate)+7,'%Y-%m-%d')) as returnday from book b, rent r where r.memNo='"+ImMemNo+"' and r.no = b.no");
         
         while(rs.next())
         {
            
            String Ino = rs.getString("no");
            String Iname = rs.getString("name");
            String Iwriter = rs.getString("writer");
            String Ipublisher = rs.getString("publisher");
            String returnday= rs.getString("returnday");
        
            String temp[] = {Ino, Iname, Iwriter, Ipublisher, returnday};
            model1.addRow(temp);
          }//while
         rs.close();
      }catch(Exception e){}//catch end
      
   }//disp end=======================================================================================================disp end
   
   public void returnBook(String value){
      
      
      String rbookNo = value;
      
      try{
         String sql = "update rent set memNo='', rentdate= null, rentable='대여가능' where no ='"+rbookNo+"'";
         stmt.executeUpdate(sql);
         

      System.out.println("쿼리 전송.");   
         
      }catch(Exception ex8){}
      
      
   }//returnBook end -------------------------------------------------------------------------------------------------------
   
   public void saveH(String id, String no, String name, String writer, String publisher){
      try{
         String sql = "insert into "+id+" values('"+no+"', '"+name+"', '"+writer+"', '"+publisher+"');";
         stmt.executeUpdate(sql);
         
         
         System.out.println("대여 기록 저장");   
         
      }catch(Exception ex8){}
      
   }
   
  //=========================================================================================

  public void yonBook(String value){

    
    String rbookNo = value;

    try{
  
      String sql = "update rent set rentdate = (rentdate+7) where no = '"+rbookNo+"'";
      stmt.executeUpdate(sql);
            
      System.out.println("연장함."); 
      
      
    }catch(Exception ex79){}
   
  }
   //==========================================================================================
   //overriding
   public void actionPerformed(ActionEvent a){
      
     
      if(a.getSource()==b_yon){
         if(row<0){
            JOptionPane.showMessageDialog(null, "연장할 책을 선택해 주세요");
            return;}
         
         try{
            
            int an = JOptionPane.showConfirmDialog(null,"연장하시겠습니까?","연장",JOptionPane.YES_NO_OPTION);
            //창제목, 메세지, 버튼.
            
            switch(an){
            case JOptionPane.YES_OPTION :
               if(value != null || !value.equals("") || value.length() >0){
                  //수정 쿼리문
                                     
                    String imNo=(String)model1.getValueAt(row,0);
                    String imName = (String)model1.getValueAt(row,1);
                    String imWiter=(String)model1.getValueAt(row,2);
                    String imPublisher=(String)model1.getValueAt(row,3);
                    String imDate = (String)model1.getValueAt(row,4);
                    
                    
                    yonBook(value);
                    disp();
                    
                   System.out.println("연장성공!");
                  JOptionPane.showMessageDialog(null,"연장 되었습니다");
                     
                  
                  
               }//if
               break;
            case JOptionPane.NO_OPTION:
               break;
               
            }//switch
         }catch(Exception e99){System.out.println("연장(수정) 예외 : "+e99);}
         //disp();
         value="";
         row=-1;
         
      }else if(a.getSource()==b_ban){
         if(row<0){
            JOptionPane.showMessageDialog(null, "반납할 책을 선택해 주세요");
            return;}
         try{
            
            int an = JOptionPane.showConfirmDialog(null,"반납하시겠습니까?","반납",JOptionPane.YES_NO_OPTION);
            //창제목, 메세지, 버튼.
            
            switch(an){
            case JOptionPane.YES_OPTION :
               if(value != null || !value.equals("") || value.length() >0){
                  
                  String imNo=(String)model1.getValueAt(row,0);
                  String imName = (String)model1.getValueAt(row,1);
                  String imWiter=(String)model1.getValueAt(row,2);
                  String imPublisher=(String)model1.getValueAt(row,3);
                  
                  
                  saveH(loginId, imNo, imName, imWiter,imPublisher );
                  returnBook(value);
                  disp();
                  
                  System.out.println("반납성공!");
                  JOptionPane.showMessageDialog(null,"반납 되었습니다");
                  
                  
               }//if
               break;
            case JOptionPane.NO_OPTION:
               break;
               
            }//switch
         }catch(Exception e98){System.out.println("반납(수정) 예외 : "+e98);}
         //disp();
         value="";
         row=-1;
         
         
      }else if(a.getSource()==bu_mypage){
         
         my = new MyInfo(loginId);
         
      }else if(a.getSource() == bu_list)
      {
         model1.setRowCount(0);
         model2.setRowCount(0);
         disp();
         history();
              
       }//버튼 코딩 끝.
   }//actionPerformed() 
   
   
   /*
    //main
    public static void main( String [] args ){
    
    new MyBookPage();
    
    }// end main
    
    */
   
}//class
