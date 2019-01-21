/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오전 10:28:05
 * Modified: 2016년 1월 22일 금요일 오전 10:28:05
 */

class Demo03
{
	public int aa()
	{
		System.out.println("aa() call");
		return 100;		
	}//aa()end
	
	public double bb()
	{
		System.out.println("bb() call");
		return 12.7;		
	}//bb()end
	public char ch()
	{
		System.out.println("ch() call");
		return 'A';		
	}//ch()end
	public String disp()
	{
		System.out.println("disp() call");
		return "홍길동";		
	}//disp()end
	
	
	
	

}//Demo03 class end



class Test03_Method
{
	public static void main( String [] args )
	{
		Demo03 d3 = new Demo03();
		
		int a=d3.aa();
		double b=d3.bb();
		char ch = d3.ch();
		String disp = d3.disp();
		
		System.out.println();
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.println("ch : "+ch);
		System.out.println("disp : "+disp);
		System.out.println();
		
		System.out.println("aa()리턴값 출력) : "+d3.aa());
		
		System.out.println();
		
		
		
	}// end main

}//class end
