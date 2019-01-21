/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오후 3:09:33
 * Modified: 2016년 1월 19일 화요일 오후 3:09:33
 */


class Test11_for
{
	public static void main( String [] args )
	{
		
		char ch = 'A';
		System.out.println(); //미관상 보기 좋게 Line skip
		System.out.println("--------------------Test11_01");
		for(int i=1; i<=4; i++)
		{
			for(char j=1; j<=i; j++)
			{
				System.out.print(ch);
				ch++;
			}//inner for end
			System.out.println();
			ch='A';
		}//for out
		
		ch='A';
		
		System.out.println();
		System.out.println("--------------------Test11_02");
		System.out.println();
		
				
		for(int i=1; i<=4; i++)
		{
			for(char j=1; j<=i; j++)
			{
				System.out.print(ch);
				ch++;
			}//inner for end
			
			System.out.println();
			
		}//for out
		System.out.println(); //미관상 보기 좋게 Line skip
		
	}//end main
}//end class