/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 9:38:27
 * Modified: 2016�� 1�� 27�� ������ ���� 9:38:27
 */


//��� ����
//����Ŭ����.
class PersonSuper{
	
	protected String name;//�ʵ�
	
	public PersonSuper(String name){//������.
		this.name=name;
	}
	public void disp(){//�޼���
		System.out.println(name);
	}	
		
}//--class end-------------------

class PersonSub extends PersonSuper{
	
	private double left_eye;//���� �÷�
	private double right_eye;//������ �÷�
	
	//������.
	public PersonSub(String name, double left_eye, double right_eye)
	{
	super(name);
	this.left_eye=left_eye;
	this.right_eye=right_eye;
	}
	//�������̵�
	public void disp(){
		System.out.println("name: "+name);
		System.out.println("left_eye"+left_eye);
		System.out.println("right_eye"+right_eye);
	}	

}//------------class end

public class Test08_extends
{
	public static void main( String [] args )
	{
		
		PersonSuper p= new PersonSuper("�����");
		p.disp();
		
		System.out.println();
		System.out.println("�������̵� name");
		
		
		PersonSub s= new PersonSub("�ڹ���", 1.2, 1.2);
		s.disp();
		
	}// end main

}//class
