/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 11:48:08
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 11:48:08
 */


//Test05~06�� Test04�� �׳� �Բ� �Ἥ ����� �ξ���!

class Test07_for
{
	public static void main( String [] args )
	{
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=(5-i); j++)
			{
				System.out.print(" ");
			}//inner for end 1
			
			for(int k=1; k<=i; k++)
			{
				System.out.print("*");
				
			}//inner for end 2
	
			System.out.println();
		
			
		}//for out
		
		
		
		
		
	}// end main

}//end class
