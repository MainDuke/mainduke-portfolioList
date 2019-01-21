//JDBC �������̽��� java���� ����(java.sql.*) �Ѵ�.

import java.sql.*; //DriverManager, Connection,
                   //	Statement, PreparedStatement,ResultSet

class Test02_Mysql
{
	public static void main( String [] args ) 
   {
      //����.
      String DRIVER="com.mysql.jdbc.Driver"; //����.
      String URL="jdbc:mysql://localhost:3306/mydb"; //DB�� �ִ� �ּ�.
      String USER = "root";
      String PWD ="12345";
      
      Connection con = null; //����.
      Statement stmt = null;
      ResultSet rs=null;
      ResultSet rs2=null;
       Statement stmt2 = null;
      
      try
      {
       Class.forName(DRIVER);
         System.out.println("����̹� �ε� ����.");
         
      }
      catch(ClassNotFoundException ex)
      {
         System.out.println("����̹� �ε� ����"+ex);
      }//catch
 
      try
      {
       con= DriverManager.getConnection(URL,USER,PWD);
         System.out.println("db ���� ����.");
         
         //������ ����Ϸ���.
         stmt=con.createStatement();
         stmt2=con.createStatement();
         
         //2.insert
        // String sql = "insert into board values('aa','aa123','aa@naber.com','aa��','aa�����Դϴ�.')";
        // stmt.executeUpdate(sql);
         
         //3. update ����
       //  String sql="update board set name='����' where name = 'aa'";
       //  stmt.executeUpdate(sql);
         
         
         //4. delete
        // String sql = "delete from board where name = '����'";
       //  stmt.executeUpdate(sql);
         
         //1.select
         rs=stmt.executeQuery("select * from board");
         rs2= stmt2.executeQuery("select * from board");
         System.out.println("rs1");
         while(rs.next())
         {
            String name= rs.getString("name");
            String pwd= rs.getString("pwd");
            String email= rs.getString("email");
            String title= rs.getString("title");
            String content= rs.getString("content");
            
            System.out.println(name+"--"+pwd+"--"+email+"--"+title+"--"+content);
            
         }//while end
         System.out.println("rs2");
         while(rs2.next())
         {
            String name= rs2.getString("name");
            String pwd= rs2.getString("pwd");
            String email= rs2.getString("email");
            String title= rs2.getString("title");
            String content= rs2.getString("content");
            
            System.out.println(name+"--"+pwd+"--"+email+"--"+title+"--"+content);
            
         }//while end
      }catch(SQLException se)
      {
         System.out.println("DB���� ����:"+se);
      }//catch 2 end
      finally{
         try{
         if(rs !=null){rs.close();}
         if(stmt != null){stmt.close();}
         if(con != null){con.close();}
      }catch(SQLException se2){}
      
      }//finally end
      
   }// end main

}//class end
