/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 2:51:08
 * Modified: 2016�� 2�� 3�� ������ ���� 2:51:08
 */

import java.io.*;

class FileW
{
   
	public static void main( String [] args ) 
   {
      
      
      FileWriter fw= null;
      
      try
      {   
         fw = new FileWriter("a1.txt");  
         
         for(int i=1;i<=3;i++)
         {
            fw.write("�ٹ�ȣ: "+i+"\n");
         }//for
      
      }
      catch(IOException ex)
      {
         System.out.println(ex);
      }
      finally
      {
         try
         {
            fw.close();
         }
         catch(IOException ex2)
         {
            
         }
      }
   }// end main

}//class end
