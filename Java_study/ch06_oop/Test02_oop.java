/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오전 10:17:27
 * Modified: 2016년 1월 22일 금요일 오전 10:17:27
 */

//하나 이상의 클래스로 구성된 클래스 집합체 이다.
//저장된 이름은 main()이 소속해 있는 클래스로 저장한다.
//실습 메서드.


class Demo02{
	public void aa(){
	System.out.println("aa() call");
	}
	public void bb(){
		System.out.println("bb() call");
	}	
}

//클래스를 사용하려면 객체를 생성해야한다.
class Test02_oop
{
	public static void main( String [] args ) 
	{
		
		// int a= 10; 기본 자료형 변수
		//클래스변수=인스턴스=레퍼런스=객체
		
		Demo02 d1 = new Demo02(); //객체 생성
		//클래스를 사용하려면 객체를 생성해야한다.
		
		//객체.메서드()
		d1.aa(); //객체를 호출한다.
		d1.bb();
				
	}// end main

}//class end
