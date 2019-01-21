/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오전 10:46:58
 * Modified: 2016년 1월 26일 화요일 오전 10:46:58
 */

/*String substring(int start, int end)
=>현재 문자열 객체에서 start위치부터 end직전까지
 문자열 발췌.

int indexOf(int ch)
	현재 문자열 객체에서 문자ch위치를 반환(return)한다.

int indexOf(String s)
=> 현재문자열 객체에서 문자열s를 찾아서
	문자열이 있으면 첫번째 문자 위치를 반환하고
	없으면 -1를 반환한다.

*/

class Test01_class
{
	public static void main( String [] args ) 
	{
		String s1="GoodMornig-kildong";
		//		   01234567890123456789
		String s2=s1.substring(11);
		String s3=s1.substring(4,10);
		
		System.out.println("s2:"+s2); //kildong
		System.out.println("s3:"+s3); //Morinig
		
		String a1="총 비욜은 $45.67";
		int i1=a1.indexOf('$');//$위치를 구한다.
		String a2=a1.substring(i1); //i1위치부터 끝까지 문자열을 발췌.
		
		System.out.println("i1:"+i1);
		System.out.println("a2:"+a2);//$45.67
		
		int i2=a1.indexOf("$45.67");
		String a3= a1.substring(i2);
		System.out.println("i2:"+i2);
		System.out.println("a3:"+a3);
	
	
	}// end main

}//class end
