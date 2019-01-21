/*
 * Author: Administrator
 * Created: 2016년 1월 14일 목요일 오후 5:37:02
 * Modified: 2016년 1월 14일 목요일 오후 5:37:02
 */


class Test03
{ //10진 2진 8진 16진
	public static void main(String args[])
	{
		int a=10;
		System.out.println("10진:"+a);
		System.out.println("2진:"+Integer.toString(a,2));
		System.out.println("8진:"+Integer.toString(a,8));
		System.out.println("16진:"+Integer.toString(a,16));
		
		//============================
		//최대값 최소값.
		//===========================
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
	}//main end
	
}//class end

