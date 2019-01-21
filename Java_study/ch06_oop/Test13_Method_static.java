/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 9:42:15
 * Modified: 2016년 1월 25일 월요일 오전 9:42:15
 */
//static 메서드는 static으로 선언된 변수, 메서드만 호출 가능.
//Math.max(5,2) => static으로 선언된 메서드는 객체 생성않고도 호출가능.
//클래스.메서드();

//-static 변수는 모든 객체가 그를 공유 할수 있다.
class Test13_Method_static
{
	static int a = 100;
	
	public static void aa(){

		System.out.println("aa() call");
		
	}//class end.
	
	public static void bb(){
		System.out.println("bb() call");
		
	}
	
	
	public static void main( String [] args )
	{
	
		aa();//static 에서 객체 생성 않고도 호출가능.
		System.out.println();		
		
		
	}// end main

}
