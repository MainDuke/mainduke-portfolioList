/*
 * Author: Administrator
 * Created: 2016�� 1�� 20�� ������ ���� 10:03:59
 * Modified: 2016�� 1�� 20�� ������ ���� 10:03:59
 */


class Test03_do_while
{
		public static void main( String [] args ) 
		{
			//����1> ģ���̸� 1�� ���.
			System.out.println();
			int i = 1;
			do{
				System.out.println("�긮��");
				i++;
			}while(i<=3);
			
			//����2> 1~10 ���� ���.
			
			System.out.println();
			
			i=1;
			do{
				System.out.print(i + " ");
				i++;
			}while(i<=10);
			System.out.println();
			
			//1~20���� ¦�� ���.
			
			i=1;
			do{
				if(i % 2 == 0){
				System.out.print(i + " ");
			}
				i++;
			}while(i<=20);
			System.out.println();
			
			//1~50���� 7��� ���.
			
			i=1;
			do{
				if(i % 7 == 0){
					System.out.print(i + " ");
				}
				i++;
			}while(i<=50);
			System.out.println();
			
			//����5. 30~1 ���� 3��� ���.
			
			
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
