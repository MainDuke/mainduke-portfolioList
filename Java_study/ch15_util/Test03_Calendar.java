/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오전 9:36:02
 * Modified: 2016년 2월 5일 금요일 오전 9:36:02
 */

import java.util.*;

class Test03_Calendar
{
   
	public static void main(String args[]){
      
      Calendar cal = Calendar.getInstance(); //객체 생성.
      
      int year =cal.get(Calendar.YEAR); //년도.
      int month = cal.get(Calendar.MONTH)+1; //월. 1월(0)~12월(11) 이므로 +1 해줘야한다.
      int day = cal.get(Calendar.DATE); //일.
      
      int h=cal.get(Calendar.HOUR); //시간.
      int m=cal.get(Calendar.MINUTE); //분
      int s= cal. get(Calendar.SECOND); //초
      
      System.out.println(year+"년 "+month+"월 "+day+"일 ");
      System.out.println(h+"시 "+m+"분 "+s+"초 ");
      
      
   }//main end

}//class end
