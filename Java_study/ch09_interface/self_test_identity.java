/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 12:45:58
 * Modified: 2016�� 1�� 28�� ����� ���� 12:45:58
 */
class A{
			private int a;
			private int y;
			
	public void changeObjectNull(A a){
		System.out.println("A a ��ü"+System.identityHashCode(a));
		a=null;
		System.out.println("A a=Null ��ü"+System.identityHashCode(a));
	}//cg end
	
	public void changeNum(int a){//a ���� ����
		System.out.println("int a �� : "+a);
		a= 100;
		System.out.println("int a=100; �� : "+a);
	}//cn end
}
	
	
class self_test_identity
{
	public static void changeMainObjectNull(A a){
		System.out.println("A a ��ü: "+System.identityHashCode(a));
		a=null;
		System.out.println("A a  Null ��ü: "+System.identityHashCode(a));

	}
	
	public static void main( String [] args ) 
	{
		A a= new A();
		int b=10;
		
		a.changeNum(b); //�⺻ �ڷ����� �μ���.
		a.changeObjectNull(a); //Ŭ���� ��ü�� �μ��� ����.
		
		changeMainObjectNull(a); //���� Ŭ�������� �޼��� ����.
		
	}// end main
}//class end
