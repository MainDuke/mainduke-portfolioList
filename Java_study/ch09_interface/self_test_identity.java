/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오후 12:45:58
 * Modified: 2016년 1월 28일 목요일 오후 12:45:58
 */
class A{
			private int a;
			private int y;
			
	public void changeObjectNull(A a){
		System.out.println("A a 객체"+System.identityHashCode(a));
		a=null;
		System.out.println("A a=Null 객체"+System.identityHashCode(a));
	}//cg end
	
	public void changeNum(int a){//a 지역 변수
		System.out.println("int a 값 : "+a);
		a= 100;
		System.out.println("int a=100; 값 : "+a);
	}//cn end
}
	
	
class self_test_identity
{
	public static void changeMainObjectNull(A a){
		System.out.println("A a 객체: "+System.identityHashCode(a));
		a=null;
		System.out.println("A a  Null 객체: "+System.identityHashCode(a));

	}
	
	public static void main( String [] args ) 
	{
		A a= new A();
		int b=10;
		
		a.changeNum(b); //기본 자료형을 인수로.
		a.changeObjectNull(a); //클래스 객체를 인수로 전달.
		
		changeMainObjectNull(a); //같은 클래스내의 메서드 ㅎ출.
		
	}// end main
}//class end
