/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 11:44:38
 * Modified: 2016년 1월 21일 목요일 오전 11:44:38
 */


//배열 합 구하기.
class Test10_array
{
	public static void main( String [] args ) 
	{
		
		//2차원 배열 표시 코딩.
		int a[][]={
			{10, 20},
			{30, 40},
			{50, 60}};
		System.out.println();
		System.out.print("int a[][] = {");
		for(int i=0;i<a.length;i++)
		{
			System.out.print("{");
			
			for(int j=0;j<a[i].length;j++)
			{
				
				System.out.print(a[i][j]);
				
				if(j < (a[i].length )-1)
				{System.out.print(",");}
				
			}//inner for
			System.out.print("}");
			
			if(i+1 < a.length)
			{System.out.print(",");}
			
			
		}//for out
		System.out.println("}");
		System.out.println();		
		
		//2차원 배열 행 합 구하기.
		int sum =0;
		for(int i=0;i<a.length; i++){
			System.out.printf("a[%d]행 값들의 합: {", i);
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]);
				
				if(j < (a[i].length )-1)
				{System.out.print(", ");}
				
				if(j == (a[i].length)-1)
				{
				System.out.print("} = ");				
				sum += a[i][j];
				System.out.print(sum);
				sum=0;
				break;
				}
				sum += a[i][j];	
			}//inner for
	  		
		System.out.println();
		}//for out
		
	}// end main
	
}//class end
