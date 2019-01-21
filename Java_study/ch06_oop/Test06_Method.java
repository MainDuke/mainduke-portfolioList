/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 12:06:11
 * Modified: 2016년 1월 22일 금요일 오후 12:06:11
 */

class Demo06{
	public int sum(int end){
		//1~end 합 구하기.
		
		int hap =0;
		
		for(int i=1; i<= end; i++)
		{	
			hap+=i;
		}//for end
		return hap;
	}//sum end
} // Demo06 end

class Test06_Method
{
	public static void main( String [] args ) 
	{
		
		Demo06 d6=new Demo06();
		
		System.out.println(d6.sum(10));
		
		
	}// end main
	
}//class
