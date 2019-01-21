//JDBC 인터페이스는 java에서 제공(java.sql.*) 한다.

import java.sql.*; //DriverManager, Connection,
                   //	Statement, PreparedStatement,ResultSet

class Test02_Mysql
{
	public static void main( String [] args ) 
   {
      //변수.
      String DRIVER="com.mysql.jdbc.Driver"; //변수.
      String URL="jdbc:mysql://localhost:3306/mydb"; //DB가 있는 주소.
      String USER = "root";
      String PWD ="12345";
      
      Connection con = null; //변수.
      Statement stmt = null;
      ResultSet rs=null;
      ResultSet rs2=null;
       Statement stmt2 = null;
      
      try
      {
       Class.forName(DRIVER);
         System.out.println("드라이버 로딩 성공.");
         
      }
      catch(ClassNotFoundException ex)
      {
         System.out.println("드라이버 로딩 실패"+ex);
      }//catch
 
      try
      {
       con= DriverManager.getConnection(URL,USER,PWD);
         System.out.println("db 연결 성공.");
         
         //쿼리문 사용하려면.
         stmt=con.createStatement();
         stmt2=con.createStatement();
         
         //2.insert
        // String sql = "insert into board values('aa','aa123','aa@naber.com','aa글','aa내용입니다.')";
        // stmt.executeUpdate(sql);
         
         //3. update 형식
       //  String sql="update board set name='에이' where name = 'aa'";
       //  stmt.executeUpdate(sql);
         
         
         //4. delete
        // String sql = "delete from board where name = '에이'";
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
         System.out.println("DB연결 실패:"+se);
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
