/*
 * Author: Administrator
 * Created: 2016년 1월 15일 금요일 오전 10:14:12
 * Modified: 2016년 1월 15일 금요일 오전 10:14:12
 */


class Test05
{
	public static void main(String args[])
	{
		
		
		double d1=100;//100이라는 정수가 a메모리에 할당되면서
		//double형으로 자동 형 변환이 된다.
		double d2 = 12.5f; //float 형이 double로 자동 변환된다.
		int a1='A'; // int형으로 자동 변환
		int a2= (int)12.5;
		
		double a3 =12.5;
		int a4 = (int)a3;
		double a5 = a4;
		
		System.out.println("d1 :"+d1); //double형으로 변환되어 출력된다.
		System.out.println("d2 :"+d2);
		System.out.println("a1 :"+a1);
		
		System.out.println("a2 :"+a2);
		System.out.println("a4 :"+a4);
		System.out.println("a5 :"+a5);
		
		
	}//main end
	
}//class end
