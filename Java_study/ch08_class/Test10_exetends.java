/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 10:42:00
 * Modified: 2016�� 1�� 27�� ������ ���� 10:42:00
 */

class SungSinSuper{
	protected String name;
	
	public SungSinSuper(String name){
	
		this.name=name;
	}//������ end
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
	}//������ end
	public void disp(){
	System.out.println("�̸�"+"---"+"����"+"---"+"����"+"---"+"�հ�");	
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
		
	System.out.println("�̸�"+"---"+"����"+"---"+"�ּ�");
	System.out.println(name+"---"+nai+"---"+addr);
}//disp end
}//class end
			
		
class Test10_exetends
{
	public static void main(String args[]){
	SungSub s1=new SungSub("â��", 88, 99);
	SinSub s2=new SinSub("â��", 29, "��⵵");
	
	s1.disp();
	System.out.println();
	s2.disp();
}//main end

}//class end
