/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 10:46:58
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 10:46:58
 */

/*String substring(int start, int end)
=>���� ���ڿ� ��ü���� start��ġ���� end��������
 ���ڿ� ����.

int indexOf(int ch)
	���� ���ڿ� ��ü���� ����ch��ġ�� ��ȯ(return)�Ѵ�.

int indexOf(String s)
=> ���繮�ڿ� ��ü���� ���ڿ�s�� ã�Ƽ�
	���ڿ��� ������ ù��° ���� ��ġ�� ��ȯ�ϰ�
	������ -1�� ��ȯ�Ѵ�.

*/

class Test01_class
{
	public static void main( String [] args ) 
	{
		String s1="GoodMornig-kildong";
		//		   01234567890123456789
		String s2=s1.substring(11);
		String s3=s1.substring(4,10);
		
		System.out.println("s2:"+s2); //kildong
		System.out.println("s3:"+s3); //Morinig
		
		String a1="�� ����� $45.67";
		int i1=a1.indexOf('$');//$��ġ�� ���Ѵ�.
		String a2=a1.substring(i1); //i1��ġ���� ������ ���ڿ��� ����.
		
		System.out.println("i1:"+i1);
		System.out.println("a2:"+a2);//$45.67
		
		int i2=a1.indexOf("$45.67");
		String a3= a1.substring(i2);
		System.out.println("i2:"+i2);
		System.out.println("a3:"+a3);
	
	
	}// end main

}//class end
