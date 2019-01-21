/*
 * Author: Administrator
 * Created: 2016년 1월 22일 금요일 오후 2:34:32
 * Modified: 2016년 1월 22일 금요일 오후 2:34:32
 */
class Demo09{
	public void disp(int b[])
	{
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i]+" ");
		}
	}//disp end
} // Demo09 end

//배열을 인수로 사용하는 예제.
class Test09_Method_array
{
 public static void main( String [] args ) 
	{
		Demo09 d9= new Demo09();//객체 생성.
		
		int a[]={10, 20, 30, 40, 50};
		
		System.out.println("메서드 호출 전");
		d9.disp(a);
		System.out.println("\n메서드 호출 후");
			
	}// end main

}//class end
