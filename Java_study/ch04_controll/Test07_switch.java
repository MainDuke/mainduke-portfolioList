/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 2:33:46
 * Modified: 2016년 1월 18일 월요일 오후 2:33:46
 */
//java.io.* 하면 java.io 패키지내의 모든 클래스를 해당 class에 import 하여 사용
import java.io.*;

class Test07_switch
{
public static void main( String [] args ) throws IOException	
{
		
		int x= 10;
		int y= 7;
		
		
		System.out.println("x = "+x+"  y = "+y);
		System.out.print("연산자(+ - * / % ) 중 하나를 입력하시오.");
		
		char oper= (char)System.in.read(); // 1자 읽기 (연산자 읽기.)
		
		switch(oper){
		
		case '+':
			System.out.println("x+y="+(x+y));
			break;
		case '-':
			System.out.println("x-y="+(x-y));
			break;
		case '*':
			System.out.println("x*y="+(x*y));
			break;
		case '/':
			System.out.println("x/y="+(x/y));
			break;
		case '%':
			System.out.println("x%y="+(x%y));
			break;
					
			
		}//switch-end
		
		
	}// end main

}
