/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오후 4:38:20
 * Modified: 2016년 1월 21일 목요일 오후 4:38:20
 */


//Math.메서드() : Math 클래스 안에 있는 모든 메서드는 static Method 이다.
//static Method 실습.


//static 메서드 사용 : 클래스 이름.메서드()
//						Math.abs(12)

class Test01_static_Method
{
	public static void main( String [] args )
	{
		System.out.println(Math.abs(-7)); //7 절대값.
		System.out.println(Math.max(5,3)); //큰값.
		System.out.println(Math.min(5,3)); //작은값.
		System.out.println(Math.max(5.1,35.7)); //큰값.
		System.out.println(Math.min(5.1f,35.7f)); //작은값.
		
		System.out.println(Math.ceil(5.1)); //올림값.
		System.out.println(Math.floor(5.3)); //내림값.
		System.out.println(Math.round(6.4)); //사사오입6, 반올림.
		System.out.println(Math.round(6.5)); //사사오입6, 반올림.
		
		System.out.println(Math.PI);
		System.out.println(Math.pow(2,10));
		
		
	}// end main

}//class end
