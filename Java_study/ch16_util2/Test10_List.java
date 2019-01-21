/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 3:26:30
 * Modified: 2016년 2월 11일 목요일 오후 3:26:30
 */

import java.util.*;

class Test10_List
{
   
	public static void main( String [] args ) 
   {
      Test10_List A= new Test10_List();
      
      List<String>list= new ArrayList<String>();
      list.add("사과");
      list.add("사과");
      list.add("사과");
      list.add("사과");
      list.add("사과");
      list.add("사과");
      A.listPrint(list);
      //
      list.add(2, "키위"); //index =2 번째 키위 삽입.
      A.listPrint(list);
      //
      list.add(4, "포도");
      A.listPrint(list);
      //
      list.remove("키위"); //키위 삭제.
      A.listPrint(list);
      //
      
   }// end main

   //custom
   //매개변수에도 generic 해준다.
   public void listPrint(List<String> list){
      for(String str:list)
      {
         System.out.print(str+",");
      }
      System.out.println();
   }//list Print end
   
   
   
}//class end 
