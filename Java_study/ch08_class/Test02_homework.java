/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오전 11:28:21
 * Modified: 2016년 1월 26일 화요일 오전 11:28:21
 */


/*
Test02_homework
주민번호를 입력 받아서 남자인지 여자인지 판정하여 출력하시오.
입력은 main(String [] args) 의 인수로 받는다.

if 또는 switch~case문 사용.

1남자
2여자
3남자
4여자

 */
import java.util.Scanner;

class Test02_homework
{
	public static void main( String [] args )
	{
		//		Integer.parseInt(args[0])
		//000000-0000000 (14자리)
		//01234567890123
		//0000000000000 (13자리)
		
		//if(args[0].length == ){
		
		System.out.print("주민등록 번호를 입력하시오.");
		Scanner scanner = new Scanner(System.in);
		String s1= scanner.nextLine();
		
		int a1=s1.length();
		
		//scanner를 이용해서 패널에서 인수를 받을수 있게 코딩했다.
		//그러나 main(String args[])로 받고 싶다면 아래와 같이 코딩을 한다.
		
		/*
		String s1=args[0];
		int a1 = s1.length();
		*/ 
		
		
		//s1 에 입력받은 문자열 개수를 a1에 넣어서 if문으로 판별한다.
		
		System.out.println();
		
		//문자열의 갯수를 파악하여, 각각. 다르게 값을 찾는다.
		
		if(a1 == 14){		
			
			String s2=s1.substring(7,8);
			int q1 = Integer.parseInt(s2);
			
			//14자리의 숫자를 받았을 경우, 7번째 문자를 정수형으로 변환하여 
			//그 값을 정확하게 판별한다.
			//equals() 를 이용하여 정수 변환없이 그냥 판별을 해도 된다.
			//s2.equals("?") 사용.
			
			if(q1 == 1){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}else if(q1 == 2){
				System.out.println(args[0]);
				System.out.println("여자입니다.");
			}
			else if(q1 == 3){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}
			else if(q1 == 4){
				System.out.println(args[0]);
				System.out.println("여자입니다.");
			}else{
				System.out.println("잘못된 주민등록 번호입니다.");
			}
		}else if(a1 == 13)
		{
			String s2=s1.substring(6,7);
			int q1 = Integer.parseInt(s2);
			
			if(q1 == 1){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}else if(q1 == 2){
				System.out.println(args[0]);
				System.out.println("여자입니다.");
			}
			else if(q1 == 3){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}
			else if(q1 == 4){
				System.out.println(args[0]);
				System.out.println("여자입니다.");
			}else{
				System.out.println("잘못된 주민등록 번호입니다.");
			}
		}
			else{//잘못된 번호를 입력 받았을 경우, 출력.
				System.out.println("잘못된 주민등록 번호입니다.");
				System.out.println("13자리 번호를 입력해주시거나");
				System.out.println("000000-0000000 '-'를 입력해서 14자리로 입력해주십시오.");
		}
			
			System.out.println();
		}// end main
		
}//class end
	