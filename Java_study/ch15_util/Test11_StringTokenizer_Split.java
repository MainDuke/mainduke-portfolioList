/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 2:19:49
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 2:19:49
 */

import java.util.*;
class Test11_StringTokenizer_Split
{
	public static void main( String [] args ) 
   {
      String addr="�����:������ �λ��:������ ������:�����";
      String temp[]=addr.split(" "); //�����ڴ� ����.
   
      for(int i=0; i<temp.length;i++)
      {
         StringTokenizer st=new StringTokenizer(temp[i], ":");//��ü ����.
      
      while(st.hasMoreElements())//��ũ ��Ұ� �����ϴ� ���� �ݺ�.
      {
         System.out.print(st.nextToken()+" ");
      }
   
   }//for
      System.out.println();   
      
   }// end main

}//class end
