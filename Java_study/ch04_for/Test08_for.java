/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오후 12:40:12
 * Modified: 2016년 1월 19일 화요일 오후 12:40:12
 */


/*
Test08
 *
 ***
 *****
 *******

 */

class Test08_for
{
	public static void main( String [] args )
	{
		for(int i=1; i<=4; i++)
		{
			
			for(int j=1; j<=(4-i); j++)
			{
				System.out.print(" ");
			}//inner for end 1
			
			// 수열 공식. 1+2(i-1)=2*i-1
			for(int k=1; k<=2*i-1; k++)
			{
				System.out.print("*");
			}//inner for end 2
			
			System.out.println();
		
		}//for out

		System.out.println();
		System.out.println("--------------------문1");
		System.out.println();
		
		
		
		
		/*
		Test09 -- (면접때 나왔다고...ㅋ)
		 *******
		 *****
		 ***
		 * 
		 */




for(int i=1; i<=4; i++)
{
	
	for(int j=1; j<=i-1; j++)
	{
		System.out.print(" ");
	}//inner for end 1
	
	// 수열 공식. 
	for(int k=7; k>=2*i-1; k--)
	{
		System.out.print("*");
	}//inner for end 2
	
	System.out.println();
	
}//for out



		
	}//end main
	
}//class end