/*
 * Author: Administrator
 * Created: 2016년 2월 12일 금요일 오전 9:38:57
 * Modified: 2016년 2월 12일 금요일 오전 9:38:57
 */

import java.util.*;

class Test15_LinkedList
{
	public static void main( String [] args ) 
   {
      LinkedList<String> list= new LinkedList<String>();
      
      list.offer("red"); //큐에 데이터 저장.
      list.offer("green");
      list.offer("blue");
      list.offer("orange");
      list.offer("black");
      list.offer("white");

      while(list.peek()!=null)//null 아닌동안 반복.
      {
   System.out.println(list.poll());//queue에 저장된 객체를꺼낸다.
      }

      
   }// end main

}
