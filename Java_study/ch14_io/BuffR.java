/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 3:45:09
 * Modified: 2016�� 2�� 3�� ������ ���� 3:45:09
 */


import java.io.*;


class BuffR
{
	public static void main( String [] args ) throws Exception
   {
      //FileReader fr = new FileReader("a2.txt");
     // BufferedReader br = new BufferedReader(fr);
      BufferedReader br = new BufferedReader(new FileReader("a2.txt"));
      
      
      String str="";
      
      while((str=br.readLine()) != null) // ���ϳ��� �ƴѵ��� �ݺ� ����.
      {
         System.out.println(str);
         
      }//while
      
      br.close();
      
   }// end main

}//class end.
