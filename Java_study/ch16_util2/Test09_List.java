/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 2:57:29
 * Modified: 2016년 2월 11일 목요일 오후 2:57:29
 */
/*List, ArrayList 중복 허용.
Collection 인터페이스는 크게 Set, List로 나뉘는데
Set은 순서가 없는 집합으로 중복을 허용하지 않는다.
List는 순서가 있는 집합으로 중복을 허용한다.

Iterator는 콜렛션자료들을 받아서 처리할 수 있다.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


class Test09_List
{
	public static void main( String [] args ) 
   {
      List<String> list= new ArrayList<String>(); //객체 생성.
      
      list.add("사과");//index 0
      list.add("사과");//index 1
      list.add("포도");//index 2
      list.add("사과");//index 3
      list.add("포도");//index 4
      list.add("수박"); //index 5
      
      //.add() 호출한 순서대로 저장된다.
      System.out.println("요소갯수 " +list.size());
      
      //Iterator 객체로 요소 얻기.
      Iterator iter = list.iterator();
      
      while(iter.hasNext())
      {
         System.out.print(iter.next()+" ");
      }
      System.out.println();
   }// end main

}//class end
