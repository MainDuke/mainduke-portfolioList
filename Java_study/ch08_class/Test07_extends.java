/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오후 3:36:32
 * Modified: 2016년 1월 26일 화요일 오후 3:36:32
 */

class PanMae{
	
	//private String pum; //private 선언된 변수는 자신의 클래스 내에서만 사용 가능하다.
	//private int su;
	//private int dan;
	
	
	//protected는 super클래스와 파생(하위)에서만 접근 가능합니다.
	protected String pum; //품명
	protected int su; 
	protected int dan;
	
	public PanMae(String pum, int su, int dan){
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}	
	public void disp(){//오버 라이딩 : 상속 받은 메서드 내용 재정의.
		System.out.println(pum + "---" + su + "---" + dan);
		
	}//disp
}//--class


//생성자
class SalePanMae7 extends PanMae{
	
	protected double rate;//할인율, 변수
	
	public SalePanMae7(String pum, int su, int dan, double rate)
	{
		super(pum, su, dan);
		this.rate=rate;
	}//slaepanmae
		
public void disp(){//오버 라이딩 : 상속 받은 메서드 내용 재정의.
	System.out.println(pum + "---" + su + "---" + dan);
	System.out.println("할인율:"+rate);
}//disp

}


class Test07_extends
{
	public static void main( String [] args ) 
	{
		PanMae a= new PanMae("사과", 7, 1000);
		a.disp();
		System.out.println();
		
		SalePanMae7 b= new SalePanMae7("참외", 10, 1000, 0.02);
		
		b.disp();
		
	}// end main
	
}//class end
