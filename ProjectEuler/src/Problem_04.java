/*
 * Author: Administrator
 * Created: 2016년 4월 14일 목요일 오후 1:50:30
 * Modified: 2016년 4월 14일 목요일 오후 1:50:30
 */


class Problem_04
{
	
	public Problem_04(){
		
		int max=0;
		int a=0;
		int b=0;
		
		for(int i=100;i<1000;i++)// 3자리수 곱!
		{
			for(int j=100;j<1000;j++)
			{
				
				String str=Integer.toString(i*j); //곱셈을 문자열로 바꿔서 
				String nstr=new StringBuilder(str).reverse().toString(); //문자열을 뒤집는다.
				
				if(str.equals(nstr)){ //만약 대칭 시킨 값이 일치한다면
					int num=Integer.parseInt(str);
					if(num>max){ //저장된 max 값보다 확인된 num값이 크다면, max 에다가 num을 저장한다.
						max=num;
						break;
					}
					
						
				}//	
						
				}
			}//for
System.out.println(max); //최정적으로 for문이 끝났을때, max 에 저장된 값을 내보낸다.
		
	}//cons
public static void main( String [] args ) 
{
	new Problem_04();
}// end main

}//class end
