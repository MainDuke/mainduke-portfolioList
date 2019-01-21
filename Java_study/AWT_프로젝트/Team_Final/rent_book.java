import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.sql.*;


import java.awt.Toolkit;
import java.awt.Dimension;

class rent_book extends JFrame implements ActionListener
{
   MyBookPage MyBookPage = new MyBookPage();
   
   ;
   String loId;
   
   //db ���� vari
   String DRIVER ="com.mysql.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/e_team";
   String USER="root";
   String PWD= "12345";
   
   Connection con = null;
   Statement stmt= null;
   ResultSet rs= null;
   
   JPanel rent;
   //JLabel la_name, la_publisher, la_writer; 
   JButton bu_rent;
   
   //table
   Object data[][]=new Object[0][6]; //0~5��
   String cols[]={"no","å�̸�","����","���ǻ�","�뿩��","�ݳ���"};
   DefaultTableModel model= new DefaultTableModel(data, cols){
      
      //�� ���� ���ϰ� �ϸ�, table ��Ŭ�� ������.
      public boolean isCellEditable(int rows, int cols){
         return false;
      }
      
   };
   
   JTable table = new JTable(model);
   JScrollPane pane= new JScrollPane(table);
   
   //cons
   public rent_book(String id, String temp[]){
      
      loId =id;
      model.setRowCount(0);
      model.addRow(temp);
      
      
      System.out.println("�뿩�α��� : "+loId);
      rent = new JPanel();
      
      bu_rent = new JButton("�뿩");
      
      
      this.getContentPane().add(rent);
      
      rent.setLayout(null);
      rent.add(pane).setBounds(10,70,550,100);
      rent.add(bu_rent).setBounds(10,10,100,50);
           
      bu_rent.addActionListener(this);
      
      setBounds(0,0,580,260);
		setVisible(true);
      
      
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
         System.out.println("db ���� ����.");
         stmt = con.createStatement();
         
         
         
      }
      catch(Exception ex)
      {
         System.out.println("db ���� ���� : "+ex);
      }
      
   }//cons end
   
   //over
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource()==bu_rent)
      {
         try{
            int anser = JOptionPane.showConfirmDialog(null,"�뿩�Ͻðڽ��ϱ�?","�뿩",JOptionPane.YES_NO_OPTION);
            //â����, �޼���, ��ư.
            
            switch(anser)
            {
            case JOptionPane.YES_OPTION :
               {            
            save();
            dispose();
            break;
         }
            case JOptionPane.NO_OPTION:{
               
            dispose();   
            break;}
            }
         }catch(Exception e7){System.out.println("��Ʈ���� ���� : "+e7);}
      }
      
      
   }//over end
   
   //custom
   public void save(){
     
      System.out.println("save call");
      String imBookNo= (String)model.getValueAt(0,0);
      System.out.println("imBookNo : "+imBookNo);
      
      //loId
      String imMemNo = "";
      try{
         String sql1= "select memNo from member where id = '"+loId+"'";
         rs= stmt.executeQuery(sql1);
         
            while(rs.next())
            {
               imMemNo = rs.getString("memNo");
            }
            
      }catch(Exception ex8){}
      
      
      
      try{
         String sql2 = "update rent set memNo='"+imMemNo+"', rentdate= now(), rentable='���� ��' where no ='"+imBookNo+"'";
         stmt.executeUpdate(sql2); 
                  
      }catch(Exception ex8){}
      
   }
  
   /*
   public static void main( String [] args ) 
   {
   new rent_book();
   }// end main
    */
}//class
