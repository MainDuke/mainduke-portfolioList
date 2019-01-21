/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오후 4:36:12
 * Modified: 2016년 2월 4일 목요일 오후 4:36:12
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
      
      System.out.println("Wrapper 클래스의 값 : "+B.toString());
      System.out.println("Wrapper 클래스의 값 : "+A.toString());
      System.out.println("Wrapper 클래스의 값 : "+F.toString());
      
      
      //java5 버전부터는
      //기본 자료형과 WrapperClass 자료형이
      //자동으로 변환된다.
      
   }// end main

}//class
