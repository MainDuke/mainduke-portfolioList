/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 11:36:01
 * Modified: 2016년 1월 21일 목요일 오전 11:36:01
 */

//실수 2차원 배열.
class Test09_array
{
	public static void main( String [] args )
	{
		double d[][]={
			{160., 175.2},
			{165.3, 180.5},
			{166.7, 185.2}};

		System.out.println("행갯수 : "+d.length);
		System.out.println("d[0] 갯수 : "+d[0].length);
		
		for(int i=0;i<d.length;i++)
		{
			for(int j=0;j<d[0].length;j++)
			{
				System.out.printf("d[%d][%d] = %5.1f",i,j, d[i][j]);
				System.out.println();
			}//inner for
			}//out for
		
		
		
	}// end main

}//class end
