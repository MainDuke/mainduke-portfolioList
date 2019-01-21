/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 9:10:27
 * Modified: 2016년 2월 4일 목요일 오전 9:10:27
 */

/*System.in 은 InputStream객체 이기 때문에 InputStreamReader 생성자 인수로 전달된다.
그런다음 InputStreamReader 객체가 BufferReader 생성자 인수로 전달된다.*/

import java.io.*;

class ReadConsole
{
	public static void main (String args[]) throws Exception 
   {
    InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader be= new BufferedReader(isr);
      
      String strKor, strEng; 
      int kor, eng, tot;
      
      System.out.print("국어점수를 입력하시오 >>");
      strKor=be.readLine();
      
      System.out.print("영어점수를 입력하시오 >>");
      strEng=be.readLine();

  
      kor=Integer.parseInt(strKor);
      eng=Integer.parseInt(strEng);

      tot= kor+eng;
       System.out.printf("국어 점수 : %d 영어 점수 : %d 총점 %d", kor, eng, tot);

  
      
   }//end main

}//class end
