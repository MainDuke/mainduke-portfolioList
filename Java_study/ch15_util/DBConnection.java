/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오후 3:16:51
 * Modified: 2016년 2월 5일 금요일 오후 3:16:51
 */


//import java.util.Properties;
import java.util.*;
import java.io.*;
   
class DBConnection
{
	public DBConnection(){
      Properties pro=new Properties();
      
      try
      {
         pro.load(new FileInputStream("c:\\01_java\\ch15_util\\db.properties"));
      }
      catch( IOException e)
      {
         System.out.println(e);
      }
      
      String driver=pro.getProperty("driver");
      String url=pro.getProperty("url");
      String user=pro.getProperty("user");
      String pwd=pro.getProperty("pwd");
                
      System.out.println("driver:"+driver);
      System.out.println("url:"+url);
      System.out.println("user:"+user);
      System.out.println("pwd:"+pwd);
      
   }//cons

   public static void main( String [] args ) 
   {
      new DBConnection();
   }// end main

}//class end
