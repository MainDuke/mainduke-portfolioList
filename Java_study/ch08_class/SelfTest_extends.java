/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 2:33:39
 * Modified: 2016�� 1�� 27�� ������ ���� 2:33:39
 */

//cf) int a=(int)12.5; // casting

class SuperTest{
	public void disp(){
		System.out.println("super dispŬ����");
	}
	public void pp(){
		System.out.println("super Ŭ���� pp()");
	}
	
}//class end --
class SubTest extends SuperTest{
	//�������̵�
	public void disp(){
		System.out.println("sub Ŭ���� disp");
	}
	public void kk(){
		System.out.println("sub Ŭ���� kk()");
	}
	
}//class end ---------------


class SelfTest_extends
{
	public static void main( String [] args )
	{
		System.out.println("test");
		
		SubTest s= new SubTest();
		s.disp();
		System.out.println("-----");
		
		s= ((SubTest)(new SuperTest())); 
		s.pp(); //double d=100; //�ڵ� �� ��ȯ.
		System.out.println("test");
		
		
		
	}// end main
	
}//class