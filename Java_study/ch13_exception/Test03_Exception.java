/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오후 12:06:46
 * Modified: 2016년 2월 3일 수요일 오후 12:06:46
 */

import java.io.*;

class Test03_Exception
{
	public static void main( String [] args )
   {
      try
      {
         Runtime r = Runtime.getRuntime(); //실행파일 정보를 얻어서
         r.exec("c:\\Windows\\system32\\notepad.exe");
         r.exec("c:\\Windows\\system32\\calc.exe");
         //r.exec("exe 경로"); 응용 프로그램 실행!.
      }
      catch(Exception e)
      {
         System.out.println("예외 :" + e);
      }
      finally
      {
         
      }
   }// end main

}
