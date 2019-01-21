/*
 * Author: Administrator
 * Created: 2016년 1월 19일 화요일 오후 3:30:06
 * Modified: 2016년 1월 19일 화요일 오후 3:30:06
 */

//구구단~ 2~9단 출력. for문.
class Test12_for_gugudan
{
	public static void main( String [] args )
	{
		System.out.println(); //미관상 보기 좋게 Line skip
		System.out.println("------------------------------------------------------------------------------------------------------------------------Test12_01");
		System.out.println(); //미관상 보기 좋게 Line skip
		
		for(int i=1; i<=8; i++)
		{
				for(int j=1;j<=9;j++)
				{
					System.out.printf("|(%d * %d) = %2d ", (i+1), j,((i+1)*j));
				}//inner for
			System.out.println();
		}//end for
		
	System.out.println(); //미관상 보기 좋게 Line skip
	System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}// end main

}//end class
