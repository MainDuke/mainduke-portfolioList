/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오전 10:04:34
 * Modified: 2016년 2월 5일 금요일 오전 10:04:34
 */

import java.util.*;
import java.text.SimpleDateFormat;

class Test04_Date
{
	  public static void main(String args[]){
         
         java.util.Date date = new java.util.Date(); //객체 생성.
         
         System.out.println(date);
         
         SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
         System.out.println(sdf.format(date));

         SimpleDateFormat sdf2= new SimpleDateFormat("yyyy년 MM월 dd일");
         System.out.println(sdf2.format(date));   
         
         SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd H : mm:ss a EEEE");
         System.out.println(sdf3.format(date));
         
         SimpleDateFormat sdf4= new SimpleDateFormat("yyyy-MM-dd H:mm:ss a EEE");
        System.out.println(sdf4.format(date)); 
         
      }

  
}
