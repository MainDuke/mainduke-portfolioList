/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오후 2:51:08
 * Modified: 2016년 2월 3일 수요일 오후 2:51:08
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
            fw.write("줄번호: "+i+"\n");
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
