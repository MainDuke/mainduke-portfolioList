/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 11:44:38
 * Modified: 2016�� 1�� 21�� ����� ���� 11:44:38
 */


//�迭 �� ���ϱ�.
class Test10_array
{
	public static void main( String [] args ) 
	{
		
		//2���� �迭 ǥ�� �ڵ�.
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
		
		//2���� �迭 �� �� ���ϱ�.
		int sum =0;
		for(int i=0;i<a.length; i++){
			System.out.printf("a[%d]�� ������ ��: {", i);
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
