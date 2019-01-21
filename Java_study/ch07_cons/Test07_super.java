/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오전 10:21:10
 * Modified: 2016년 1월 26일 화요일 오전 10:21:10
 */

//super() :  상위 클래스내 생성자 호출. super()는 클래스 첫줄에 기재.
//super : 상위 클래스 객체

class ConSuper{
	String title;//변수.
	int num;
	
	public ConSuper(){}//디폴트 생성자.
	
	
	public ConSuper(String title, int num){
		
		this.title=title;
		this.num=num;
	}//ConSuper end
	
	public void disp(){
		System.out.println(title+"---"+num);
	}	//disp end
}//class end===========

//파생 클래스 : 상속 받는 입장이다.
class ConSub extends ConSuper{		
	
	public ConSub(){
	
	//super("abc", 12);
}
	//만약에 super("abc", 123) 없으면
	//디폴트 생성자를 호출한다.	
}//Consub end

class Test07_super
{
	public static void main( String [] args ) 
	{
		ConSub sub= new ConSub();
		sub.disp();
		
	}// end main
	

}//class
