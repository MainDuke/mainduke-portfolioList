/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 3:36:02
 * Modified: 2016년 2월 11일 목요일 오후 3:36:02
 */

import java.util.*;

class Test11_Vector
{
	public static void main( String [] args ) 
   {
      
      Vector<String> vec= new Vector<String>(4,3);
      //초기 벡터 용량 4, 3 씩 늘린다.
      
      System.out.println("벡터 size : "+vec.size());
      System.out.println("벡터 capacity : "+vec.capacity());
      
      vec.add("사과");
      vec.add("딸기");
      vec.add("수박");
      vec.add("키위");
      vec.add("참외");
      
      //get() 요소로 얻기.
      for(int i=1;i<vec.size();i++)
      {
         System.out.print(vec.get(i)+",");
      }
      System.out.println();
      System.out.println("벡터 size : "+vec.size());
      System.out.println("벡터 capacity : "+vec.capacity());
      
      
   }// end main

}//class end
