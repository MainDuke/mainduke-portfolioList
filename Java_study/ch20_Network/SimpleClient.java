/*
 * Author: Administrator
 * Created: 2016�� 2�� 16�� ȭ���� ���� 2:30:56
 * Modified: 2016�� 2�� 16�� ȭ���� ���� 2:30:56
 */

import java.io.*;
import java.net.*;

class SimpleClient
{
	public static void main( String [] args ) 
   {
      DataInputStream dis = null;
      DataOutputStream dos = null;
      
      Socket s=null;

      //args[0] : ip
      //args[1] : �ϰ� ������.
      
      String msg = " Ŭ���̾�Ʈ 211.183.0.90 â�� �Դϴ�." + args[1] ;
      
      try
      {
         s = new Socket(args[0], 7788); //ip, port ���� ����.
         
         dis = new DataInputStream(s.getInputStream());
         String str= dis.readUTF();
         System.out.println(str);
      
         dos = new DataOutputStream(s.getOutputStream());
         dos.writeUTF(msg);
         s.close();
         dis.close();
         dos.close();
         
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   
   
   }// end main

}//class  
