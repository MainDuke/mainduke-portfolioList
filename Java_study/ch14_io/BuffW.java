/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 3:39:01
 * Modified: 2016�� 2�� 3�� ������ ���� 3:39:01
 */

import java.io.*;

class BuffW
{
	public static void main( String [] args ) throws Exception
   {
      //FileWriter fr = new FileWriter("a2.txt");
      //ByfferdWriter bw = new BufferdWriter(rf);
      
      BufferedWriter bw = new BufferedWriter(new FileWriter("a2.txt"));
      
      //���Ͽ� ���ڿ� ����
      
      for(int i=1;i<=5;i++)
      {
         bw.write("�ٹ�ȣ"+i+"\n"); 
        
      }
      bw.close();
      
      
   }// end main

}//class end !!!
