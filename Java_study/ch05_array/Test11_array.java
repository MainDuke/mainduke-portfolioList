/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 12:17:01
 * Modified: 2016�� 1�� 21�� ����� ���� 12:17:01
 */

//�Ǽ� �迭�� �հ� ��� ���ϱ�.
class Test11_array
{
	public static void main( String [] args ) 
	{
		double ki[][]={
			{167.7, 188.8},
			{165.6, 177.7}};
		
		//ǥ��.
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
		
		//�� ���.
		
		double sum =0;
		for(int i=0;i<ki.length; i++){
			System.out.printf("ki[%d]�� ������ ��: {", i);
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
		//��� ���
		
		for(int i=0;i<ki.length; i++){
			System.out.printf("ki[%d]�� ������ ���: {", i);
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
