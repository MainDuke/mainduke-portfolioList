/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오후 3:45:24
 * Modified: 2016년 1월 25일 월요일 오후 3:45:24
 */


//this() : 자신의 클래스 내의 생성자 호출.
//			인수 타입이 맞는 생성자 호출.

class PanMeaSub{
	
	//1.디폴트 생성자.
	public PanMeaSub(){
		System.out.println("디폴트 생성자 호출");
	};
	
	//2. 인자 있는 생성자.
	public PanMeaSub(String p){
		this(p, 123);
		System.out.println("생성자2 호출");
		
	}
	//3. 인자 있는 생성자
	public PanMeaSub(String p, int s){
		this(p, 123, 3000);
		
		System.out.println("생성자3 호출");
		
	}
	//4. 인자 있는 생성자.
	public PanMeaSub(String p,int s, int d){
		
		System.out.println("생성자4 호출");
		
		
		
		System.out.println(p+"---"+s+"---"+d);
		
		
	}
	
	
	
}//class

class Test04_this
{
	public static void main( String [] args ) 
	{
		new PanMeaSub("딸기");//2번 생성자 호출.	
		
		new PanMeaSub();	
		
		
		
		
		
		
	}// end main
	
}//class
