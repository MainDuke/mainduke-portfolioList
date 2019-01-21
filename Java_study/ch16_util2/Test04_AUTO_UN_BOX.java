/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 12:46:57
 * Modified: 2016년 2월 11일 목요일 오후 12:46:57
 */


class Test04_AUTO_UN_BOX
{
public static void main( String [] args ) 
{
   int a = 10;
   Integer A=a; //이때 stack 영역에 있던 값이 heap 영역에 저장.
   
   Integer B = new Integer(20);
   
   int b = B; //heap 영역에 존재한 레퍼런스형 객체가 가진값이
   //stack 영역에 복사 되는데 이를 Unbocing 이라 한다.
   
   System.out.println("a : "+a);
   System.out.println("A : "+A);
   System.out.println("B : "+B);
   System.out.println("b : "+b);

   
   
}// end main

}
