/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 10:34:56
 * Modified: 2016�� 2�� 4�� ����� ���� 10:34:56
 */
//FileInputStream �� DataInputStream �� �̿��Ͽ�
//d1.txt �� ����.
// DataOutputSteam Ŭ�������� �ڷ������� �ִ�.
// readByte()
//	readChar()
// readShort()
// readInt()
// readLong()
//	readDouble()
// readBoolean()
// readChars()
// readFloat();
// readUTF() : �� �޼���� �ѱ� ���ڵ� ó�� ���� �ȴ�.
// �޼������ �ִ�.
// http://docs.oracle.com/javase/1.5.0/docs/api/
// DataInputStream �޼��� ����.
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
