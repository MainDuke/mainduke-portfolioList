/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오전 10:47:44
 * Modified: 2016년 2월 11일 목요일 오전 10:47:44
 */


class Test16_String
{
	public static void main( String [] args ) 
   {
      String s1 = "hello";
      String s2 = "good";
      System.out.println(s1.length());
      System.out.println(s1.concat(s2)); //문자열 합침
      System.out.println(s1.replace('e','a')); //문자열 치환. 문자 치환.
      System.out.println(s1.replaceAll("hello", "안녕")); //
      System.out.println(s1.toUpperCase());
      String s3 = "GOODMORNING";
      System.out.println(s3.toLowerCase());//소문자 치환.
      System.out.println(s3.charAt(4));
      
      String name= "홍길동";
      System.out.println(name.replace("홍길동", "손오공"));
      
      
      //시스템 관리자도 알수 없다 이건~~
      
      StringBuffer jumin=new StringBuffer("881219-1055910");

      jumin.replace(0,6,"*******");
      System.out.println(jumin.toString());
      
      
   }// end main

}//class end
