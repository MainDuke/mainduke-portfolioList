/*
 * Author: Administrator
 * Created: 2016년 2월 16일 화요일 오후 2:30:56
 * Modified: 2016년 2월 16일 화요일 오후 2:30:56
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
      //args[1] : 하고 싶은말.
      
      String msg = " 클라이언트 211.183.0.90 창민 입니다." + args[1] ;
      
      try
      {
         s = new Socket(args[0], 7788); //ip, port 서버 접속.
         
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
