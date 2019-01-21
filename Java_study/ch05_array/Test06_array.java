/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 10:49:39
 * Modified: 2016년 1월 21일 목요일 오전 10:49:39
 */



//Test06_array 
//문자열을 각 문자 요소로 분해하기.

class Test06_array
{
	public static void main( String [] args )
	{
		String str="Good-Morning-kildong";
		char ch[]=new char[str.length()];
		
		str.getChars(5,12,ch,2);//5번 문자로부터 12직전까지를 ch[2]부터 요소를 넣는다.
								//5~11 까지 입력이 되는것이다. Java의 특징.
		
		System.out.println();   
		System.out.println(str);
		System.out.println();
		
		for(int i=0;i<ch.length;i++)
		{
			System.out.print(ch[i]);
		}//for out
		
		System.out.println();
		
	}// end main

}//class
