/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 10:17:27
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 10:17:27
 */

//�ϳ� �̻��� Ŭ������ ������ Ŭ���� ����ü �̴�.
//����� �̸��� main()�� �Ҽ��� �ִ� Ŭ������ �����Ѵ�.
//�ǽ� �޼���.


class Demo02{
	public void aa(){
	System.out.println("aa() call");
	}
	public void bb(){
		System.out.println("bb() call");
	}	
}

//Ŭ������ ����Ϸ��� ��ü�� �����ؾ��Ѵ�.
class Test02_oop
{
	public static void main( String [] args ) 
	{
		
		// int a= 10; �⺻ �ڷ��� ����
		//Ŭ��������=�ν��Ͻ�=���۷���=��ü
		
		Demo02 d1 = new Demo02(); //��ü ����
		//Ŭ������ ����Ϸ��� ��ü�� �����ؾ��Ѵ�.
		
		//��ü.�޼���()
		d1.aa(); //��ü�� ȣ���Ѵ�.
		d1.bb();
				
	}// end main

}//class end
