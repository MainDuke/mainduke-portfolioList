/*
 * Author: Administrator
 * Created: 2016년 1월 18일 월요일 오후 4:44:49
 * Modified: 2016년 1월 18일 월요일 오후 4:44:49
 */


class Test02_for
{
	public static void main( String [] args )
	{
	//문 10 ~ 1 까지 차례 출력.
		
	for(int i=10; i>0; i--)
	{System.out.print(i+" ");	}
	System.out.println();
	System.out.println("-----------------------");
	
	
	
	
	//문2. 1~10까지 짝수만 출력하시오.
	//for,if문 사용.
	for(int i=1; i<=10; i++)
	{
		if(i%2==0){System.out.print(i+" ");	}
	}	
	System.out.println();
	System.out.println("-----------------------");
	
	//문제3. 1~50까지 7의 배수만!
	
	for(int i=1; i<=50; i++)
	{
		if(i%7==0){System.out.print(i+" ");	}
	}	
	
	System.out.println();
	System.out.println("-----------------------");
	
	//문제4. 1~1000까지.
	for(int i=1; i<=1000; i++)
	{
		if(i%170==0){System.out.print(i+" ");	}
	}	
	
	System.out.println();
	
	
	
	}// end main


}//class end