/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 3:30:06
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 3:30:06
 */

//������~ 2~9�� ���. for��.
class Test12_for_gugudan
{
	public static void main( String [] args )
	{
		System.out.println(); //�̰��� ���� ���� Line skip
		System.out.println("------------------------------------------------------------------------------------------------------------------------Test12_01");
		System.out.println(); //�̰��� ���� ���� Line skip
		
		for(int i=1; i<=8; i++)
		{
				for(int j=1;j<=9;j++)
				{
					System.out.printf("|(%d * %d) = %2d ", (i+1), j,((i+1)*j));
				}//inner for
			System.out.println();
		}//end for
		
	System.out.println(); //�̰��� ���� ���� Line skip
	System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}// end main

}//end class
