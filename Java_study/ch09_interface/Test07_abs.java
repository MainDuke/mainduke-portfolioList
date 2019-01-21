/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 11:17:59
 * Modified: 2016년 1월 28일 목요일 오전 11:17:59
 */

abstract class Abs{
	
	String name;//필드
	
	public Abs(String name){
	this.name= name;
	}
	public void disp(){
		System.out.println("일반 메서드 disp() : "+name);
	}
	
	abstract public void kk(); //추상 메서드.
}//class end



class Test07_abs extends Abs{
	//생성자
	public Test07_abs(String name){
		super(name);
	}
	//오버라이딩
	public void kk(){
		System.out.println("추상 메서드 오버라이딩 : "+name);
	}

	public static void main( String [] args ) 
	{
		Test07_abs test= new Test07_abs("홍길동");
		test.kk();
		test.disp();
			
	}// end main
}	