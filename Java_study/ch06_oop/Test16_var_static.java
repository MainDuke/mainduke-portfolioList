/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 10:47:51
 * Modified: 2016년 1월 25일 월요일 오전 10:47:51
 */
//static 메서드는 static으로 선언된 변수, 메서드만 호출 가능.
//Math.max(5,2) => static으로 선언된 메서드는 객체 생성않고도 호출가능.
//클래스.메서드();

//-static 변수는 모든 객체가 그를 공유 할수 있다.
//static 에서 객체 생성 않고도 호출가능.
//static 메서드에서는 this 사용 못함: 자신을 2번 지칭하는 것이므로..

class Test16_var_static
{
	
	static int a = 100;
	
	public static void main(String args[]){
	
	int  a= 200; //지역변수.

	System.out.println("지역변수 a:"+a);
	System.out.println("전역변수 this.a:"+(this.a)); //static 메서드 안에서 this 호출 안된다. 
	
	
}//main end
}//class end
