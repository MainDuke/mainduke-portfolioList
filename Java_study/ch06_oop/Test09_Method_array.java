/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 2:34:32
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 2:34:32
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

//�迭�� �μ��� ����ϴ� ����.
class Test09_Method_array
{
 public static void main( String [] args ) 
	{
		Demo09 d9= new Demo09();//��ü ����.
		
		int a[]={10, 20, 30, 40, 50};
		
		System.out.println("�޼��� ȣ�� ��");
		d9.disp(a);
		System.out.println("\n�޼��� ȣ�� ��");
			
	}// end main

}//class end
