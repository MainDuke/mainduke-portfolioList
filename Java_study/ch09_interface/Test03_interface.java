/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 9:38:09
 * Modified: 2016�� 1�� 28�� ����� ���� 9:38:09
 */

//�������̽�.

interface AA3{
	int aa(); //�������̽� �޼���� �����Ͽ��� public �̴�.
}//AA3 end
class BB3 implements AA3{
	//�������̵�, �������̽� ����� ��� �޼��带 �������̵� �ؾ��Ѵ�.
	public int aa(){
		System.out.println("BB3.aa()....");
		return 100;
	}//method.aa() end	
}//BB3 end

class CC3 implements AA3
{
	public int aa(){
		System.out.println("CC3.aa()....");
		
	return 200;
	}//aa();
}//CC3 end

class Test03_interface
{
	public static void main(String args[]){
		System.out.println(new BB3().aa());
		
		System.out.println();
		System.out.println(new CC3().aa());
		
		
	}//main end
	
}//class end
