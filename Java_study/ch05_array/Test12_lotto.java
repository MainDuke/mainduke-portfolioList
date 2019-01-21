/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오후 12:39:06
 * Modified: 2016년 1월 21일 목요일 오후 12:39:06
 */




class Test12_lotto
{
	public static void main( String [] args )
	{
		int a[] = new int[6];
		
		//숫자 발생.
		
		for(int i=0; i<6; i++)
		{
			a[i]=(int)(Math.random()*45 + 1);
			
			for(int j=0;j<i;j++)
			{
			//i와 j 에 같은 숫자가 들어가면 반복문 탈출.
			if(a[i]==a[j]){
				i--;
				break;
			}//if end	
		}//inner for	
	}//for out
	
	
	//출력.
	System.out.println();
	System.out.print("Lotto : ");
	for(int i=0;i<6;i++)
	{
		System.out.print(a[i]+" ");
	}
	System.out.println();
	
	
}// end main

}//claas
