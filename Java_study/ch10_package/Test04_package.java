/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오후 5:09:31
 * Modified: 2016년 1월 28일 목요일 오후 5:09:31
 */
import hong.kil.dong.*;

class Test04_package
{
	//변수 선언
	CalcTest t1;
	CalcTest2 t2;			
	//생성자
	public Test04_package(){
	t1 = new CalcTest();
	t2 = new CalcTest2();	
	
	t1.hab(3, 5);
	t2.cha(7, 5);
	}
	//
	
	public static void main( String [] args ) 
	{
		new Test04_package();
		
	}// end main

}//class end
