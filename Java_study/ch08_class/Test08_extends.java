/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오전 9:38:27
 * Modified: 2016년 1월 27일 수요일 오전 9:38:27
 */


//상속 예제
//수퍼클래스.
class PersonSuper{
	
	protected String name;//필드
	
	public PersonSuper(String name){//생성자.
		this.name=name;
	}
	public void disp(){//메서드
		System.out.println(name);
	}	
		
}//--class end-------------------

class PersonSub extends PersonSuper{
	
	private double left_eye;//왼쪽 시력
	private double right_eye;//오른쪽 시력
	
	//생성자.
	public PersonSub(String name, double left_eye, double right_eye)
	{
	super(name);
	this.left_eye=left_eye;
	this.right_eye=right_eye;
	}
	//오버라이딩
	public void disp(){
		System.out.println("name: "+name);
		System.out.println("left_eye"+left_eye);
		System.out.println("right_eye"+right_eye);
	}	

}//------------class end

public class Test08_extends
{
	public static void main( String [] args )
	{
		
		PersonSuper p= new PersonSuper("김수현");
		p.disp();
		
		System.out.println();
		System.out.println("오버라이딩 name");
		
		
		PersonSub s= new PersonSub("박문수", 1.2, 1.2);
		s.disp();
		
	}// end main

}//class
