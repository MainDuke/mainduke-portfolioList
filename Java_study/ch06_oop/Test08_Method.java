/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 2:15:56
 * Modified: 2016년 1월 22일 금요일 오후 2:15:56
 */

//오버로드~ 메서드 중복.
class Demo08{
	public double sum(double a, double b){
		System.out.println("sum(double a, duoble b) 호출 했음.");
		
		return a+b;
	}//sum end
	
	public float sum(float a, float b){
		System.out.println("sum(float a, float b) 호출 했음.");
		
		return a+b;
	}//sum end
	
	//자료형은 연산시 자동형 변환이 큰쪽으로 자동형변환이 된다.
	public double sum(double a, double b ,double c){
		//1~end 합 구하기.
		System.out.println("sum(double a, duoble b, double c) 호출 했음.");
		return a+b+c;
	}//sum end
	
	
	
} // Demo06 end
class Test08_Method
{
	public static void main( String [] args ) 
	{
		Demo08 d8=new Demo08();
		
		double a = d8.sum(1.1,2.3);
		double b = d8.sum(1.1,2.3,5.7);
		float c = d8.sum(1.2f , 5.7f);
		double d= d8.sum(5.6 , 5.3f);
						
		
		System.out.println();
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.printf("c : %5.2f ", c);
		System.out.println();
		System.out.printf("d : %5.2f ", d);
		System.out.println();
		System.out.println();
		
	}// end main

}//class end
