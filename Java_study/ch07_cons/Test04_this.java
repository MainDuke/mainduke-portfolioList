/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 3:45:24
 * Modified: 2016�� 1�� 25�� ������ ���� 3:45:24
 */


//this() : �ڽ��� Ŭ���� ���� ������ ȣ��.
//			�μ� Ÿ���� �´� ������ ȣ��.

class PanMeaSub{
	
	//1.����Ʈ ������.
	public PanMeaSub(){
		System.out.println("����Ʈ ������ ȣ��");
	};
	
	//2. ���� �ִ� ������.
	public PanMeaSub(String p){
		this(p, 123);
		System.out.println("������2 ȣ��");
		
	}
	//3. ���� �ִ� ������
	public PanMeaSub(String p, int s){
		this(p, 123, 3000);
		
		System.out.println("������3 ȣ��");
		
	}
	//4. ���� �ִ� ������.
	public PanMeaSub(String p,int s, int d){
		
		System.out.println("������4 ȣ��");
		
		
		
		System.out.println(p+"---"+s+"---"+d);
		
		
	}
	
	
	
}//class

class Test04_this
{
	public static void main( String [] args ) 
	{
		new PanMeaSub("����");//2�� ������ ȣ��.	
		
		new PanMeaSub();	
		
		
		
		
		
		
	}// end main
	
}//class
