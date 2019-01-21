/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 10:34:56
 * Modified: 2016년 2월 4일 목요일 오전 10:34:56
 */
//FileInputStream 과 DataInputStream 를 이용하여
//d1.txt 로 저장.
// DataOutputSteam 클래스에는 자료형들이 있다.
// readByte()
//	readChar()
// readShort()
// readInt()
// readLong()
//	readDouble()
// readBoolean()
// readChars()
// readFloat();
// readUTF() : 이 메서드는 한글 인코딩 처리 까지 된다.
// 메서드들이 있다.
// http://docs.oracle.com/javase/1.5.0/docs/api/
// DataInputStream 메서드 참조.
import java.io.*;


class DataByteR
{
	public static void main( String [] args ) throws Exception
   {
      DataInputStream dis = new DataInputStream(new FileInputStream("d1.txt"));
     
      
      
      System.out.println(dis.readByte());
      System.out.println(dis.readChar());
      System.out.println(dis.readInt());
      System.out.println(dis.readDouble());
      System.out.println(dis.readBoolean());
      System.out.println(dis.readLine());
      System.out.println(dis.readUTF());
              
      
      dis.close();
      
      /*
      int a;
      while((a=dis.read()) != -1)
      {
         System.out.println(a+" ");
         
      }
      dis.close();
      */
      
   }// end main

}
