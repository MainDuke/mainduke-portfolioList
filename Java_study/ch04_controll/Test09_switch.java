/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 3:18:43
 * Modified: 2016년 1월 18일 월요일 오후 3:18:43
 */


//향상된 입력기능 : java.util.Scanner 클래스을 사용.

import java.util.Scanner;

class Test09_switch
{
	public static void main( String [] args ) 
	{
		//Scanner 라는 입력 유틸이 생겼음. 자바 5버전부터 생김.
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력 하시오.");
		int month=scanner.nextInt();
		
		int days=0;
		
		switch(month)
		{
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days=31;
			break;
		case 2:
			days=28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
		
		}
		System.out.println(month +"달은 "+days+"일 까지 있습니다.");
		
		
		
	}// end main

}//class end
