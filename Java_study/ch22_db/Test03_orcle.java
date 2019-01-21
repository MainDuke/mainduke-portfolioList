/*
오라클
test01 테이블 작성 합니다.

dos > sqlplus scott/tiger

create table test01(
name varchar2(12),
height number(7,2),
weight number(5,2),
age number(4),
sex char(4)
);

select * from tab;

insert into test01 values('송혜교',165.5, 45.5, 35,'여자' );
insert into test01 values('송중기',187.3, 77.8, 31,'남자' );
insert into test01 values('김사장',190.0, 86.5, 40,'남자' );
insert into test01 values('이사장',178.5, 56.5, 33,'여자' );


 */

import java.sql.*;

class Test03_orcle
{
	public static void main( String [] args ) 
   {     //vari
      String DRIVER = "oracle.jdbc.driver.OracleDriver";
      String URL ="jdbc:oracle:thin:@localhost:1521:orcl";
      String USER = "scott";
      String PWD = "tiger";
      
      Connection con = null;
      Statement stmt=null;
      ResultSet rs=null;
      
      //드라이버 로딩
      try
      {
         Class.forName(DRIVER);
         System.out.println("드라이버 로딩 성공");
      }
      catch(ClassNotFoundException cnfe)
      {
         System.out.println("드라이버 로딩 실패"+cnfe);
      }
     
      
      //db 연결
      try
      {
       con= DriverManager.getConnection(URL, USER,PWD);
         System.out.println("DB 연결 성공");
         
         //쿼리 작업.
         stmt = con.createStatement();
         
         
         //2.insert
         //String sql = "insert into test01 values('aa','185','88','29','남성')";
       //  stmt.executeUpdate(sql);
         
         //3. update 형식
          // String sql="update test01 set name='에이' where name = 'aa'";
         //  stmt.executeUpdate(sql);
         
         
         //4. delete
         //String sql = "delete from test01 where name = '에이'";
         //stmt.executeUpdate(sql);
         
         //1.select
         rs=stmt.executeQuery("select * from test01");
         
         while(rs.next())
         {
            String name = rs.getString("name");
            double height = rs.getDouble("height");
            double weight = rs.getDouble("weight");
            int age = rs.getInt("age");
            String sex = rs.getString("sex");
            
            System.out.printf("%s %7.2f %6.2f %5d %s\n",name, height, weight, age, sex);
            
         }//while end
      
      }
      catch(SQLException se)
      {
         System.out.println("DB 연결 실패: "+se);
      }
      finally{
         try{
         if(rs != null){rs.close();}
         if(stmt != null){stmt.close();}
         if(con !=null){con.close();}
      
      }catch(SQLException se2){}
      }
   }// end main

}//class end
