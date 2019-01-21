/*
 * Author: Administrator
 * Created: 2016년 1월 21일 목요일 오전 9:28:29
 * Modified: 2016년 1월 21일 목요일 오전 9:28:29
 */

/*array (배열)
전역변수 초기화 자동으로 된다. (메서드 밖에 외부에서 선언된 변수)
지역변수 프로그래머가 직접 초기화 해야한다. (메서드 내부에서 선언된 변수.)
배열은 지역일 지라도 자동 초기화 된다.
 */


class Test02_array
{
	
	static int a1; // 전역 변수.
	
	public static void main( String [] args ) 
	{
		//이 Test는 선언된 배열의 기본값(default 값을 알아보기 위한 것이다.
		
		int a2=0; // 지역 변수. << 변수값 선언 안 해주면  error가 난다. 
		//그래서 0으로 초기화.
		
		System.out.println("a1 :"+ a1);
		System.out.println("a2 :"+ a2);
		
		char ch[]= new char[3]; // ' ' 초기화.
		int n[]= new int[3]; //배열 생성.
		double d[]=new double[3];
		boolean b[]= new boolean[3];
		String str[]=new String[3];
		
		System.out.println("	 ch[i]"+" n[i] "+ "d[i] " + "b[i] " + "str[i]");
		for(int i=0;i<n.length; i++)
		{
			
			System.out.println("i="+i+": "+ch[i]+"\t"+n[i]+"\t"+d[i]+"\t"+b[i]+"\t"+str[i]);
		}//for out
		
		System.out.println("ch.length:"+ch.length); //배열 갯수.
		System.out.println("n.length:"+n.length);
		System.out.println("b.length:"+b.length);
		System.out.println("d.length:"+d.length);
		System.out.println("str.length:"+str.length);
		
		
		
		
		
		

		
		
		
	
	}// end main
	
	
}//end class
