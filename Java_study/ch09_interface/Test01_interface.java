/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 4:46:44
 * Modified: 2016�� 1�� 27�� ������ ���� 4:46:44
 */

//interface
//

interface AA{

	int a = 100; //final static int a=100; �� ����.
	public void aa();//�߻� �޼���.
	
}
class Test01_interface implements AA
{
	//���� ���̵�.
	public void aa(){
		System.out.println("aa()...call");
	}//aa end
	
	public static void main( String [] args )
	{
		Test01_interface test= new Test01_interface();
		test.aa();
		
	}// end main

}//class end
