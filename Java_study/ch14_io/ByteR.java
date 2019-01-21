/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 9:44:49
 * Modified: 2016년 2월 4일 목요일 오전 9:44:49
 */



import java.io.*;

class ByteR
{
	public static void main( String [] args ) throws Exception
   {
      
      FileInputStream fis =new  FileInputStream("b1.txt"); //파일 읽기.
      
      
      int a;
      
      while((a=fis.read()) != -1)
      {
         System.out.println(a+" ");
      }//while end
      
      fis.close();
      
   }// end main

}
