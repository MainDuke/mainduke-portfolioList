/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 2:36:27
 * Modified: 2016년 2월 11일 목요일 오후 2:36:27
 */


/*Collection 인터페이스는 크게 Set, List로 나뉘는데...*/

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Test07_Set
{
	public static void main( String [] args )
   {
      Set<String> set=new HashSet<String>(); //상위클래스변수로 하위객체 처리.
     set.add("참외");
     set.add("수박");
     set.add("딸기");
     set.add("수박");
     set.add("참외");
     set.add("참외");
  
   System.out.println("요소갯수 : "+set.size());
  Iterator iter =set.iterator();
   while(iter.hasNext())
   {
      System.out.println(iter.next());
   }
   
   
   }// end main

}//class end
