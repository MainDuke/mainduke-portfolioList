/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오후 4:20:44
 * Modified: 2016년 1월 19일 화요일 오후 4:20:44
 */


class Test01_while
{
	public static void main( String [] args ) 
	{
		//1.본인이름 5번 출력.
		System.out.println();
		int i = 1;
		while(i<=5)
		{
			System.out.print("한창민 ");
			i++;

						}
		
		//2.1~10까지 출력하기.
		i=1;
		
		System.out.println();
		System.out.println("------------------------Test01_while_q2");
		System.out.println();
		
		while(i<=10)
		{
			System.out.print(i + " ");
			i++;
			
		}
		
		//3. 1~20까지 짝수만 출력.
		i=1;
		
		System.out.println();
		System.out.println("------------------------Test01_while_q3");
		System.out.println();
		
		while(i<=20)
		{
			if(i%2 == 0){
			System.out.print(i + " ");
			}
			
			i++;
		
		}
		System.out.println();
		
	}// end main

}//class end
