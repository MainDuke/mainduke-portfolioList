/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 2:52:02
 * Modified: 2016년 2월 11일 목요일 오후 2:52:02
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


class Test08_Set_Lotto
{
	public static void main( String [] args ) 
   {
      HashSet<String> set= new HashSet<String>();
      while(set.size()<6)
      {
         
         //r.nextInt() 메서드는 0~45 정수이므로 ... 아래와 같이. 한다.
         int a=(int)(Math.random()*45+1);
         String ss=a+""; //문자열로 변환.
         set.add(ss);
      }//while
      
      //출력
      Iterator iter=set.iterator();
      while(iter.hasNext())
      {
         System.out.print(iter.next()+ " ");
      }
      System.out.println();
      
   }// end main

}
