/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오후 12:09:25
 * Modified: 2016년 2월 5일 금요일 오후 12:09:25
 */

import java.util.*;

class Test09_Vector_Enum
{
	public static void main( String [] args ) 
   {
      String s1="hello1";
      String s2="hello2";
      String s3="hello3";
      
      Vector vec = new Vector();
      
      vec.add(s1);//벡터에 데이터 넣기.
      vec.add(s2);
      vec.add(s3);
      
      System.out.println("요소 갯수 : "+vec.size());
      
      for(int i=0;i<vec.size();i++)
      {
         System.out.println((String)vec.get(i));
      }
      
      
      System.out.println("---------------------");
      System.out.println();
      //Enumeration
      Enumeration en= vec.elements(); //en에 벡터의 모든 자료를 할당.
 
      while(en.hasMoreElements()){ //en에 요소가 있는 동안 반복.
         System.out.println((String)(en.nextElement()));
      }
      
   }// end main

}
