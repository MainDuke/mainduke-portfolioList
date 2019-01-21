/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 9:41:13
 * Modified: 2016년 2월 4일 목요일 오전 9:41:13
 */

import java.io.*;

class ByteW
{
   public static void main( String [] args ) throws Exception	
   {
      FileOutputStream fos= new FileOutputStream("b1.txt");
      for(int i=1;i<=7;i++)
      {
         fos.write(i);
      }
      fos.close();
      
   }// end main

}//class end.
