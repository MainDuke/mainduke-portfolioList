/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오전 10:42:00
 * Modified: 2016년 1월 27일 수요일 오전 10:42:00
 */

class SungSinSuper{
	protected String name;
	
	public SungSinSuper(String name){
	
		this.name=name;
	}//생성자 end
	public void disp(){
	System.out.println(name);
}//method end
}//class end

class SungSub extends SungSinSuper{
	private int kor;
	private int eng;
	private int tot;
	
	public SungSub(String name, int kor, int eng)
	{
		super(name);
		this.kor=kor;
		this.eng=eng;
		this.tot=kor+eng;
	}//생성자 end
	public void disp(){
	System.out.println("이름"+"---"+"국어"+"---"+"영어"+"---"+"합계");	
	System.out.println(name+"---"+kor+"---"+eng+"---"+tot);
}//method end
}//class end

class SinSub extends SungSinSuper{
	private int nai;
	private String addr;
	public SinSub(String name, int nai, String addr){
		super(name);
		this.nai=nai;
		this.addr=addr;
	}
	public void disp(){
		
	System.out.println("이름"+"---"+"나이"+"---"+"주소");
	System.out.println(name+"---"+nai+"---"+addr);
}//disp end
}//class end
			
		
class Test10_exetends
{
	public static void main(String args[]){
	SungSub s1=new SungSub("창민", 88, 99);
	SinSub s2=new SinSub("창민", 29, "경기도");
	
	s1.disp();
	System.out.println();
	s2.disp();
}//main end

}//class end
