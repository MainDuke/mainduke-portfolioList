/*
 * Author: Administrator
 * Created: 2016년 1월 20일 수요일 오후 4:24:47
 * Modified: 2016년 1월 20일 수요일 오후 4:24:47
 */


class Test01_array
{
	public static void main( String [] args )
	{
		int a= 10;
		int b= 20;
		int c= 30;
		
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		System.out.println("c: "+c);

		//배열 사용.
		int s[]=new int[3];
		s[0]=50;
		s[1]=60;
		s[2]=70;

		System.out.println("s[0]: "+s[0]);
		System.out.println("s[1]: "+s[1]);
		System.out.println("s[2]: "+s[2]);
		System.out.println();
		
		
		for(int i=0; i<=2;i++){
		
			System.out.printf("s[%d]: %d ", i, s[i]);
			System.out.println();
		}
		
	}// end main

}//class main
