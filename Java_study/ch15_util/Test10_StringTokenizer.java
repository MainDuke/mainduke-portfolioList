/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오후 12:35:21
 * Modified: 2016년 2월 5일 금요일 오후 12:35:21
 */

import java.util.*;
class Test10_StringTokenizer
{
	public static void main( String [] args ) 
   {
     StringTokenizer st =new StringTokenizer("좋은데이|를 마시면| 취하리.","|");
      System.out.println("파싱된 문자열 갯수: "+st.countTokens());
      
      while(st.hasMoreTokens())//token이 남아있는 동안 반복 수행.
      {
         System.out.println(st.nextToken());
         
      }//while 청기와집 영수 정희
      //
      //
      //
      
      //파싱 기호를 생략하면 공백으로 분리한다.
      StringTokenizer st2= new StringTokenizer("서울시 마포구 대흥동");
      while(st2.hasMoreTokens())
      {
         System.out.println(st2.nextToken());
      }
      
      //String.split() : 문자열 분리 시키는 메서드이다.
     String str="서울시:마포구:대흥동";
      String temp[]= str.split(":"); //문자열 분리.
      
      for(int i=0;i<temp.length;i++)
      {
         System.out.println(temp[i]);
      }
     
      
      
   }// end main

}
