/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오후 4:46:44
 * Modified: 2016년 1월 27일 수요일 오후 4:46:44
 */

//interface
//

interface AA{

	int a = 100; //final static int a=100; 와 같다.
	public void aa();//추상 메서드.
	
}
class Test01_interface implements AA
{
	//오버 라이딩.
	public void aa(){
		System.out.println("aa()...call");
	}//aa end
	
	public static void main( String [] args )
	{
		Test01_interface test= new Test01_interface();
		test.aa();
		
	}// end main

}//class end
