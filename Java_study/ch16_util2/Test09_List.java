/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 2:57:29
 * Modified: 2016�� 2�� 11�� ����� ���� 2:57:29
 */
/*List, ArrayList �ߺ� ���.
Collection �������̽��� ũ�� Set, List�� �����µ�
Set�� ������ ���� �������� �ߺ��� ������� �ʴ´�.
List�� ������ �ִ� �������� �ߺ��� ����Ѵ�.

Iterator�� �ݷ����ڷ���� �޾Ƽ� ó���� �� �ִ�.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


class Test09_List
{
	public static void main( String [] args ) 
   {
      List<String> list= new ArrayList<String>(); //��ü ����.
      
      list.add("���");//index 0
      list.add("���");//index 1
      list.add("����");//index 2
      list.add("���");//index 3
      list.add("����");//index 4
      list.add("����"); //index 5
      
      //.add() ȣ���� ������� ����ȴ�.
      System.out.println("��Ұ��� " +list.size());
      
      //Iterator ��ü�� ��� ���.
      Iterator iter = list.iterator();
      
      while(iter.hasNext())
      {
         System.out.print(iter.next()+" ");
      }
      System.out.println();
   }// end main

}//class end
