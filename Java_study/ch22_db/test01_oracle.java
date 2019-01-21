import java.sql.*;

class test01_oracle
{
	public static void main( String [] args ) 
   {
      //vari
      String DRIVER = "oracle.jdbc.driver.OracleDriver";
     // String URL="jdbc:oracle:thin:@211.183.0.90:1521:orcl"; //db가 있는 url
     // String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
      String URL="jdbc:oracle:thin:@localhost:1521:orcl";
      //											ip  		 port:DB명
      //    
      String USER = "scott";
      String PWD = "tiger";
      
      Connection con = null;
      Statement stmt = null;
      ResultSet rs= null;
      
      try
      {
       Class.forName(DRIVER);
         System.out.println("드라이버 로딩 성공");
      }
      catch(Exception ex)
      {
        System.out.println("드라이버 로딩 실패."+ex);
      }//컴파일 실행.
      
      try
      {
       con= DriverManager.getConnection(URL, USER,PWD);
         //System.out.println("db 연결 성공");
      
         //쿼리 작업
         stmt = con.createStatement(); //Statement;
         
         
         //2.insert 작업.
         //String sql = "insert into board values('aa','aa123','aa@naber.com','aa글','aa내용입니다.')";
         //stmt.executeUpdate(sql);
         
         //3. update 형식
         //String sql="update board set name='에이' where name = 'aa'";
         //stmt.executeUpdate(sql);
         
         
         //4. delete
         String sql = "delete from board where name = '에이'";
         stmt.executeUpdate(sql);
         
         //1.select 검색.
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
   
         
         
         
         //역순으로 닫아줘야한다.
        //    rs.close();
        //    stmt.close();
         //   con.close();
         //finally 절에 넣었기 때문에 주석 처리한다.
     
      }catch(SQLException se){
         System.out.println("db 연결 실패."+se);
      
      }finally{ //finally 절은 예외 발생과 상관없이 처리된다.
               //finally 절 앞에 return문이 있어도 finally절은 처리된다.
               //finally 절 앞에 System.exit(0);문 있을때는 finally 절은 수행 안된다.
         try
         {
           if(rs != null){rs.close();}
           if(stmt != null){stmt.close();}
           if(con != null){con.close();}
         }catch(SQLException se2){}
       }  //final end
      
    
         
   }// end main

}//class end.
