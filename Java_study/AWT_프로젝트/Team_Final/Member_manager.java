
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;

class Member_manager extends JFrame implements ActionListener
{
   //vari
   JButton b1,b2, b3,b4, bu_list; //bu_exit;
   JLabel la1,la2,la3;
   JTextField tf1;
   JRadioButton ra1, ra2;
   ButtonGroup group;
   JPanel p1;
   Choice ch;
   //회원 수정 객체
   update update = new update();
   
   
   //마우스 이벤트 쪽.
   int row=-1;
   String value="";
   
   //table
   Object data[][]=new Object[0][7]; //0~5행
   String cols[]={"memNo","이름","ID","Email","성별","대여여부","대여한 책(번호)"};
   DefaultTableModel model= new DefaultTableModel(data, cols){
      
      //셀 편집 못하게 하면, table 더클이 먹힌다.
      public boolean isCellEditable(int rows, int cols){
         return false;
      }
      
   };
   
   JTable table = new JTable(model);
   JScrollPane pane= new JScrollPane(table);
   
   
   
   //db 관련 vari
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   Statement stmt2= null;
   ResultSet rs2= null;
   
   Statement stmt3= null;
   ResultSet rs3= null;
   
   //객체 생성 (회원가입창.)
   //NewJoin newJoin = new NewJoin();
   
   //cons
   public Member_manager(){
      
      super("회원 관리");
      p1= new JPanel();
      
      
      ch = new Choice();
      ch.addItem("ID");
      ch.addItem("이름");
      
      
      la1 = new JLabel("회원 검색",JLabel.RIGHT);
      
      table = new JTable(model);
      pane = new JScrollPane(table);
      
      table.getTableHeader().setReorderingAllowed(false);
      table.getTableHeader().setResizingAllowed(true);
      table.getTableHeader().setBackground(Color.white);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table.getColumnModel().getColumn(0).setPreferredWidth(60);
      table.getColumnModel().getColumn(1).setPreferredWidth(60);
      table.getColumnModel().getColumn(2).setPreferredWidth(80);
      table.getColumnModel().getColumn(3).setPreferredWidth(120);
      table.getColumnModel().getColumn(4).setPreferredWidth(50);
      table.getColumnModel().getColumn(5).setPreferredWidth(80);
      table.getColumnModel().getColumn(6).setPreferredWidth(298);
      
      tf1= new JTextField();
      
      b1= new JButton("회원 추가");
      b2= new JButton("회원 삭제");
      b3= new JButton("회원 수정");
      b4= new JButton("검색");
      bu_list = new JButton("모든회원보기");
      //bu_exit = new JButton("종료");
      
      p1.setLayout(null);
      
      la1.setBounds(120,0,100,30);
      tf1.setBounds(250,30,300,30);
      ch.setBounds(120,30,100,30);
      
      b1.setBounds(250,500,100,30);
      b2.setBounds(360,500,100,30);
      b3.setBounds(470,500,100,30);
      bu_list.setBounds(90,500,150,30);
      //bu_exit.setBounds(580,500,100,30);
      
      b4.setBounds(560,30,100,30);
      
      pane.setBounds(10,80,750,400);
      
      p1.add(la1);
      p1.add(tf1);
      
      //p1.add(bu_exit);
      p1.add(bu_list);
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);
      p1.add(b4);
      p1.add(pane);
      p1.add(ch);
      
      //tab.addTab("회원 관리", null,p1,"회원 관리");
      // this.getContentPane().add("Center", tab);
      //getContentPane().add(p1);
      
      //이벤트 등록.
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      bu_list.addActionListener(this);
      //bu_exit.addActionListener(this);
      
      update.bu_update.addActionListener(this);
      
      //table 에 마우스 등록.
      table.addMouseListener(new MyMouse());
      
      
      //this.getContentPane().add(p1);
      //setVisible(true);
      //setSize(800, 600);
      
      //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //driver catch
      try
      {
         Class.forName(DRIVER);
         System.out.println("driver 로딩 성공. from login");
         
      }
      catch(ClassNotFoundException ce)
      {
         System.out.println("driver 로딩 실패 : from login "+ce);
      }
      
      try
      {
         con= DriverManager.getConnection(URL,USER,PWD);
         System.out.println("회원 관리 에서 db 연결 성공.");
         stmt = con.createStatement();
         stmt2 = con.createStatement();
         stmt3= con.createStatement();
         
      }
      catch(Exception ex)
      {
         System.out.println("db 연결 실패 : "+ex);
      }
      
      disp();
      
      //setBounds(0,0,800,400);
      //setVisible(true);
      
      
   }//cons end
   
   
   //inner class
   public class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table.getSelectedRow(); //행선택.
         
         value=(String)model.getValueAt(row, 0);
         
         System.out.println(value + " << value");
         
      }//mousePressed end
      
   }//MyMouse end
   
   String aa[];
   //custom	
   
   int count=0; //회원수 카운트
   int bookR=0;
   
   
   public void disp(){
      model.setRowCount(0); //table 데이터 모두 지운다.
      System.out.println("disp 콜 됬다");
      
      
      try
      {
         count=0;
         rs =stmt.executeQuery("select * from member");
         
         while(rs.next()){
            count++;
         }//총 회원수 구하기
         
         System.out.println("count : "+count);
         
         
         
         
         rs =stmt.executeQuery("select * from member");
         
         while(rs.next())
         {
            
            String memNo = rs.getString("memNo");
            String name = rs.getString("name");
            String id = rs.getString("id");
            String email = rs.getString("email");
            String sex = rs.getString("sex");
            String bname="";
            
            rs2 =stmt2.executeQuery("select * from rent where memNo="+memNo);
            
            bookR=0;
            if(!rs2.next()){
               
            }else{
               
               rs2.previous();
               while(rs2.next()){
                  bookR++;
               }//i번째 회원이 몇개 빌렸는지 찾아냄.
               
               
            }//엘스 끝
            
            rs3 =stmt3.executeQuery("select b.name,r.memNo, r.no from book b, rent r where r.memNo="+memNo+" and r.no= b.no");
            
            while(rs3.next()){
               bname +=rs3.getString("no")+" // ";
            }
            
            String temp[] = {memNo,name,id,email,sex, (bookR+""), bname};
            
            model.addRow(temp);
            
         }//while
         rs.close();
         rs2.close();
         rs3.close();
      }catch(Exception e)
      {}//catch end
      
   }//disp end
   
   public void numEdit(){
      
      System.out.println("numEdit 호출!");
      String imMemNo= (String)table.getValueAt(table.getSelectedRow(), 0);
      int intMemNo = Integer.parseInt(imMemNo);
      System.out.println("회원번호 반환 : "+imMemNo);
      
      count=0;
         
      
      try{
      rs =stmt.executeQuery("select * from member where memNo > "+imMemNo+";");
      while(rs.next()){
         count++;
      }//삭제된 회원수 보다 번호가 큰 모든 회원 수 구하기.
      
      System.out.println("카운트 반환 : "+count);
      
      for(int i=0;i<count;i++){
         
         String sql = "update member set memNo='"+(intMemNo+i)+"' where memNo='" + (intMemNo+1+i) + "'";
         stmt.executeUpdate(sql);
         
         String sql2 = "alter table hi"+(intMemNo+i+1)+" rename hi"+(intMemNo+i)+";";
         stmt2.executeUpdate(sql2);
         
         
         System.out.println("i = "+i);
         System.out.println("intMemNo+i = "+(intMemNo+i));
         System.out.println("intMemNo+1+i = "+(intMemNo+1+i));
         
         
      }
      
      System.out.println("num 끝났다.");
   }catch(Exception e55){}
   }//numEdit End
   
   //over---------------------------------------------------------------------------
   
   public void actionPerformed(ActionEvent e){
      
      
      if(e.getSource()==b1)
      {
         //객체 생성 (회원가입창.)
         NewJoin newJoin = new NewJoin();
         
         newJoin.setVisible(true);
         newJoin.setBounds(500,100,340,500);
         
         
      }
      
      if(e.getSource()==bu_list)
      {
         
         disp();
      }
      
      if(e.getSource()==b2) //삭제.
      {
         if(row < 0)
         {
            System.out.println("row call");
            JOptionPane.showMessageDialog(null,"삭제할 행을 선택하시오.");
            return;
         }
         
         try{
            int anser = JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
            //창제목, 메세지, 버튼.
            
            
            String str = (String)(table.getValueAt(table.getSelectedRow(), 5));
            if(str.equals("0")){
              
               
               switch(anser)
               {
               case JOptionPane.YES_OPTION :
                  if(value != null || !value.equals("") || value.length() >0)  
                  {
                     stmt.executeUpdate("delete from member where memNo='"+value+"'");
                     stmt.executeUpdate("drop table hi"+value+";");
                     numEdit();
                     
                  }//if
                  break;
               case JOptionPane.NO_OPTION:
                  break;
                  
               }
            }else{
                  JOptionPane.showMessageDialog(null, "대출중인 회원은 삭제 불가능 합니다");
                  return;
                  } 
            
         }catch(Exception e7){System.out.println("delete 예외 : "+e7);}
         disp();
         value="";
         row=-1;
         
         
      }
      
      if(e.getSource() == b3) //update
      {
         if(row < 0)
         {
            JOptionPane.showMessageDialog(null, "수정할 row를 선택하시오.");
            return;
         }//if
         
         //팝업창에 정보 뿌리기.
         String imMemNo = (String)model.getValueAt(row,0);
         String imName= (String)model.getValueAt(row,1);
         String imId= (String)model.getValueAt(row,2);
         String imEmail= (String)model.getValueAt(row,3);
         String imSex= (String)model.getValueAt(row,4);
         
         
         update.setBounds(200,200,400,400);
         update.setVisible(true);
         
         
         update.tf_MemNo.setText(imMemNo);
         update.tf_name.setText(imName);
         update.tf_id.setText(imId);
         update.tf_email.setText(imEmail);
         update.tf_sex.setText(imSex);
         
         
         row=-1;
         
         update.book_disp();
         
         
      }//b3 end
      
      if(e.getSource() == update.bu_update){
         
         System.out.println("업데이트 버튼 콜");
         
         //데이터 수정.
         
         String imMemNo=update.tf_MemNo.getText().trim();
         String imName=update.tf_name.getText().trim();
         String imId=update.tf_id.getText().trim();
         String imEmail=update.tf_email.getText().trim();
         String imSex=update.tf_sex.getText().trim();
         
         try{
            String sql = "update member set memNo='"+imMemNo+"', name ='"+imName+"', id='"+imId+"', email='"+imEmail+"', sex = '"+imSex+"' where id='" + imId + "'";
            stmt.executeUpdate(sql);
            
            update.dispose();
            disp();
            
         }catch(Exception ex8){}
         
         
      }//업데이트 버튼.
      
      if(e.getSource() == b4) //회원 검색.
      {
         if(ch.getSelectedItem() == "ID")
         {				
            JOptionPane.showMessageDialog(null, "ID 검색");
            
            String item = "id";
            mem_search(item);
            
         }else if( ch.getSelectedItem() == "이름")
         {
            JOptionPane.showMessageDialog(null, "이름 검색");
            String item = "name";
            mem_search(item);
            
         }
         
      }
      
      /*
      if(e.getSource()==bu_exit){
      
      try{
      if(stmt != null){stmt.close();}
      if(con != null){con.close();}
      System.out.println("DB연결 종료");
      }catch(Exception ex3){}
      System.exit(0);
      }//if b3 end
       */
      
   }//action end
   
   
   public void mem_search(String item){//사용자 정의 메서드 :회원 검색.
      
      
      try{
         
         
         
         
         //검색 엔진 논리 구조==================================================================
         String swhat = "where "+item+" like '%"+tf1.getText().trim()+"%'";
         rs=stmt.executeQuery("select * from member "+swhat);
         //검색 엔진 놀리 구조 ==================================================================
         
         while(rs.next()){
            
            String memNo = rs.getString("memNo");
            String name = rs.getString("name");
            String id=rs.getString("id");
            String email=rs.getString("email");
            String sex=rs.getString("sex");
            
            
            String temp[]={memNo,name,id,email,sex};
            
            model.setRowCount(0);
            model.addRow(temp);
            
         }//while
         rs.close();
      }catch(SQLException ex3){
         System.out.println("disp() 예외 :"+ex3);
         
         
      }
   }//search
   
   
   
   /*
   public static void main( String [] args ) 
   {
   new Member_manager();
   
   }// end main
   */
}//class end

