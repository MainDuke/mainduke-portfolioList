/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 10:18:58
 * Modified: 2016년 2월 4일 목요일 오전 10:18:58
 */
//FileOutputStream 과 DataOutputStream 를 이용하여
//d1.txt 로 저장.
// DataOutputSteam 클래스에는 자료형들이 있다.
// writeByte()
//	writeChar()
// writeShort()
// writeInt()
// writeLong()
//	writeDouble()
// writeBoolean()
// writeChars()
// writeFloat();
// writeUTF() : 이 메서드는 한글 인코딩 처리 까지 된다.
// 메서드들이 있다.
// http://docs.oracle.com/javase/1.5.0/docs/api/
// DataOutputStream 메서드 참조.

import java.io.*;

class DataByteW
{
	public static void main( String [] args ) throws Exception
   {
      
      //FileOutputStream fos =new FileOutputStream("d1.txt"); //파일 출력 스트림 객체 생성.
     // DataOutputStream dos = new DataOutputStream(fos); //데이터 출력 스트림 객체 생성.
      
      DataOutputStream dos = new DataOutputStream(new FileOutputStream("d1.txt"));
      
      
          dos.writeByte(100);
         dos.writeChar('A');
         dos.writeInt(12345);
         dos.writeDouble(55.5);
         dos.writeBoolean(true);
         dos.writeChars("Kim\n");
         dos.writeUTF("김길동\n");
         dos.close();
         
         
      
      
   }// end main

}
