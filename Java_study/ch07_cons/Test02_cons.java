/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오후 12:12:59
 * Modified: 2016년 1월 25일 월요일 오후 12:12:59
 */


class SinSang{
	
	//전역 변수.
	String name; 
	int age;
	double ki;
		
	//1.디폴트 생성자.
	public SinSang(){
	System.out.println("call default");
	}
	
	//2. 인자 생성자.
	public SinSang(String name, int age, double ki){
	
		String ch="";
		int aa=0;
		double bb=0;
				
		this.name=name;
		this.age=age;
		this.ki=ki;
	
	System.out.println("call 인자1");
	}
	
	//3.인자 있는 생성자.
	public SinSang(int age, String name, double ki){
		
		this.age=age;
		this.name=name;
		this.ki=ki;
	
	System.out.println("call 인자2");
	}
	public void disp(){
	System.out.println(name+"---"+age+"---"+ki);
	}
	
	
	
	
	
}//class end.

class Test02_cons
{
	public static void main( String [] args )
	{
		//3번 생성자 생성하시오.
		SinSang s3 = new SinSang(15, "홍길동", 177.5);
		//2번 생성자 생성하시오.
		SinSang s2 = new SinSang("파파야", 44, 176.3);
		//1번 생성자 생성하시오.
		SinSang s1 = new SinSang();
		
		System.out.println();
		
		s3.disp();
		s2.disp();
		s1.disp();
			
		
		
	}// end main

}//class end.
