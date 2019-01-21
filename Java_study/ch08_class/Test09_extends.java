/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오전 10:19:33
 * Modified: 2016년 1월 27일 수요일 오전 10:19:33
 */

class SungJuk{

	protected String name;
	protected int kor;
	protected int eng;

	//생성자.
	public SungJuk(){}
	public SungJuk(String name, int kor, int eng){
	
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	
	}//생성자 end
	//메서드
	public void disp(){
	
		System.out.println(name+"---"+kor+"---"+eng);
	}//method end
}//-----SungJuk end

//파생클래스 작성.
class SungJukSub extends SungJuk
{
	//필드 super();
	private int tot;
	private double avg;
	
	public SungJukSub(String name, int kor, int eng){
		super(name, kor, eng);
		tot=kor+eng;
			avg=tot/2;
	}
	//오버라이딩.
	public void disp(){
		System.out.println(name+"---"+kor+"---"+eng+"---"+tot+"---"+avg);
	}
}//-----sub end

class Test09_extends
{
	public static void main(String args[]){
	
	SungJukSub su=new SungJukSub("Hcm", 77, 88);
	
	su.disp();
	}//main end

}//class end
