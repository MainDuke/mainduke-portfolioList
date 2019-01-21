/*
 * Author: Administrator
 * Created: 2016년 1월 25일 월요일 오전 11:24:51
 * Modified: 2016년 1월 25일 월요일 오전 11:24:51
 */

class Demo1{
	
	int a;
	int b;
	
	public void aa(){
	
		a++;
		b++;
		
		System.out.println("호출전 : "+(a+b));
		
		System.out.println("생성자 호출후 : "+(a+b));
		
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
