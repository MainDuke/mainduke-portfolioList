
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
   //ȸ�� ���� ��ü
   update update = new update();
   
   
   //���콺 �̺�Ʈ ��.
   int row=-1;
   String value="";
   
   //table
   Object data[][]=new Object[0][7]; //0~5��
   String cols[]={"memNo","�̸�","ID","Email","����","�뿩����","�뿩�� å(��ȣ)"};
   DefaultTableModel model= new DefaultTableModel(data, cols){
      
      //�� ���� ���ϰ� �ϸ�, table ��Ŭ�� ������.
      public boolean isCellEditable(int rows, int cols){
         return false;
      }
      
   };
   
   JTable table = new JTable(model);
   JScrollPane pane= new JScrollPane(table);
   
   
   
   //db ���� vari
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
   
   //��ü ���� (ȸ������â.)
   //NewJoin newJoin = new NewJoin();
   
   //cons
   public Member_manager(){
      
      super("ȸ�� ����");
      p1= new JPanel();
      
      
      ch = new Choice();
      ch.addItem("ID");
      ch.addItem("�̸�");
      
      
      la1 = new JLabel("ȸ�� �˻�",JLabel.RIGHT);
      
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
      
      b1= new JButton("ȸ�� �߰�");
      b2= new JButton("ȸ�� ����");
      b3= new JButton("ȸ�� ����");
      b4= new JButton("�˻�");
      bu_list = new JButton("���ȸ������");
      //bu_exit = new JButton("����");
      
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
      
      //tab.addTab("ȸ�� ����", null,p1,"ȸ�� ����");
      // this.getContentPane().add("Center", tab);
      //getContentPane().add(p1);
      
      //�̺�Ʈ ���.
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      bu_list.addActionListener(this);
      //bu_exit.addActionListener(this);
      
      update.bu_update.addActionListener(this);
      
      //table �� ���콺 ���.
      table.addMouseListener(new MyMouse());
      
      
      //this.getContentPane().add(p1);
      //setVisible(true);
      //setSize(800, 600);
      
      //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      //driver catch
      try
      {
         Class.forName(DRIVER);
         System.out.println("driver �ε� ����. from login");
         
      }
      catch(ClassNotFoundException ce)
      {
         System.out.println("driver �ε� ���� : from login "+ce);
      }
      
      try
      {
         con= DriverManager.getConnection(URL,USER,PWD);
         System.out.println("ȸ�� ���� ���� db ���� ����.");
         stmt = con.createStatement();
         stmt2 = con.createStatement();
         stmt3= con.createStatement();
         
      }
      catch(Exception ex)
      {
         System.out.println("db ���� ���� : "+ex);
      }
      
      disp();
      
      //setBounds(0,0,800,400);
      //setVisible(true);
      
      
   }//cons end
   
   
   //inner class
   public class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table.getSelectedRow(); //�༱��.
         
         value=(String)model.getValueAt(row, 0);
         
         System.out.println(value + " << value");
         
      }//mousePressed end
      
   }//MyMouse end
   
   String aa[];
   //custom	
   
   int count=0; //ȸ���� ī��Ʈ
   int bookR=0;
   
   
   public void disp(){
      model.setRowCount(0); //table ������ ��� �����.
      System.out.println("disp �� ���");
      
      
      try
      {
         count=0;
         rs =stmt.executeQuery("select * from member");
         
         while(rs.next()){
            count++;
         }//�� ȸ���� ���ϱ�
         
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
               }//i��° ȸ���� � ���ȴ��� ã�Ƴ�.
               
               
            }//���� ��
            
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
      
      System.out.println("numEdit ȣ��!");
      String imMemNo= (String)table.getValueAt(table.getSelectedRow(), 0);
      int intMemNo = Integer.parseInt(imMemNo);
      System.out.println("ȸ����ȣ ��ȯ : "+imMemNo);
      
      count=0;
         
      
      try{
      rs =stmt.executeQuery("select * from member where memNo > "+imMemNo+";");
      while(rs.next()){
         count++;
      }//������ ȸ���� ���� ��ȣ�� ū ��� ȸ�� �� ���ϱ�.
      
      System.out.println("ī��Ʈ ��ȯ : "+count);
      
      for(int i=0;i<count;i++){
         
         String sql = "update member set memNo='"+(intMemNo+i)+"' where memNo='" + (intMemNo+1+i) + "'";
         stmt.executeUpdate(sql);
         
         String sql2 = "alter table hi"+(intMemNo+i+1)+" rename hi"+(intMemNo+i)+";";
         stmt2.executeUpdate(sql2);
         
         
         System.out.println("i = "+i);
         System.out.println("intMemNo+i = "+(intMemNo+i));
         System.out.println("intMemNo+1+i = "+(intMemNo+1+i));
         
         
      }
      
      System.out.println("num ������.");
   }catch(Exception e55){}
   }//numEdit End
   
   //over---------------------------------------------------------------------------
   
   public void actionPerformed(ActionEvent e){
      
      
      if(e.getSource()==b1)
      {
         //��ü ���� (ȸ������â.)
         NewJoin newJoin = new NewJoin();
         
         newJoin.setVisible(true);
         newJoin.setBounds(500,100,340,500);
         
         
      }
      
      if(e.getSource()==bu_list)
      {
         
         disp();
      }
      
      if(e.getSource()==b2) //����.
      {
         if(row < 0)
         {
            System.out.println("row call");
            JOptionPane.showMessageDialog(null,"������ ���� �����Ͻÿ�.");
            return;
         }
         
         try{
            int anser = JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
            //â����, �޼���, ��ư.
            
            
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
                  JOptionPane.showMessageDialog(null, "�������� ȸ���� ���� �Ұ��� �մϴ�");
                  return;
                  } 
            
         }catch(Exception e7){System.out.println("delete ���� : "+e7);}
         disp();
         value="";
         row=-1;
         
         
      }
      
      if(e.getSource() == b3) //update
      {
         if(row < 0)
         {
            JOptionPane.showMessageDialog(null, "������ row�� �����Ͻÿ�.");
            return;
         }//if
         
         //�˾�â�� ���� �Ѹ���.
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
         
         System.out.println("������Ʈ ��ư ��");
         
         //������ ����.
         
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
         
         
      }//������Ʈ ��ư.
      
      if(e.getSource() == b4) //ȸ�� �˻�.
      {
         if(ch.getSelectedItem() == "ID")
         {				
            JOptionPane.showMessageDialog(null, "ID �˻�");
            
            String item = "id";
            mem_search(item);
            
         }else if( ch.getSelectedItem() == "�̸�")
         {
            JOptionPane.showMessageDialog(null, "�̸� �˻�");
            String item = "name";
            mem_search(item);
            
         }
         
      }
      
      /*
      if(e.getSource()==bu_exit){
      
      try{
      if(stmt != null){stmt.close();}
      if(con != null){con.close();}
      System.out.println("DB���� ����");
      }catch(Exception ex3){}
      System.exit(0);
      }//if b3 end
       */
      
   }//action end
   
   
   public void mem_search(String item){//����� ���� �޼��� :ȸ�� �˻�.
      
      
      try{
         
         
         
         
         //�˻� ���� �� ����==================================================================
         String swhat = "where "+item+" like '%"+tf1.getText().trim()+"%'";
         rs=stmt.executeQuery("select * from member "+swhat);
         //�˻� ���� � ���� ==================================================================
         
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
         System.out.println("disp() ���� :"+ex3);
         
         
      }
   }//search
   
   
   
   /*
   public static void main( String [] args ) 
   {
   new Member_manager();
   
   }// end main
   */
}//class end

