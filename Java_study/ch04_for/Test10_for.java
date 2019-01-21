/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오후 2:29:05
 * Modified: 2016년 1월 19일 화요일 오후 2:29:05
 */



class Test10_for
{
	public static void main( String [] args )
	{
		for(int i=1; i<=4; i++)
		{
			
			for(int j=1; j<=i; j++)
			{
				System.out.print(j+" ");
	
			}//inner for end 1
			
			System.out.println();
			
		}//for out

		
		System.out.println();
		System.out.println("--------------------문1");
		System.out.println();
		
		
		
		/*for(int i=1; i<=4; i++)
		{
		
		for(int j=1; j<=i; j++)
		{
		System.out.print(i+j);
		
		}//inner for end 1
		
		System.out.println();
		
		}//for out
		 */
		
		int sum=1;
		for(int i=1; i<=4; i++)
		{
			for(int j=1; j<=i; j++)
			{
				
				System.out.print(sum+" ");
			++sum;
			}
			
			System.out.println();
		}
		
		
		
		
		
		
	}//end main
	
}//end class

