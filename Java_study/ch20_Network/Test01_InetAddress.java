/*
 * Author: Administrator
 * Created: 2016년 2월 16일 화요일 오후 12:26:14
 * Modified: 2016년 2월 16일 화요일 오후 12:26:14
 */

import java.net.*;

class Test01_InetAddress
{
	public static void main( String [] args ) 
   {
      try{
      //도메인 주소를 args[0] 로 입력하여
      //ip 주소를 얻는 예제.
      
      InetAddress ias[]=InetAddress.getAllByName(args[0]);
      
      for(int i=0;i<ias.length;i++)
      {
         System.out.println(" "+ i+1 +" 번째");
         System.out.println(ias[i].getHostName()); //도메인 얻기.
         System.out.println(ias[i].getHostAddress()); //IP얻기.
      }
   }catch(Exception e){
      e.printStackTrace();
   }//catch.
      
      
      
   }// end main

}//class end

//실행 결과
//localhost : 127.0.0.1 ;
//www.naver.com
//www.daum.net
//www.nate.com


