/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 2:33:46
 * Modified: 2016�� 1�� 18�� ������ ���� 2:33:46
 */
//java.io.* �ϸ� java.io ��Ű������ ��� Ŭ������ �ش� class�� import �Ͽ� ���
import java.io.*;

class Test07_switch
{
public static void main( String [] args ) throws IOException	
{
		
		int x= 10;
		int y= 7;
		
		
		System.out.println("x = "+x+"  y = "+y);
		System.out.print("������(+ - * / % ) �� �ϳ��� �Է��Ͻÿ�.");
		
		char oper= (char)System.in.read(); // 1�� �б� (������ �б�.)
		
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
