/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 4:36:13
 * Modified: 2016년 1월 22일 금요일 오후 4:36:13
 */
class SangPum
{
	//전역 변수 =클래스 변수
	String pum;
	int su;
	double dan;
	
	//메서드 : 값 셋팅 하는 메서드
	public void setData(String pum, int su, int dan){
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}//setData end.
	
	public void disp(){
		
		
		System.out.println("상품명 : "+this.pum);
		System.out.println("수량 : "+this.su);
		System.out.println("단가 : "+this.dan);
		System.out.println("금액 : "+(su*dan)+"원\n");	
	}
	
}//SangPum end
class Test11_Method
{
	public static void main( String [] args ) 
	{	
	SangPum sp=new SangPum(); // 객체 생성.
	sp.setData("상자", 20, 2500);
	sp.disp();
	}
}// class
	