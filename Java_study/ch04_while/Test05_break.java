/*
 * Author: Administrator
 * Created: 2016년 1월 20일 수요일 오전 10:39:45
 * Modified: 2016년 1월 20일 수요일 오전 10:39:45
 */


class Test05_break
{
	public static void main( String [] args ) 
	{
		for(int i=1; i<=10000; i++)
		{
			System.out.println(i + " ");
			if(i==10)break;
			
		}//for out
		
		
		System.out.println();
		
		int i= 1;
		while(i<=10000){
			
			System.out.println(i + " ");
			if(i==10)break;
			i++;
		}//while
		
		
		
	}// end main
	
}//class end
