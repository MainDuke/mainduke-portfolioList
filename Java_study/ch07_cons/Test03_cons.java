/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오후 3:33:06
 * Modified: 2016년 1월 25일 월요일 오후 3:33:06
 */


/*this : 자신의 객체를 가르킨다.
this() : 자신의 클래스 내의 생성자 호출.
this() 나 super()는 생성자 내에서 첫ㅈ둘에 기재 해야된다.
이둘은 동시에 사용할수 없다.*/


class Cons{
	//변수
	String title;
	int num;

	
	//1.디폴트 생성자를 넣으시오.
	public Cons(){}
	
	//2. 인자 있는 생성자.
	public Cons(String title, int num){
		this.title=title;
		this.num=num;
		System.out.println("Cons(String title, int num) call... ");
		System.out.println(title+"---"+num);
		
	}
	//3. 인자 있는 생성자.
	public Cons(String title){
		this(title, 200);//인수값 과 일치하는 생성자 호출.
		System.out.println("Cons(String title) call... \n");
	}
}//class end

class Test03_cons
{
	public static void main( String [] args )
	{
		new Cons("연습1");//3번 호출.
		
		new Cons("연습2", 300); //2번 호출.
		
		
	}// end main

}//class end
