/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 9:44:49
 * Modified: 2016�� 2�� 4�� ����� ���� 9:44:49
 */



import java.io.*;

class ByteR
{
	public static void main( String [] args ) throws Exception
   {
      
      FileInputStream fis =new  FileInputStream("b1.txt"); //���� �б�.
      
      
      int a;
      
      while((a=fis.read()) != -1)
      {
         System.out.println(a+" ");
      }//while end
      
      fis.close();
      
   }// end main

}
