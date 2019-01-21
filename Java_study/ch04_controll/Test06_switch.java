/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 2:17:40
 * Modified: 2016년 1월 18일 월요일 오후 2:17:40
 */

/*점수를 입력하여 학점 구하기.*/

class Test06_switch
{
	public static void main( String [] args ) 
	{
		int jum = Integer.parseInt(args[0]);
		char grade= ' '; //변수 초기화.
		
		
		
		switch(jum/10){
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade= 'F';
			}//switch end
		
		if(jum>100 || jum<0){
			System.out.println("0~100 사이만 입력하시오.");
		}
		else {
			System.out.println("점수 : "+jum+"  학점 : "+grade);
		}
		
	}// end main

}//class end
