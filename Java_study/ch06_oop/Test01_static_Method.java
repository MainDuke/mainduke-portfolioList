/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 4:38:20
 * Modified: 2016�� 1�� 21�� ����� ���� 4:38:20
 */


//Math.�޼���() : Math Ŭ���� �ȿ� �ִ� ��� �޼���� static Method �̴�.
//static Method �ǽ�.


//static �޼��� ��� : Ŭ���� �̸�.�޼���()
//						Math.abs(12)

class Test01_static_Method
{
	public static void main( String [] args )
	{
		System.out.println(Math.abs(-7)); //7 ���밪.
		System.out.println(Math.max(5,3)); //ū��.
		System.out.println(Math.min(5,3)); //������.
		System.out.println(Math.max(5.1,35.7)); //ū��.
		System.out.println(Math.min(5.1f,35.7f)); //������.
		
		System.out.println(Math.ceil(5.1)); //�ø���.
		System.out.println(Math.floor(5.3)); //������.
		System.out.println(Math.round(6.4)); //������6, �ݿø�.
		System.out.println(Math.round(6.5)); //������6, �ݿø�.
		
		System.out.println(Math.PI);
		System.out.println(Math.pow(2,10));
		
		
	}// end main

}//class end
