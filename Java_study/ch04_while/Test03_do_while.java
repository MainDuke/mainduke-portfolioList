/*
 * Author: Administrator
 * Created: 2016년 1월 20일 수요일 오전 10:03:59
 * Modified: 2016년 1월 20일 수요일 오전 10:03:59
 */


class Test03_do_while
{
		public static void main( String [] args ) 
		{
			//문제1> 친구이름 1번 출력.
			System.out.println();
			int i = 1;
			do{
				System.out.println("브리즈");
				i++;
			}while(i<=3);
			
			//문제2> 1~10 까지 출력.
			
			System.out.println();
			
			i=1;
			do{
				System.out.print(i + " ");
				i++;
			}while(i<=10);
			System.out.println();
			
			//1~20까지 짝수 출력.
			
			i=1;
			do{
				if(i % 2 == 0){
				System.out.print(i + " ");
			}
				i++;
			}while(i<=20);
			System.out.println();
			
			//1~50까지 7배수 출력.
			
			i=1;
			do{
				if(i % 7 == 0){
					System.out.print(i + " ");
				}
				i++;
			}while(i<=50);
			System.out.println();
			
			//문제5. 30~1 까지 3배수 출력.
			
			
			i=30;
			do{
				if(i % 3 == 0){
					System.out.print(i + " ");
				}
				i--;
			}while(i>=1);
			System.out.println();
			
			
			
			
		}// end main

	}//class end
