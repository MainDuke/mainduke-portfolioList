/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 9:41:13
 * Modified: 2016�� 2�� 4�� ����� ���� 9:41:13
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
