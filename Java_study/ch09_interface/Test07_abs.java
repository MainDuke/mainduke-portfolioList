/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 11:17:59
 * Modified: 2016�� 1�� 28�� ����� ���� 11:17:59
 */

abstract class Abs{
	
	String name;//�ʵ�
	
	public Abs(String name){
	this.name= name;
	}
	public void disp(){
		System.out.println("�Ϲ� �޼��� disp() : "+name);
	}
	
	abstract public void kk(); //�߻� �޼���.
}//class end



class Test07_abs extends Abs{
	//������
	public Test07_abs(String name){
		super(name);
	}
	//�������̵�
	public void kk(){
		System.out.println("�߻� �޼��� �������̵� : "+name);
	}

	public static void main( String [] args ) 
	{
		Test07_abs test= new Test07_abs("ȫ�浿");
		test.kk();
		test.disp();
			
	}// end main
}	