/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 10:18:58
 * Modified: 2016�� 2�� 4�� ����� ���� 10:18:58
 */
//FileOutputStream �� DataOutputStream �� �̿��Ͽ�
//d1.txt �� ����.
// DataOutputSteam Ŭ�������� �ڷ������� �ִ�.
// writeByte()
//	writeChar()
// writeShort()
// writeInt()
// writeLong()
//	writeDouble()
// writeBoolean()
// writeChars()
// writeFloat();
// writeUTF() : �� �޼���� �ѱ� ���ڵ� ó�� ���� �ȴ�.
// �޼������ �ִ�.
// http://docs.oracle.com/javase/1.5.0/docs/api/
// DataOutputStream �޼��� ����.

import java.io.*;

class DataByteW
{
	public static void main( String [] args ) throws Exception
   {
      
      //FileOutputStream fos =new FileOutputStream("d1.txt"); //���� ��� ��Ʈ�� ��ü ����.
     // DataOutputStream dos = new DataOutputStream(fos); //������ ��� ��Ʈ�� ��ü ����.
      
      DataOutputStream dos = new DataOutputStream(new FileOutputStream("d1.txt"));
      
      
          dos.writeByte(100);
         dos.writeChar('A');
         dos.writeInt(12345);
         dos.writeDouble(55.5);
         dos.writeBoolean(true);
         dos.writeChars("Kim\n");
         dos.writeUTF("��浿\n");
         dos.close();
         
         
      
      
   }// end main

}
