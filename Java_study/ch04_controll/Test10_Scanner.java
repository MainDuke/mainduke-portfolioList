/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 3:37:11
 * Modified: 2016년 1월 18일 월요일 오후 3:37:11
 */

import java.util.Scanner;
class Test10_Scanner
{ public static void main( String [] args ) 
	{
		//Scanner 라는 입력 유틸이 생겼음. 자바 5버전부터 생김.
		System.out.print("이름을 입력하시오.");
		Scanner scanner = new Scanner(System.in);
		String name= scanner.nextLine();
				
		System.out.print("나이를 입력하시오.");
		Scanner scanner2 = new Scanner(System.in);
		int age= scanner2.nextInt();
		
		System.out.print("키를 입력하시오.");
		Scanner scanner3 = new Scanner(System.in);
		double height= scanner3.nextDouble();
		
		//printf
		System.out.printf("%s %d %7.1f\n",name, age, height);	//%s는 문자열 출력.
		//%d 는 정수 출력.
		//%f는 실수 출력.
		//%7.1f 전체 자리수. 소수이하자리수f
			
}// end main

}//class end