/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오전 10:21:42
 * Modified: 2016년 2월 5일 금요일 오전 10:21:42
 */


//윤년. 구하기.


import java.util.*;
class Test05_Calendar
{
	public static void main(String args[]){
      GregorianCalendar gc = new GregorianCalendar();
     
      
      /*if(gc.isLeapYear(gc.get(Calendar.YEAR)))
      {
        System.out.println(gc.get(Calendar.YEAR)+" 는 윤년"); 
      }else{
         System.out.println(gc.get(Calendar.YEAR)+" 는 평년");
  
      }*/
      
      //1988년도가 윤녕인지 평년인지 구하시오.
      
      int a= 1988;
      
      System.out.println(gc.isLeapYear(a));
      
      //isLeapYear(int a); 메서드는 a값을 윤년인지 판별하여 true, false를 리턴한다. 
      
      if(gc.isLeapYear(a))
      {
         System.out.println(a+" 는 윤년"); 
      }else{
         System.out.println(a+" 는 평년");
         
      }
      
      
      
      Calendar cal=Calendar.getInstance();
      
      //올해의 몇번째 주인가.
      System.out.println("올해의 "+cal.get(Calendar.WEEK_OF_YEAR)+"주 입니다.");
      
      //1년중 오늘이 몇번째 날인가?
      System.out.println("올해의 "+cal.get(Calendar.DAY_OF_YEAR)+"일 입니다.");
      
      //이번주의 몇번째 요일인가?
      System.out.println("이번주의 "+cal.get(Calendar.DAY_OF_WEEK)+"번째 요일입니다.");
      
      
   }//main end

}//class end.
