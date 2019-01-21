/*
 * Author: Administrator
 * Created: 2016년 2월 16일 화요일 오후 2:16:16
 * Modified: 2016년 2월 16일 화요일 오후 2:16:16
 */

import java.io.*;
import java.net.*;

class SimpleSever
{
   
	public static void main( String [] args ) throws IOException
   {
      
      ServerSocket ss= null;
      Socket s= null; //ㅈㄴ화기 같은 역활.
      
      String msg= "행복한 하루되셔요. 창민 서버입니다. 211.183.0.90 ";
      
      DataOutputStream dos; //writeUTF
      DataInputStream dis;   //ReadUTF
      
      try
      {
         ss= new ServerSocket(7788); //8080은 로컬 포트입니다.
         //port 0~65535 사용 가능. 1024 이하는 사용 하지마라.
         //1024는 이미 사용중.
         
         System.out.println("90 서버 구동중.");
         
         
      }
      catch(IOException e)
      {
         System.out.println("예외 : "+e);
      }
      
      while(true)
      {//클라이언트 접속을 서버 소켓이 받아서,
         s=ss.accept(); //소켓을 연결한다. 대화가능.
      dos = new DataOutputStream(s.getOutputStream());
      dos.writeUTF(msg); //클라이언트 접속.
      
      dis = new DataInputStream(s.getInputStream());
      System.out.println(dis.readUTF()); //클라이언트로 부터 받은 메세지.
      dos.close();
      dis.close();
      s.close();
      
      }
      
   }// end main

}
