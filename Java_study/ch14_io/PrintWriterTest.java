/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 9:28:51
 * Modified: 2016�� 2�� 4�� ����� ���� 9:28:51
 */


/*������
PrintWriter(OutputStream os);
PrintWriter(OutputStream os, boolean flushOnNewLine);

boolean flushOnNewLine : true/ false�� ����
���ڰ� ��� �ɶ�����, ��� ��Ʈ�� ������ ��� ���ΰ� ���θ� ����.
true : ��� ��Ʈ�� ������ ����.

PrintWriter(Writer w);
PrintWriter(Writer w , boolean flushOnNewLine);

java�� PrintWriter ��ü�� object�� �����
��� ���Ŀ� ���ؼ� print()�� println()�޼��带 wldnjsgksek.

��:
print("���ڿ� ");
print(100);
print(88.8);
print("A");
print(��ü);

 */

import java.io.*;

class PrintWriterTest
{
	public static void main( String [] args ) throws Exception
   {
      PrintWriter pp = new PrintWriter(System.out); //��ü ����.
      pp.println('A');
      pp.println(100);
      pp.println(77.8);
      pp.println(true);
      pp.println(new java.util.Date());
      
      pp.close();
      
      
      
   }// end main

}
