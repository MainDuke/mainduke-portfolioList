/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 3:29:53
 * Modified: 2016�� 2�� 3�� ������ ���� 3:29:53
 */

import java.io.*;

class FileR
{
	public static void main( String [] args )
   {
      FileReader fr = null;
      
      try
      {
         fr = new FileReader("a1.txt");
         
         int a;
         while((a=fr.read()) != -1) //���� ���� �ƴѵ��� �ݺ�.
         {
            System.out.println((char)a);
         }//while end
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
      finally
      {
         try
         {
            fr.close();
         }
         catch(Exception e2)
         {
            System.out.println(e2);
         }
      }
      
      
   }// end main
   
}
