/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오후 12:17:01
 * Modified: 2016년 1월 21일 목요일 오후 12:17:01
 */

//실수 배열의 합과 평균 구하기.
class Test11_array
{
	public static void main( String [] args ) 
	{
		double ki[][]={
			{167.7, 188.8},
			{165.6, 177.7}};
		
		//표현.
		System.out.println();
		System.out.print("double ki[][] = {");
		for(int i=0;i<ki.length;i++)
		{
			System.out.print("{");
			
			for(int j=0;j<ki[i].length;j++)
			{
				
				System.out.print(ki[i][j]);
				
				if(j < (ki[i].length )-1)
				{System.out.print(",");}
				
			}//inner for
			System.out.print("}");
			
			if(i+1 < ki.length)
			{System.out.print(",");}
						
		}//for out
		System.out.println("}");
		System.out.println();		
		
		//합 계산.
		
		double sum =0;
		for(int i=0;i<ki.length; i++){
			System.out.printf("ki[%d]행 값들의 합: {", i);
			for(int j=0; j<ki[i].length;j++)
			{
				System.out.print(ki[i][j]);
				
				if(j < (ki[i].length )-1)
				{System.out.print(", ");}
				
				if(j == (ki[i].length)-1)
				{
					System.out.print("} = ");				
					sum += ki[i][j];
					System.out.printf("%5.2f", sum);
					sum=0;
					break;
				}
				sum += ki[i][j];	
			}//inner for
			
			System.out.println();
		}//for out
		
		System.out.println();
		//평균 계산
		
		for(int i=0;i<ki.length; i++){
			System.out.printf("ki[%d]행 값들의 평균: {", i);
			for(int j=0; j<ki[i].length;j++)
			{
				System.out.print(ki[i][j]);
				
				if(j < (ki[i].length )-1)
				{System.out.print(", ");}
				
				if(j == (ki[i].length)-1)
				{
					System.out.print("} = ");				
					sum += ki[i][j];
					System.out.printf("%5.2f", (sum/ki.length));
					sum=0;
					break;
				}
				sum += ki[i][j];	
			}//inner for
			
			System.out.println();
		}//for out
		
		System.out.println();
		
		
	}// end main

}//class end
