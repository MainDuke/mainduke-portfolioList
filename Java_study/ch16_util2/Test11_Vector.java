/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 3:36:02
 * Modified: 2016�� 2�� 11�� ����� ���� 3:36:02
 */

import java.util.*;

class Test11_Vector
{
	public static void main( String [] args ) 
   {
      
      Vector<String> vec= new Vector<String>(4,3);
      //�ʱ� ���� �뷮 4, 3 �� �ø���.
      
      System.out.println("���� size : "+vec.size());
      System.out.println("���� capacity : "+vec.capacity());
      
      vec.add("���");
      vec.add("����");
      vec.add("����");
      vec.add("Ű��");
      vec.add("����");
      
      //get() ��ҷ� ���.
      for(int i=1;i<vec.size();i++)
      {
         System.out.print(vec.get(i)+",");
      }
      System.out.println();
      System.out.println("���� size : "+vec.size());
      System.out.println("���� capacity : "+vec.capacity());
      
      
   }// end main

}//class end
