/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 12:09:25
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 12:09:25
 */

import java.util.*;

class Test09_Vector_Enum
{
	public static void main( String [] args ) 
   {
      String s1="hello1";
      String s2="hello2";
      String s3="hello3";
      
      Vector vec = new Vector();
      
      vec.add(s1);//���Ϳ� ������ �ֱ�.
      vec.add(s2);
      vec.add(s3);
      
      System.out.println("��� ���� : "+vec.size());
      
      for(int i=0;i<vec.size();i++)
      {
         System.out.println((String)vec.get(i));
      }
      
      
      System.out.println("---------------------");
      System.out.println();
      //Enumeration
      Enumeration en= vec.elements(); //en�� ������ ��� �ڷḦ �Ҵ�.
 
      while(en.hasMoreElements()){ //en�� ��Ұ� �ִ� ���� �ݺ�.
         System.out.println((String)(en.nextElement()));
      }
      
   }// end main

}
