/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 2:40:06
 * Modified: 2016�� 1�� 21�� ����� ���� 2:40:06
 */


//3���� �迭.
class Test13_array
{
	public static void main( String [] args )
	{
		char [][][]ch={{{'a','b','c'},{'d','e','f'}},{{'g','h','i'},{'j','k','l'}}};
		
		
	
		
		//Test13_array 3���� �迭 ����.
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				for(int k=0;k<3;k++)
				{
					System.out.println(ch[i][j][k]);
				}//core for
			}//inner for
				
		}//for out
		
		//3���� �迭 ǥ�� �ڵ�.
		System.out.println();
		System.out.print("char ch[][][] = {");
		for(int i=0;i<ch.length;i++)
		{
			System.out.print("{");
			
			for(int j=0;j<ch[i].length;j++)
			{
				System.out.print("{");
				for(int k=0;k<ch[i][j].length;k++)
				{
					
					System.out.print(ch[i][j][k]);
					
					if(j < (ch[i][j].length )-1)
					{System.out.print(",");}
				}//core for
				System.out.print("}");
			}//inner for
			System.out.print("}");
			
			if(i+1 < ch.length)
			{System.out.print(",");}
			
			
		}//for out
		System.out.println("}");
		System.out.println();	
		
		
		
	}// end main

}//class end
