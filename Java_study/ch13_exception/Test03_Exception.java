/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 12:06:46
 * Modified: 2016�� 2�� 3�� ������ ���� 12:06:46
 */

import java.io.*;

class Test03_Exception
{
	public static void main( String [] args )
   {
      try
      {
         Runtime r = Runtime.getRuntime(); //�������� ������ ��
         r.exec("c:\\Windows\\system32\\notepad.exe");
         r.exec("c:\\Windows\\system32\\calc.exe");
         //r.exec("exe ���"); ���� ���α׷� ����!.
      }
      catch(Exception e)
      {
         System.out.println("���� :" + e);
      }
      finally
      {
         
      }
   }// end main

}
