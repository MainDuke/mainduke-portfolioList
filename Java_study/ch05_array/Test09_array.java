/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 11:36:01
 * Modified: 2016�� 1�� 21�� ����� ���� 11:36:01
 */

//�Ǽ� 2���� �迭.
class Test09_array
{
	public static void main( String [] args )
	{
		double d[][]={
			{160., 175.2},
			{165.3, 180.5},
			{166.7, 185.2}};

		System.out.println("�హ�� : "+d.length);
		System.out.println("d[0] ���� : "+d[0].length);
		
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
