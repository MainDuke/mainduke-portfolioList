/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 2:46:58
 * Modified: 2016년 1월 18일 월요일 오후 2:46:58
 */

/*월(달)을 입력받아, 그달의 날 수 구하기.*/

import java.io.*;
class Test08_switch
{
	public static void main( String [] args ) throws IOException		
	{
		String monthstr;//월(달)을 입력 받아 저장.
		int month;//
		int days=0;// 날 입력 변수.
		
		
		BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
				//한글자씩  읽어서 버퍼에 저장.
				
		System.out.print("월 또는 달을 입력하세요.");
		monthstr = buff.readLine();//버퍼 내용을 읽는다.
		month=Integer.parseInt(monthstr); //문자열을 정수로 변환.
		
		
		switch(month){
		case 1:	case 3: case 5:	case 7:	case 8:	case 10: case 12:
			days=31;
			break;
		case 2:
			days= 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
		}//switch end
		
		System.out.println(month +"달은 "+days+"일 까지 있습니다.");
		
		
		
		
	}// end main
	
}//class end
