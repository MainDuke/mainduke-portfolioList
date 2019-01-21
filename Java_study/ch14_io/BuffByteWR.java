/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 10:03:31
 * Modified: 2016년 2월 4일 목요일 오전 10:03:31
 */


//FileInputStream 과 BufferedInputStream를 사용하여
//b2.txt 파일을 읽어 오기.

import java.io.*;

class BuffByteWR
{
	public static void main( String [] args ) throws Exception
   {
      //FileOutputStream fos = new FileOutputStream("b2.txt");
      //BufferedOutputStream bos = new BufferedOutputStream(fos);
      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b2.txt"));
      
      
      for(int i = 1; i<=10; i++)
      {
         bos.write(i);
      }
      bos.close();
      
      
      
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream("b2.txt"));
      
      int a;
      
      while((a=bis.read()) != -1)
      {
         System.out.println(a+" ");
      }
      
      bis.close();
      
      
      
   }// end main

}//class end
