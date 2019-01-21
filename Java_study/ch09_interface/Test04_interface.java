/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 9:49:22
 * Modified: 2016년 1월 28일 목요일 오전 9:49:22
 */

//인터페이스
//객체 instanceof 클래스 또는 인터페이스
//			= true
//			< true
//			> false
//상속 관계가 아닌경우는 비교할수 없다. (서로 무관한 객체는 비교할수 없다.)
	

interface AA4{
	int a=10; //final static int =10; 이다.
	int aa();//추상 메서드
}
interface BB4 extends AA4{
	double d= 33.4;
	double dd(); //추상 메서드.
}
interface CC4 extends BB4{
	String name="홍길동";
	String irum();
}




class Test04_interface implements CC4
{
	//인터페이스를 상속 받으면,반드시 하위에서 모든 메서드를 오버라이딩 해야한다.
	public int aa(){
		return 20;
	}
	
	public double dd(){
	return 10.5;
	}
	public String irum(){
		return "CM";
	}
	
 	public static void main( String [] args )
		{
			//CC4한테 Test04_interface 가 상속 받았다.
			CC4 test=new Test04_interface(); //상위 클래스 변수로 하위 클래스 처리.
			
			if(test instanceof AA4){
				System.out.println(test.a); //필드값 출력.
				System.out.println(test.d);
				System.out.println(test.name);
				//test.a=300; 필드값 수정 못함. final static 이니깐!
			
				System.out.println(test.aa()); //필드값 출력.
				System.out.println(test.dd());
				System.out.println(test.irum());
			}
					
		}// end main

	}//class end
