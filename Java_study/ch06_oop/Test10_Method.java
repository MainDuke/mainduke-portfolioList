/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 4:16:27
 * Modified: 2016년 1월 22일 금요일 오후 4:16:27
 */

class SinSang{
//전역 변수 =클래스 변수
String name;
int age;
double ki;
//메서드 : 값을 셋팅하는 메서드
//this: 현재 클래스 객체를 뜻한다.
public void setData(String name, int age, double ki){
this.name=name;
this.age=age;
this.ki=ki;

}//setData end

public void disp(){
	
	System.out.println("이름 : "+this.name);
	System.out.println("나이 : "+this.age);
	System.out.println("키 : "+this.ki);
}// SinSang end

	
class Test10_Method
{
	public static void main( String [] args ) 
	{
		SinSang s=new SinSang(); // 객체 생성.
		s.setData("박문수", 21, 167.8);
		s.disp();
		
		SangPum sp=new SangPum(); // 객체 생성.
		sp.setData("상자", 20, 2500);
		sp.disp();
		
				
	}// end main

}//class end
