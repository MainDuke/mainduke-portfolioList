/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 4:47:27
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 4:47:27
 */


class Test02_while
{
	public static void main( String [] args )
	{
		//1.1~1000���� 10�� ����� ����Ͻÿ�. while��
		System.out.println();
		int i=1;
		while(i<=1000)
		{
		
		if(i % 10 == 0)
		{
		System.out.printf("%4d ",i);
		
		}
		
		if(i % 100 == 0)
		{
			System.out.println();
			
		}
		
		i++;
		}
		
		System.out.println();
		
		
		//2.
		//	10 9 9 7 6 5 4 3 2 1 ���.
		//while
		
		i= 10;
		
		while ( i>=1)
		{System.out.print(i+" ");
		i--;
			}
		
	}// end main

}//class main
