/*
 * Author: Administrator
 * Created: 2016�� 2�� 16�� ȭ���� ���� 2:16:16
 * Modified: 2016�� 2�� 16�� ȭ���� ���� 2:16:16
 */

import java.io.*;
import java.net.*;

class SimpleSever
{
   
	public static void main( String [] args ) throws IOException
   {
      
      ServerSocket ss= null;
      Socket s= null; //����ȭ�� ���� ��Ȱ.
      
      String msg= "�ູ�� �Ϸ�Ǽſ�. â�� �����Դϴ�. 211.183.0.90 ";
      
      DataOutputStream dos; //writeUTF
      DataInputStream dis;   //ReadUTF
      
      try
      {
         ss= new ServerSocket(7788); //8080�� ���� ��Ʈ�Դϴ�.
         //port 0~65535 ��� ����. 1024 ���ϴ� ��� ��������.
         //1024�� �̹� �����.
         
         System.out.println("90 ���� ������.");
         
         
      }
      catch(IOException e)
      {
         System.out.println("���� : "+e);
      }
      
      while(true)
      {//Ŭ���̾�Ʈ ������ ���� ������ �޾Ƽ�,
         s=ss.accept(); //������ �����Ѵ�. ��ȭ����.
      dos = new DataOutputStream(s.getOutputStream());
      dos.writeUTF(msg); //Ŭ���̾�Ʈ ����.
      
      dis = new DataInputStream(s.getInputStream());
      System.out.println(dis.readUTF()); //Ŭ���̾�Ʈ�� ���� ���� �޼���.
      dos.close();
      dis.close();
      s.close();
      
      }
      
   }// end main

}
