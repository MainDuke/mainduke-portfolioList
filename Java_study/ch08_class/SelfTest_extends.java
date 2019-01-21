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


class SelfTest_extends
{
	public static void main( String [] args )
	{
		System.out.println("test");
		
		SubTest s= new SubTest();
		s.disp();
		System.out.println("-----");
		
		s= ((SubTest)(new SuperTest())); 
		s.pp(); //double d=100; //자동 형 변환.
		System.out.println("test");
		
		
		
	}// end main
	
}//class