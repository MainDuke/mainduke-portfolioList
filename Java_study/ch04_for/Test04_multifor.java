/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 10:29:30
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 10:29:30
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
		System.out.println("--------------------��1");
		System.out.println();
		
		/*���� : 
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
		System.out.println("--------------------��2");
		System.out.println();
				
		/*���� 3
		
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
		System.out.println("--------------------��3");
		System.out.println("--------------------Test06.java");
		System.out.println();
				
		//����
		
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
