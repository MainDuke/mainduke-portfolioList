/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 10:28:04
 * Modified: 2016년 1월 21일 목요일 오전 10:28:04
 */


class Test04_array
{
	public static void main( String [] args )
	{
		
		//정수.
		int a[]={10, 20, 30};
		for(int i=0; i<a.length;i++)
		{
			System.out.println(a[i]+" ");
		}//for end
		System.out.println();	
	
		
		//실수.
		double ki[]={166.7, 180.5, 188.9};
		
		for(int i=0; i<ki.length;i++)
		{
			System.out.println(ki[i]+" ");
		}//for end
		
		System.out.println();	
		
		//문자열 배열
		String name[]={"ABC","DEF","IJK"};
		
		for(int i=0; i<name.length;i++)
		{
			System.out.print(name[i]+"  ");
		}//for end
		System.out.println();
		
		
		
		
}// end main

}
