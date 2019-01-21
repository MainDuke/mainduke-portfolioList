/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오전 11:39:53
 * Modified: 2016년 1월 18일 월요일 오전 11:39:53
 */


class Test02_if
{
	public static void main( String [] args )
	{
		int su=Integer.parseInt(args[0]);//문자열을 정수로 변환.	
		if(su>=0)
		{
			System.out.println(su+ " 양수 ");
		}else{
			System.out.println(su+" 음수 ");
		}
			
	}// end main
}//class end
