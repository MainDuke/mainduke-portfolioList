/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오후 3:18:19
 * Modified: 2016년 1월 26일 화요일 오후 3:18:19
 */

//클래스 상속
//클 extends 클 
//인 extends 인,인,인,인
//클 implements 인


class General{
	//static 메서드는 static 선언된것만 사용한수 있다.
	
	static int roomNo=100;
	
	}

class Test04_extends extends General
{
	public static void main( String [] args )
	{
		
		System.out.println("roomNo: "+ roomNo);	
		
		
	}// end main

}//class end
