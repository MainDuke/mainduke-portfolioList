/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 2:36:27
 * Modified: 2016�� 2�� 11�� ����� ���� 2:36:27
 */


/*Collection �������̽��� ũ�� Set, List�� �����µ�...*/

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Test07_Set
{
	public static void main( String [] args )
   {
      Set<String> set=new HashSet<String>(); //����Ŭ���������� ������ü ó��.
     set.add("����");
     set.add("����");
     set.add("����");
     set.add("����");
     set.add("����");
     set.add("����");
  
   System.out.println("��Ұ��� : "+set.size());
  Iterator iter =set.iterator();
   while(iter.hasNext())
   {
      System.out.println(iter.next());
   }
   
   
   }// end main

}//class end
