/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오전 10:29:30
 * Modified: 2016년 1월 19일 화요일 오전 10:29:30
 */


class Test04_multifor
{
	public static void main(String args[])
	{
		for(int i=1; i<=4; i++)
		{
			System.out.print("i= "+i+" => j = ");
			for(int j=1; j<=4; j++)
			{
				System.out.print(j+" ");
			}//inner for
			System.out.println();
		}//out for
		
		System.out.println();
		System.out.println("--------------------문1");
		System.out.println();
		
		/*문제 : 
		 *****
		 *****	
		 *****
		 *****
		 */
		
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=4; j++)
			{
				System.out.print("*");
			}//inner for
			System.out.println();
		}//out for
		
		System.out.println();
		System.out.println("--------------------문2");
		System.out.println();
				
		/*문제 3
		
		 *
		 **
		 ***
		 ****
				 */
			
		
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("*");
			}//inner for
			System.out.println();
		}//out for
		
		System.out.println();
		System.out.println("--------------------문3");
		System.out.println("--------------------Test06.java");
		System.out.println();
				
		//문제
		
		for(int i=1; i<=4; i++)
		{
			for(int j=4; j>=i; j--)
			{
				System.out.print("*");
			}//inner for
			System.out.println();
		}//out for
		
		
		
		
	}//end main
	
}//end class
