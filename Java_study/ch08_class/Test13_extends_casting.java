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


class Test13_extends_casting
{
	public static void main( String [] args )
	{
		SuperTest s= new SuperTest();
		s.disp();
		System.out.println("-----");
		
		
		s= new SubTest(); //���� Ŭ���� ������ ������ü ó�� //upcasting
		System.out.println("-----");
		s.disp(); //double d=100; //�ڵ� �� ��ȯ.
		System.out.println("-----");
		s.pp();
		System.out.println("-----");
		((SubTest)s).kk(); //Ŭ���� ĳ����.
		//int a=(int)12.5; //���� �� ��ȯ.
		
		System.out.println("-----");
		System.out.println("test");
		
		SubTest s2= new SubTest();
		s2.disp();
		s2.kk();
		
		
	}// end main

}//class
