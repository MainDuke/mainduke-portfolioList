/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 9:24:33
 * Modified: 2016년 1월 25일 월요일 오전 9:24:33
 */

//Math.max(5,2) => static으로 선언된 메서드는 객체 생성않고도 호출가능.
//클래스.메서드();


//-static 변수는 모든 객체가 그를 공유 할수 있다.


class Test12_Method_staticStarting application C:\01_java\ch06_oop\Test15_Method_static.class
{
	
	static int a=100;
	public static void aa(){
		System.out.println("aa() call");
	}//	
	public static void main( String [] args ) 
	{
		System.out.println("a : "+a);
		
		aa();
		
	}// end main

}//class end
