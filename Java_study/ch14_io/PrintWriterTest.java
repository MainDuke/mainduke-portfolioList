/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 9:28:51
 * Modified: 2016년 2월 4일 목요일 오전 9:28:51
 */


/*생성자
PrintWriter(OutputStream os);
PrintWriter(OutputStream os, boolean flushOnNewLine);

boolean flushOnNewLine : true/ false로 지정
문자가 출력 될때마다, 출력 스트림 내용을 비울 것인가 여부를 지정.
true : 출력 스트림 내용을 비운다.

PrintWriter(Writer w);
PrintWriter(Writer w , boolean flushOnNewLine);

java의 PrintWriter 객체는 object를 비롯한
모든 형식에 대해서 print()와 println()메서드를 wldnjsgksek.

예:
print("문자열 ");
print(100);
print(88.8);
print("A");
print(객체);

 */

import java.io.*;

class PrintWriterTest
{
	public static void main( String [] args ) throws Exception
   {
      PrintWriter pp = new PrintWriter(System.out); //객체 생성.
      pp.println('A');
      pp.println(100);
      pp.println(77.8);
      pp.println(true);
      pp.println(new java.util.Date());
      
      pp.close();
      
      
      
   }// end main

}
