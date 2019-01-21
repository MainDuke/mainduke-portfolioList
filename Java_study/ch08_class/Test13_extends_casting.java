/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오후 2:33:39
 * Modified: 2016년 1월 27일 수요일 오후 2:33:39
 */

//cf) int a=(int)12.5; // casting

class SuperTest{
	public void disp(){
	System.out.println("super disp클래스");
	}
	public void pp(){
		System.out.println("super 클래스 pp()");
	}
	
}//class end --
class SubTest extends SuperTest{
	//오버라이딩
	public void disp(){
		System.out.println("sub 클래스 disp");
	}
	public void kk(){
		System.out.println("sub 클래스 kk()");
	}
	
}//class end ---------------


class Test13_extends_casting
{
	public static void main( String [] args )
	{
		SuperTest s= new SuperTest();
		s.disp();
		System.out.println("-----");
		
		
		s= new SubTest(); //상위 클래스 변수로 하위객체 처리 //upcasting
		System.out.println("-----");
		s.disp(); //double d=100; //자동 형 변환.
		System.out.println("-----");
		s.pp();
		System.out.println("-----");
		((SubTest)s).kk(); //클래스 캐스팅.
		//int a=(int)12.5; //강제 형 변환.
		
		System.out.println("-----");
		System.out.println("test");
		
		SubTest s2= new SubTest();
		s2.disp();
		s2.kk();
		
		
	}// end main

}//class
