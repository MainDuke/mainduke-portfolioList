/*
 * Author: Administrator
 * Created: 2016�� 2�� 16�� ȭ���� ���� 12:26:14
 * Modified: 2016�� 2�� 16�� ȭ���� ���� 12:26:14
 */

import java.net.*;

class Test01_InetAddress
{
	public static void main( String [] args ) 
   {
      try{
      //������ �ּҸ� args[0] �� �Է��Ͽ�
      //ip �ּҸ� ��� ����.
      
      InetAddress ias[]=InetAddress.getAllByName(args[0]);
      
      for(int i=0;i<ias.length;i++)
      {
         System.out.println(" "+ i+1 +" ��°");
         System.out.println(ias[i].getHostName()); //������ ���.
         System.out.println(ias[i].getHostAddress()); //IP���.
      }
   }catch(Exception e){
      e.printStackTrace();
   }//catch.
      
      
      
   }// end main

}//class end

//���� ���
//localhost : 127.0.0.1 ;
//www.naver.com
//www.daum.net
//www.nate.com


