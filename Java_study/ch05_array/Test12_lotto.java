/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 12:39:06
 * Modified: 2016�� 1�� 21�� ����� ���� 12:39:06
 */




class Test12_lotto
{
	public static void main( String [] args )
	{
		int a[] = new int[6];
		
		//���� �߻�.
		
		for(int i=0; i<6; i++)
		{
			a[i]=(int)(Math.random()*45 + 1);
			
			for(int j=0;j<i;j++)
			{
			//i�� j �� ���� ���ڰ� ���� �ݺ��� Ż��.
			if(a[i]==a[j]){
				i--;
				break;
			}//if end	
		}//inner for	
	}//for out
	
	
	//���.
	System.out.println();
	System.out.print("Lotto : ");
	for(int i=0;i<6;i++)
	{
		System.out.print(a[i]+" ");
	}
	System.out.println();
	
	
}// end main

}//claas
