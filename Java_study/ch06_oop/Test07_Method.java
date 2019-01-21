/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 12:30:58
 * Modified: 2016년 1월 22일 금요일 오후 12:30:58
 */


//오버로드~ 메서드 중복.
class Demo07{
	public int sum(int a, int b){
		//1~end 합 구하기.
		
		int s =a+b;
		return s;
	}//sum end
	
	public int sum(int a, int b ,int c){
		//1~end 합 구하기.
		
		int s =a+b+c;
		return s;
	}//sum end
	
	
	
} // Demo06 end

class Test07_Method
{
	public static void main( String [] args )
	{
		
		Demo07 d7= new Demo07();
		
		int a = d7.sum(1,2);
		
		System.out.println(a);
		System.out.println();
		
		int b= d7.sum(1,2, 3);
		System.out.println(b);
		
	}// end main
	

}//class end
