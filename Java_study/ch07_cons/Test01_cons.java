/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 11:35:25
 * Modified: 2016년 1월 25일 월요일 오전 11:35:25
 */

//생성자 예시.

class Sung{
	String name;//null, 전역 변수 자동 초기화.
	int kor; //0
	
	//1.디폴트 생성자.
	public Sung(){//디폴트 생성자.
					//생성자를 넣지 않으면,
					//디폴트 생성자가 자동으로 생성 된다.
					//인자 있는 생성자가 있을때는,
					//디폴트 생성자는 생성되지 않는다.
	
				//name="";
				kor=0;
				System.out.println("디폴트 생성자 호출");
			}
					
	public Sung(String name, int kor){
		this.name=name;
		this.kor=kor;
		
		System.out.println("인자1 생성자 호출");
				
	}//인자가 있는 생성자.
	
	public Sung(int kor, String name){
		
		this.name=name;
		this.kor=kor;
		
		System.out.println("인자2 생성자 호출");
	}
	
	public void disp(){
		System.out.println(name+"---"+kor);
	}	
	
					
}//class end

class Test01_cons
{
	public static void main( String [] args ) 
	{
		Sung s1=new Sung();//디폴트 생성자.
		Sung s2= new Sung("홍길동", 12);
		Sung s3= new Sung(21, "송혜교");
		
		System.out.println();
		
		s1.disp(); // null 0
		s2.disp(); // 홍길동. 12
		s3.disp(); //  송혜교 , 21
	}// end main

}//class end.
