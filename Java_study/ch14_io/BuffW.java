/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오후 3:39:01
 * Modified: 2016년 2월 3일 수요일 오후 3:39:01
 */

import java.io.*;

class BuffW
{
	public static void main( String [] args ) throws Exception
   {
      //FileWriter fr = new FileWriter("a2.txt");
      //ByfferdWriter bw = new BufferdWriter(rf);
      
      BufferedWriter bw = new BufferedWriter(new FileWriter("a2.txt"));
      
      //파일에 문자열 쓰기
      
      for(int i=1;i<=5;i++)
      {
         bw.write("줄번호"+i+"\n"); 
        
      }
      bw.close();
      
      
   }// end main

}//class end !!!
