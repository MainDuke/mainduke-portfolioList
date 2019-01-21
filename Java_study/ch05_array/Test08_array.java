/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 11:32:17
 * Modified: 2016년 1월 21일 목요일 오전 11:32:17
 */


class Test08_array
{
	public static void main( String [] args ) 
	{
		int a[][]={{10, 20},{30, 40,50},{60, 70,80,90}};
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.printf("a[%d][%d] = %d",i,j, a[i][j]);
				System.out.println();
			}//inner for
		}//for out
		
	}// end main

}//class
