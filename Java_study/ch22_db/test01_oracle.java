import java.sql.*;

class test01_oracle
{
	public static void main( String [] args ) 
   {
      //vari
      String DRIVER = "oracle.jdbc.driver.OracleDriver";
     // String URL="jdbc:oracle:thin:@211.183.0.90:1521:orcl"; //db�� �ִ� url
     // String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
      String URL="jdbc:oracle:thin:@localhost:1521:orcl";
      //											ip  		 port:DB��
      //    
      String USER = "scott";
      String PWD = "tiger";
      
      Connection con = null;
      Statement stmt = null;
      ResultSet rs= null;
      
      try
      {
       Class.forName(DRIVER);
         System.out.println("����̹� �ε� ����");
      }
      catch(Exception ex)
      {
        System.out.println("����̹� �ε� ����."+ex);
      }//������ ����.
      
      try
      {
       con= DriverManager.getConnection(URL, USER,PWD);
         //System.out.println("db ���� ����");
      
         //���� �۾�
         stmt = con.createStatement(); //Statement;
         
         
         //2.insert �۾�.
         //String sql = "insert into board values('aa','aa123','aa@naber.com','aa��','aa�����Դϴ�.')";
         //stmt.executeUpdate(sql);
         
         //3. update ����
         //String sql="update board set name='����' where name = 'aa'";
         //stmt.executeUpdate(sql);
         
         
         //4. delete
         String sql = "delete from board where name = '����'";
         stmt.executeUpdate(sql);
         
         //1.select �˻�.
         rs=stmt.executeQuery("select * from board");
         while(rs.next())
         {
            String name= rs.getString("name");
            String pwd= rs.getString("pwd");
            String email= rs.getString("email");
            String title= rs.getString("title");
            String content= rs.getString("content");
            
            System.out.println(name+"--"+pwd+"--"+email+"--"+title+"--"+content);
            
         }//while end
   
         
         
         
         //�������� �ݾ�����Ѵ�.
        //    rs.close();
        //    stmt.close();
         //   con.close();
         //finally ���� �־��� ������ �ּ� ó���Ѵ�.
     
      }catch(SQLException se){
         System.out.println("db ���� ����."+se);
      
      }finally{ //finally ���� ���� �߻��� ������� ó���ȴ�.
               //finally �� �տ� return���� �־ finally���� ó���ȴ�.
               //finally �� �տ� System.exit(0);�� �������� finally ���� ���� �ȵȴ�.
         try
         {
           if(rs != null){rs.close();}
           if(stmt != null){stmt.close();}
           if(con != null){con.close();}
         }catch(SQLException se2){}
       }  //final end
      
    
         
   }// end main

}//class end.
