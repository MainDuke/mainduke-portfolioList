/*
 * Author: Administrator
 * Created: 2016년 1월 20일 수요일 오전 11:13:29
 * Modified: 2016년 1월 20일 수요일 오전 11:13:29
 */


/*continue : 반복 loop문 블럭 끝을 만난것과 같은 의미이다.
			즉 다시 반족 loop 시행.
*/

class Test06_continue
{
	public static void main( String [] args )
	{
		for(int i=1;i<=10;i++)
		{
			if(1%2 == 0)continue;
			System.out.println(i+ " ");
			
		}//for end
		
	}// end main

}//class
