/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 2:52:02
 * Modified: 2016�� 2�� 11�� ����� ���� 2:52:02
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
         
         //r.nextInt() �޼���� 0~45 �����̹Ƿ� ... �Ʒ��� ����. �Ѵ�.
         int a=(int)(Math.random()*45+1);
         String ss=a+""; //���ڿ��� ��ȯ.
         set.add(ss);
      }//while
      
      //���
      Iterator iter=set.iterator();
      while(iter.hasNext())
      {
         System.out.print(iter.next()+ " ");
      }
      System.out.println();
      
   }// end main

}
