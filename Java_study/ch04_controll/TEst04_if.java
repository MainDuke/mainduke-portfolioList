/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 12:02:35
 * Modified: 2016년 1월 18일 월요일 오후 12:02:35
 */

/*다중 if문
점수를 입력 받아서 학점 구하기
90~100:'A'
90~80: 'B'
80~70: 'C'
70~60: 'D'
59~0 : 'F'
 */

class TEst04_if
{
	public static void main( String [] args ) 
	{
		int jum = Integer.parseInt(args[0]);
		char grade=' '; //초기화. 학점 결과.
		
		if(jum <=100 && jum >=90)
		{
			grade='A';
		}else if(jum<90 && jum>=80)
		{
			grade='B';
		}
		else if(jum<80 && jum>=70)
		{
			grade='C';
		}
		else if(jum<70 && jum>=60)
		{
			grade='D';
		}
		else if(jum<60 && jum>=0)
		{
			grade='F';
		}
		else{
			System.out.println("점수 입력 오류");
		}
		
		//~~
		if(grade == ' '){
			System.out.println("점수는 0~100 사이만 입력 하시오.");
		}else{
			System.out.println("점수 :"+jum+" 학점 :"+grade);
		}
		
		
		
	}// end main
	
}//class
