/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 10:21:42
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 10:21:42
 */


//����. ���ϱ�.


import java.util.*;
class Test05_Calendar
{
	public static void main(String args[]){
      GregorianCalendar gc = new GregorianCalendar();
     
      
      /*if(gc.isLeapYear(gc.get(Calendar.YEAR)))
      {
        System.out.println(gc.get(Calendar.YEAR)+" �� ����"); 
      }else{
         System.out.println(gc.get(Calendar.YEAR)+" �� ���");
  
      }*/
      
      //1988�⵵�� �������� ������� ���Ͻÿ�.
      
      int a= 1988;
      
      System.out.println(gc.isLeapYear(a));
      
      //isLeapYear(int a); �޼���� a���� �������� �Ǻ��Ͽ� true, false�� �����Ѵ�. 
      
      if(gc.isLeapYear(a))
      {
         System.out.println(a+" �� ����"); 
      }else{
         System.out.println(a+" �� ���");
         
      }
      
      
      
      Calendar cal=Calendar.getInstance();
      
      //������ ���° ���ΰ�.
      System.out.println("������ "+cal.get(Calendar.WEEK_OF_YEAR)+"�� �Դϴ�.");
      
      //1���� ������ ���° ���ΰ�?
      System.out.println("������ "+cal.get(Calendar.DAY_OF_YEAR)+"�� �Դϴ�.");
      
      //�̹����� ���° �����ΰ�?
      System.out.println("�̹����� "+cal.get(Calendar.DAY_OF_WEEK)+"��° �����Դϴ�.");
      
      
   }//main end

}//class end.
