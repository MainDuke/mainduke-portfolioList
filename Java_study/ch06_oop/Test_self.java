/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 11:24:51
 * Modified: 2016�� 1�� 25�� ������ ���� 11:24:51
 */

class Demo1{
	
	int a;
	int b;
	
	public void aa(){
	
		a++;
		b++;
		
		System.out.println("ȣ���� : "+(a+b));
		
		System.out.println("������ ȣ���� : "+(a+b));
		
	}//aa() end
		
}//Demo1 end.
class Test_self
{
	public static void main( String [] args ) 
	{
		
		Demo1 d1;	
		d1 = new Demo1();
		
		d1.aa();
		
		
	}// end main
	
}//class end.
