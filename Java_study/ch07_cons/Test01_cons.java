/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 11:35:25
 * Modified: 2016�� 1�� 25�� ������ ���� 11:35:25
 */

//������ ����.

class Sung{
	String name;//null, ���� ���� �ڵ� �ʱ�ȭ.
	int kor; //0
	
	//1.����Ʈ ������.
	public Sung(){//����Ʈ ������.
					//�����ڸ� ���� ������,
					//����Ʈ �����ڰ� �ڵ����� ���� �ȴ�.
					//���� �ִ� �����ڰ� ��������,
					//����Ʈ �����ڴ� �������� �ʴ´�.
	
				//name="";
				kor=0;
				System.out.println("����Ʈ ������ ȣ��");
			}
					
	public Sung(String name, int kor){
		this.name=name;
		this.kor=kor;
		
		System.out.println("����1 ������ ȣ��");
				
	}//���ڰ� �ִ� ������.
	
	public Sung(int kor, String name){
		
		this.name=name;
		this.kor=kor;
		
		System.out.println("����2 ������ ȣ��");
	}
	
	public void disp(){
		System.out.println(name+"---"+kor);
	}	
	
					
}//class end

class Test01_cons
{
	public static void main( String [] args ) 
	{
		Sung s1=new Sung();//����Ʈ ������.
		Sung s2= new Sung("ȫ�浿", 12);
		Sung s3= new Sung(21, "������");
		
		System.out.println();
		
		s1.disp(); // null 0
		s2.disp(); // ȫ�浿. 12
		s3.disp(); //  ������ , 21
	}// end main

}//class end.