/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 12:12:59
 * Modified: 2016�� 1�� 25�� ������ ���� 12:12:59
 */


class SinSang{
	
	//���� ����.
	String name; 
	int age;
	double ki;
		
	//1.����Ʈ ������.
	public SinSang(){
	System.out.println("call default");
	}
	
	//2. ���� ������.
	public SinSang(String name, int age, double ki){
	
		String ch="";
		int aa=0;
		double bb=0;
				
		this.name=name;
		this.age=age;
		this.ki=ki;
	
	System.out.println("call ����1");
	}
	
	//3.���� �ִ� ������.
	public SinSang(int age, String name, double ki){
		
		this.age=age;
		this.name=name;
		this.ki=ki;
	
	System.out.println("call ����2");
	}
	public void disp(){
	System.out.println(name+"---"+age+"---"+ki);
	}
	
	
	
	
	
}//class end.

class Test02_cons
{
	public static void main( String [] args )
	{
		//3�� ������ �����Ͻÿ�.
		SinSang s3 = new SinSang(15, "ȫ�浿", 177.5);
		//2�� ������ �����Ͻÿ�.
		SinSang s2 = new SinSang("���ľ�", 44, 176.3);
		//1�� ������ �����Ͻÿ�.
		SinSang s1 = new SinSang();
		
		System.out.println();
		
		s3.disp();
		s2.disp();
		s1.disp();
			
		
		
	}// end main

}//class end.
