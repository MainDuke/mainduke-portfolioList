/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 12:06:11
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 12:06:11
 */

class Demo06{
	public int sum(int end){
		//1~end �� ���ϱ�.
		
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
