/*
 * Author: Administrator
 * Created: 2016년 1월 15일 금요일 오후 4:11:55
 * Modified: 2016년 1월 15일 금요일 오후 4:11:55
 */


//대입 연산자
//= += -= *= /= %=




class Test05
{
	public static void main( String [] args ) 
	{
		
		int x, y;
		x=5;
		y=2;
		
		
		//착각하기 쉬운 변수값의 변화를 일일히 확이하면서 연산자에 대해서 이해하기 위해 설계.
		System.out.println("x+=Y :"+(x+=y));
		
		System.out.println("x1 :"+x);
		System.out.println("y1 :"+y);
		
		
		System.out.println("x-=Y :"+(x-=y));
		System.out.println("x2 :"+x);
		System.out.println("y2 :"+y);		
		
		
		System.out.println("x*=Y :"+(x*=y));
		
		System.out.println("x3 :"+x);
		System.out.println("y3 :"+y);
		
		System.out.println("x/=Y :"+(x/=y));
		
		System.out.println("x4 :"+x);
		System.out.println("y4 :"+y);
		
		System.out.println("x%=Y :"+(x%=y));
		
		System.out.println("x5 :"+x);
		System.out.println("y5 :"+y);
		
		
		System.out.println("-----------------------------------");
		
		//조건 연산자.
		System.out.println(5>3?5:3);
		System.out.println(5<3?5:3);
		
		int a=10, b=5;
		int c=(a>b)?a:b;
		System.out.println("c:"+c);
		
		
		
		
	}// end main
	
}//class end
