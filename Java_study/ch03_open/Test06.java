/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오전 10:11:00
 * Modified: 2016년 1월 18일 월요일 오전 10:11:00
 */

//2016.01.18 일 수업시작, CH03_Test06 내용 문자열 비교 연산자.

class Test06
{
	public static void main( String [] args ) 
	{
		
		String str="hello";
		System.out.println(str.equals("hello"));//true
		System.out.println(str.equals("Hello"));//false
		System.out.println(str.equalsIgnoreCase("Hello"));//true
		//equalsIgnoreCase 는 대소문자 구분 하지 않는다.
		System.out.println("==========================first end");
		
		//질문? 수식연산자로 스트링을 비교 할수 있는가?
		System.out.println(str==("hello"));//true
		System.out.println(str==("Hello"));//true
		
		//된다?... JPad 버전 업의 효과인가??
		
		System.out.println("==========================second end");
		
		String str2=new String("hello");
		System.out.println(str=="hello");//true
		System.out.println(str==("Hello"));//false
		System.out.println(str==str2);//false
		
		
		System.out.println("==========================3th end");
		
		String s1="hello"; //일반함수처럼 사용.
		String s2="hello"; //일반 함수처럼 사용.
		System.out.println("s1=s2?"+(s1==s2));//true
		
		System.out.println("==========================4th end");
		
		
		String s3 = new String("hello"); //객체 생성.
		String s4 = new String("hello"); //객체 생성.
		
		System.out.println("s3=s4?"+(s3==s4));//false
		//Why? 객체가 다르면 == 은 메모리 주소를 참조비교 한다. 그러므로 false가 나온다.
		
		
		System.out.println("==========================5th end");
		
		System.out.println("s3.equals(s4)? : "+(s3.equals(s4)));//false
		//Why? 그러나, equals()메서드는 문자열 자체를 비교하므로 객체가 달라도 True 판정을 받는다.
		
		System.out.println("==========================6th end");
		System.out.println("---Instanceof---");
		
		Object ob=new Object(); //Object는 최상위 클래스이다.
		String str5=new String("abc");
		System.out.println(ob instanceof Object);//true
		//                       ==  
		System.out.println(str5 instanceof String);//true
		//                          ==		
		System.out.println(str5 instanceof Object);//true
		//							<
		System.out.println(ob instanceof String);// false
		//							>
				/*
		System.out.println(str5 instanceof StringBuffer);// false
		아무 관계 없는 클래스는 비교 못함= 에러.
		 */
		
		
		
	}// end main
	
}
