/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 9:38:09
 * Modified: 2016년 1월 28일 목요일 오전 9:38:09
 */

//인터페이스.

interface AA3{
	int aa(); //인터페이스 메서드는 생략하여도 public 이다.
}//AA3 end
class BB3 implements AA3{
	//오버라이딩, 인터페이스 상속은 모든 메서드를 오버라이딩 해야한다.
	public int aa(){
		System.out.println("BB3.aa()....");
		return 100;
	}//method.aa() end	
}//BB3 end

class CC3 implements AA3
{
	public int aa(){
		System.out.println("CC3.aa()....");
		
	return 200;
	}//aa();
}//CC3 end

class Test03_interface
{
	public static void main(String args[]){
		System.out.println(new BB3().aa());
		
		System.out.println();
		System.out.println(new CC3().aa());
		
		
	}//main end
	
}//class end
