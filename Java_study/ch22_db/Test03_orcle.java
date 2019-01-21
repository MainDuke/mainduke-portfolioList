/*
����Ŭ
test01 ���̺� �ۼ� �մϴ�.

dos > sqlplus scott/tiger

create table test01(
name varchar2(12),
height number(7,2),
weight number(5,2),
age number(4),
sex char(4)
);

select * from tab;

insert into test01 values('������',165.5, 45.5, 35,'����' );
insert into test01 values('���߱�',187.3, 77.8, 31,'����' );
insert into test01 values('�����',190.0, 86.5, 40,'����' );
insert into test01 values('�̻���',178.5, 56.5, 33,'����' );


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
      
      //����̹� �ε�
      try
      {
         Class.forName(DRIVER);
         System.out.println("����̹� �ε� ����");
      }
      catch(ClassNotFoundException cnfe)
      {
         System.out.println("����̹� �ε� ����"+cnfe);
      }
     
      
      //db ����
      try
      {
       con= DriverManager.getConnection(URL, USER,PWD);
         System.out.println("DB ���� ����");
         
         //���� �۾�.
         stmt = con.createStatement();
         
         
         //2.insert
         //String sql = "insert into test01 values('aa','185','88','29','����')";
       //  stmt.executeUpdate(sql);
         
         //3. update ����
          // String sql="update test01 set name='����' where name = 'aa'";
         //  stmt.executeUpdate(sql);
         
         
         //4. delete
         //String sql = "delete from test01 where name = '����'";
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
         System.out.println("DB ���� ����: "+se);
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
