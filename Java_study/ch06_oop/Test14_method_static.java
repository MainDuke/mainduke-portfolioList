/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 9:51:08
 * Modified: 2016년 1월 25일 월요일 오전 9:51:08
 */
//static 메서드는 static으로 선언된 변수, 메서드만 호출 가능.
class SinSang2{

	//전역 변수: 자동으로 초기화 된다.
	String name; //null

	int nai;//0
	String imsi;
	static int sungin=18;
		
		//생성자:리턴형 없음, 클래스 이름과 같은 이름.
		
	public SinSang2(){
		this.name=name;
		this.nai=nai;
		
	
	}//생성자 end.
		
//메서드.
		public void setData(String name, int nai)
		{
			
			String imsi;//지역변수
			if(sungin<nai){
				imsi="성인";
			}else{
				imsi="미성년자";
			}
			System.out.println(name+"---"+nai+"---"+imsi);
		
		
		}
		
		public void disp(){
			System.out.println(name+"---"+nai+"---"+imsi);
		}
		
	
	}//class end


class Test14_method_static
{
	public static void main( String [] args ) 
	{
		SinSang2 s1 = new SinSang2();//객체 생성.
		SinSang2 s2 = new SinSang2();//객체 생성.
		SinSang2 s3 = new SinSang2();//객체 생성.

		s1.setData("홍길동", 17);
		s2.setData("송혜교", 31);
		s3.setData("유승호", 25);
		s1.disp();
		s2.disp();
		s3.disp();
	}// end main

}//class end
