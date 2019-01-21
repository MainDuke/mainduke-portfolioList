/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오전 9:36:47
 * Modified: 2016년 1월 19일 화요일 오전 9:36:47
 */


class Test03_for
{
	public static void main(String args[])
	{
		//문제1. 1~10까지 합 구하기.
		int sum=0;
		for(int i=1; i<=10; i++){
			sum+=i;//sum=sum+i
		}//for
			System.out.println("1~10까지의 합 : " +sum);
			System.out.println(); //line skip
			
		
		//문제2. 1~20까지 짝수 합 구하기.
		//if문 사용.
		int sum2 =0;
		
		for(int i=1; i<=20; i++){
			
			if(i%2 == 0){
				sum2 +=i;
				System.out.println(i);
				}//if
			}//for
		System.out.println("1~20까지의 짝수의 합 : " +sum2);
		System.out.println(); //line skip
		
		//문제3 1~1000, 127의 배수의 합 구하기.
		int sum3=0;
		
		
		for(int i=1; i<=1000; i++){
			
			if(i%127 == 0){
				sum3 +=i;
				System.out.println(i);
			}//if
		}//for
		System.out.println("1~1000까지의 127배수의 합 : " +sum3);
		System.out.println(); //line skip
		
		
		
		
		
		
			
	}//main end
	
}//class end
