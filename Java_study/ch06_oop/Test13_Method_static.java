/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 9:42:15
 * Modified: 2016�� 1�� 25�� ������ ���� 9:42:15
 */
//static �޼���� static���� ����� ����, �޼��常 ȣ�� ����.
//Math.max(5,2) => static���� ����� �޼���� ��ü �����ʰ� ȣ�Ⱑ��.
//Ŭ����.�޼���();

//-static ������ ��� ��ü�� �׸� ���� �Ҽ� �ִ�.
class Test13_Method_static
{
	static int a = 100;
	
	public static void aa(){

		System.out.println("aa() call");
		
	}//class end.
	
	public static void bb(){
		System.out.println("bb() call");
		
	}
	
	
	public static void main( String [] args )
	{
	
		aa();//static ���� ��ü ���� �ʰ� ȣ�Ⱑ��.
		System.out.println();		
		
		
	}// end main

}
