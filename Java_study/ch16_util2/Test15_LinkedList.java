/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 9:38:57
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 9:38:57
 */

import java.util.*;

class Test15_LinkedList
{
	public static void main( String [] args ) 
   {
      LinkedList<String> list= new LinkedList<String>();
      
      list.offer("red"); //ť�� ������ ����.
      list.offer("green");
      list.offer("blue");
      list.offer("orange");
      list.offer("black");
      list.offer("white");

      while(list.peek()!=null)//null �ƴѵ��� �ݺ�.
      {
   System.out.println(list.poll());//queue�� ����� ��ü��������.
      }

      
   }// end main

}
