/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 12:35:21
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 12:35:21
 */

import java.util.*;
class Test10_StringTokenizer
{
	public static void main( String [] args ) 
   {
     StringTokenizer st =new StringTokenizer("��������|�� ���ø�| ���ϸ�.","|");
      System.out.println("�Ľ̵� ���ڿ� ����: "+st.countTokens());
      
      while(st.hasMoreTokens())//token�� �����ִ� ���� �ݺ� ����.
      {
         System.out.println(st.nextToken());
         
      }//while û����� ���� ����
      //
      //
      //
      
      //�Ľ� ��ȣ�� �����ϸ� �������� �и��Ѵ�.
      StringTokenizer st2= new StringTokenizer("����� ������ ���ﵿ");
      while(st2.hasMoreTokens())
      {
         System.out.println(st2.nextToken());
      }
      
      //String.split() : ���ڿ� �и� ��Ű�� �޼����̴�.
     String str="�����:������:���ﵿ";
      String temp[]= str.split(":"); //���ڿ� �и�.
      
      for(int i=0;i<temp.length;i++)
      {
         System.out.println(temp[i]);
      }
     
      
      
   }// end main

}
