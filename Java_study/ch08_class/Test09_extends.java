/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 10:19:33
 * Modified: 2016�� 1�� 27�� ������ ���� 10:19:33
 */

class SungJuk{

	protected String name;
	protected int kor;
	protected int eng;

	//������.
	public SungJuk(){}
	public SungJuk(String name, int kor, int eng){
	
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	
	}//������ end
	//�޼���
	public void disp(){
	
		System.out.println(name+"---"+kor+"---"+eng);
	}//method end
}//-----SungJuk end

//�Ļ�Ŭ���� �ۼ�.
class SungJukSub extends SungJuk
{
	//�ʵ� super();
	private int tot;
	private double avg;
	
	public SungJukSub(String name, int kor, int eng){
		super(name, kor, eng);
		tot=kor+eng;
			avg=tot/2;
	}
	//�������̵�.
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
