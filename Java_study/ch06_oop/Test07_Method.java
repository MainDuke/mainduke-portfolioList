/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 12:30:58
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 12:30:58
 */


//�����ε�~ �޼��� �ߺ�.
class Demo07{
	public int sum(int a, int b){
		//1~end �� ���ϱ�.
		
		int s =a+b;
		return s;
	}//sum end
	
	public int sum(int a, int b ,int c){
		//1~end �� ���ϱ�.
		
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
