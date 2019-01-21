//equals() 사용해서 풀어봄.


import java.util.Scanner;

class Test02_homework_02
{
	public static void main( String [] args )
	{
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
		//문자열의 갯수를 파악하여, 각각. 다르게 값을 찾는다.
		
		System.out.println();
		
		if(a1 == 14){		
			
			String s2=s1.substring(7,8);
			
			//14자리의 숫자를 받았을 경우, 7번째 문자를 정수형으로 변환하여 
			//그 값을 정확하게 판별한다.
			//equals() 를 이용하여 정수 변환없이 그냥 판별을 해도 된다.
			//s2.equals("?") 사용.
			
			if(s2.equals("1") || s2.equals("3")){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}else if(s2.equals("2") || s2.equals("4")){
				System.out.println(args[0]);
				System.out.println("여자입니다.");
			}else{
				System.out.println("잘못된 주민등록 번호입니다.");
			}
		}else if(a1 == 13)
		{
			String s2=s1.substring(6,7);
			
			if(s2.equals("1") || s2.equals("3")){
				System.out.println(args[0]);
				System.out.println("남자입니다.");
			}else if(s2.equals("2") || s2.equals("4")){
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
