/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오후 3:28:05
 * Modified: 2016년 1월 26일 화요일 오후 3:28:05
 */

class GeneralRoom{
	int roomNo;//방번호.
	int capacity;//정원
}

class SpecialRoom extends GeneralRoom
{
	String owner;//집주인
	
	public void disp(){
		System.out.println("방번호: "+roomNo);
		System.out.println("정원: "+capacity);
		System.out.println("주인: "+owner);
	}//disp end
}//specialroom end

class Test06_extends
	{
		public static void main( String [] args ) 	{
			
			SpecialRoom sr=new SpecialRoom(); //객체생성
			
			sr.roomNo=3;
			sr.capacity=30;
			sr.owner="홍길동";
			sr.disp();
			
			
		}// end main
		
	}
	