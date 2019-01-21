/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 10:25:24
 * Modified: 2016년 1월 25일 월요일 오전 10:25:24
 */

//static 메서드는 static으로 선언된 변수, 메서드만 호출 가능.
//Math.max(5,2) => static으로 선언된 메서드는 객체 생성않고도 호출가능.
//클래스.메서드();

//-static 변수는 모든 객체가 그를 공유 할수 있다.



//잘못된 예제. 모든 객체가 static dan,su, 를 쓰므로 인수값이 같아져 버린다.
class SangPum2{
	//전역변수: 자동으로 초기화 됩니다.
	
	String pum;//품명.
	int su;
	/*static*/ int dan;//단가. // static 을 지우면 정상으로 출력된다.
	
	
	//생성자 : 클래스 이름과 같은 이름, 리턴형 없음.
	
public SangPum2(){}

//메서드
public void setData(String p, int s, int d){
pum=p;
su=s;
dan=d;
}//setData end
public void disp()
{
	System.out.println(pum+"---"+su+"---"+dan);
}
}

class Test15_Method_static
{
public static void main( String [] args ) 	
{

	SangPum2 s1,s2,s3;//int a,b,c
	s1= new SangPum2();//a=10;
	s2= new SangPum2();//b=20;
	s3= new SangPum2();//c=30;

	s1.setData("사과",3,1500);
	s2.setData("배",5,2000);
	s3.setData("포도",6,3000);
	
	s1.disp();
	s2.disp();
	s3.disp();
	
	
	
}// end main

}//class
