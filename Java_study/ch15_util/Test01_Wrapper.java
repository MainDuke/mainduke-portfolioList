/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 4:36:12
 * Modified: 2016�� 2�� 4�� ����� ���� 4:36:12
 */

import java.util.*;
class Test01_Wrapper
{
	public static void main( String [] args )
   {
     boolean b= true;
      Boolean B = new Boolean(b);
      
      int a=30;
      Integer A= new Integer(a); 
      
      float f= 11.3f;
      Float F=new Float(f);
      
      System.out.println("Wrapper Ŭ������ �� : "+B.toString());
      System.out.println("Wrapper Ŭ������ �� : "+A.toString());
      System.out.println("Wrapper Ŭ������ �� : "+F.toString());
      
      
      //java5 �������ʹ�
      //�⺻ �ڷ����� WrapperClass �ڷ�����
      //�ڵ����� ��ȯ�ȴ�.
      
   }// end main

}//class
