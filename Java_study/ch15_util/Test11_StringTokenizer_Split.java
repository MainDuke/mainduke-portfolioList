/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오후 2:19:49
 * Modified: 2016년 2월 5일 금요일 오후 2:19:49
 */

import java.util.*;
class Test11_StringTokenizer_Split
{
	public static void main( String [] args ) 
   {
      String addr="서울시:마포구 부산시:동래구 대전시:대덕구";
      String temp[]=addr.split(" "); //구분자는 공백.
   
      for(int i=0; i<temp.length;i++)
      {
         StringTokenizer st=new StringTokenizer(temp[i], ":");//객체 생성.
      
      while(st.hasMoreElements())//토크 요소가 존재하는 동안 반복.
      {
         System.out.print(st.nextToken()+" ");
      }
   
   }//for
      System.out.println();   
      
   }// end main

}//class end
