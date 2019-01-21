/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 4:25:34
 * Modified: 2016년 1월 18일 월요일 오후 4:25:34
 */

//for(초기치;조건(최종치);증감치){
//반복처리할 내용;
//}


class Test01_for
{
	public static void main(String args[])
	{//1.good 5번 출력.
		for(int i=1; i<=5; i++){
			System.out.println("good");
		}
		System.out.println(); // line skip= 줄바꿈.
		
		//2. 숫자 (1 2 3 5 ....10까지.)출력.
		
		for(int i=1; i<=10; i++){
			System.out.print(i+" ");
		}
		
		/*3. 숫자 다음과 같이 출력.
		for
		i=1
		i=2
		.
		.
		.
		i=10
		 */
		System.out.println();
		System.out.println("==============================next");
		
		for(int i=1; i<=10; i++){
			System.out.println("i = "+i);
		}
		
		//for문 안에서 선언된 변수는 지역변수이다. 즉, for문 밖에서 호출이 안됨.
		
		
	}//main end
}//class end.
