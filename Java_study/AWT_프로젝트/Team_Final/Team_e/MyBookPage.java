
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.util.*;

public class MyBookPage extends JFrame implements ActionListener{
   
   //����
   JPanel p1;
   JButton b_ban, b_yon, b_out, bu_mypage, bu_list;
   JLabel la_ing, la_ed;
   JScrollPane pane1, pane2;
   JTable table1, table2;
   
   
   String data1[][] = new String[3][5];
   String cols1[] = {"��Ϲ�ȣ","å����","����","���ǻ�","�ݳ���"};
   DefaultTableModel model1 = new DefaultTableModel(data1,cols1);
   
   
   
   String data2[][] = new String[10][4];
   String cols2[] = {"��Ϲ�ȣ","å����","����","���ǻ�"};
   DefaultTableModel model2 = new DefaultTableModel(data2,cols2);
   
  
   
   //db ���� vari
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   //��������
   int row=-1;
   String value="";
   MyInfo my;
   String loginId = "";
   
   
   public MyBookPage(){}
   
   public MyBookPage(String id){
      super("å����");
      
      loginId = id;
      
      p1 = new JPanel();
      b_ban = new JButton("�ݳ�");
      b_yon = new JButton("����");
      b_out = new JButton("�α׾ƿ�");
      bu_mypage = new JButton("������");
      bu_list = new JButton("���ΰ�ħ");
      
      la_ing = new JLabel("���� ���� å");
      la_ed = new JLabel("���� ���ȴ� å");

      
      table1 = new JTable(model1);
      table2 = new JTable(model2);
      
      pane1 = new JScrollPane(table1);
      pane2 = new JScrollPane(table2);  
      
      table1.getTableHeader().setReorderingAllowed(false);//�� ���� ���ϰ�
      table1.getTableHeader().setResizingAllowed(false);//ũ������ ���ϰ�
      table2.getTableHeader().setReorderingAllowed(false);//�� ���� ���ϰ�
      table2.getTableHeader().setResizingAllowed(false);//ũ������ ���ϰ�

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
      
      
      //table1 �� ���콺 ���.
      table1.addMouseListener(new MyMouse());
      
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
      history();
      disp();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }//con end
   
   //inner class=====================================================
   class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table1.getSelectedRow(); //�༱��.
         value=(String)model1.getValueAt(row, 0);//row, ������
         
         System.out.println("value : "+value);
         
      }//mousePressed end
   }//MyMouse end
   //==========================================================	
   
public void history(){
   model2.setRowCount(0); //table ������ ��� �����.
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
      model1.setRowCount(0); //table ������ ��� �����.
      try
      {
         System.out.println("���̺� disp ȣ�� �Ǿ���.");
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
         String sql = "update rent set memNo='', rentdate= null, rentable='�뿩����' where no ='"+rbookNo+"'";
         stmt.executeUpdate(sql);
         

      System.out.println("���� ����.");   
         
      }catch(Exception ex8){}
      
      
   }//returnBook end -------------------------------------------------------------------------------------------------------
   
   public void saveH(String id, String no, String name, String writer, String publisher){
      try{
         String sql = "insert into "+id+" values('"+no+"', '"+name+"', '"+writer+"', '"+publisher+"');";
         stmt.executeUpdate(sql);
         
         
         System.out.println("�뿩 ��� ����");   
         
      }catch(Exception ex8){}
      
   }
   
  //=========================================================================================

  public void yonBook(String value){

    
    String rbookNo = value;

    try{
  
      String sql = "update rent set rentdate = (rentdate+7) where no = '"+rbookNo+"'";
      stmt.executeUpdate(sql);
            
      System.out.println("������."); 
      
      
    }catch(Exception ex79){}
   
  }
   //==========================================================================================
   //overriding
   public void actionPerformed(ActionEvent a){
      
     
      if(a.getSource()==b_yon){
         if(row<0){
            JOptionPane.showMessageDialog(null, "������ å�� ������ �ּ���");
            return;}
         
         try{
            
            int an = JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
            //â����, �޼���, ��ư.
            
            switch(an){
            case JOptionPane.YES_OPTION :
               if(value != null || !value.equals("") || value.length() >0){
                  //���� ������
                                     
                    String imNo=(String)model1.getValueAt(row,0);
                    String imName = (String)model1.getValueAt(row,1);
                    String imWiter=(String)model1.getValueAt(row,2);
                    String imPublisher=(String)model1.getValueAt(row,3);
                    String imDate = (String)model1.getValueAt(row,4);
                    
                    
                    yonBook(value);
                    disp();
                    
                   System.out.println("���强��!");
                  JOptionPane.showMessageDialog(null,"���� �Ǿ����ϴ�");
                     
                  
                  
               }//if
               break;
            case JOptionPane.NO_OPTION:
               break;
               
            }//switch
         }catch(Exception e99){System.out.println("����(����) ���� : "+e99);}
         //disp();
         value="";
         row=-1;
         
      }else if(a.getSource()==b_ban){
         if(row<0){
            JOptionPane.showMessageDialog(null, "�ݳ��� å�� ������ �ּ���");
            return;}
         try{
            
            int an = JOptionPane.showConfirmDialog(null,"�ݳ��Ͻðڽ��ϱ�?","�ݳ�",JOptionPane.YES_NO_OPTION);
            //â����, �޼���, ��ư.
            
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
                  
                  System.out.println("�ݳ�����!");
                  JOptionPane.showMessageDialog(null,"�ݳ� �Ǿ����ϴ�");
                  
                  
               }//if
               break;
            case JOptionPane.NO_OPTION:
               break;
               
            }//switch
         }catch(Exception e98){System.out.println("�ݳ�(����) ���� : "+e98);}
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
              
       }//��ư �ڵ� ��.
   }//actionPerformed() 
   
   
   /*
    //main
    public static void main( String [] args ){
    
    new MyBookPage();
    
    }// end main
    
    */
   
}//class
