/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 3:26:30
 * Modified: 2016�� 2�� 11�� ����� ���� 3:26:30
 */

import java.util.*;

class Test10_List
{
   
	public static void main( String [] args ) 
   {
      Test10_List A= new Test10_List();
      
      List<String>list= new ArrayList<String>();
      list.add("���");
      list.add("���");
      list.add("���");
      list.add("���");
      list.add("���");
      list.add("���");
      A.listPrint(list);
      //
      list.add(2, "Ű��"); //index =2 ��° Ű�� ����.
      A.listPrint(list);
      //
      list.add(4, "����");
      A.listPrint(list);
      //
      list.remove("Ű��"); //Ű�� ����.
      A.listPrint(list);
      //
      
   }// end main

   //custom
   //�Ű��������� generic ���ش�.
   public void listPrint(List<String> list){
      for(String str:list)
      {
         System.out.print(str+",");
      }
      System.out.println();
   }//list Print end
   
   
   
}//class end 
