/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 9:49:22
 * Modified: 2016�� 1�� 28�� ����� ���� 9:49:22
 */

//�������̽�
//��ü instanceof Ŭ���� �Ǵ� �������̽�
//			= true
//			< true
//			> false
//��� ���谡 �ƴѰ��� ���Ҽ� ����. (���� ������ ��ü�� ���Ҽ� ����.)
	

interface AA4{
	int a=10; //final static int =10; �̴�.
	int aa();//�߻� �޼���
}
interface BB4 extends AA4{
	double d= 33.4;
	double dd(); //�߻� �޼���.
}
interface CC4 extends BB4{
	String name="ȫ�浿";
	String irum();
}




class Test04_interface implements CC4
{
	//�������̽��� ��� ������,�ݵ�� �������� ��� �޼��带 �������̵� �ؾ��Ѵ�.
	public int aa(){
		return 20;
	}
	
	public double dd(){
	return 10.5;
	}
	public String irum(){
		return "CM";
	}
	
 	public static void main( String [] args )
		{
			//CC4���� Test04_interface �� ��� �޾Ҵ�.
			CC4 test=new Test04_interface(); //���� Ŭ���� ������ ���� Ŭ���� ó��.
			
			if(test instanceof AA4){
				System.out.println(test.a); //�ʵ尪 ���.
				System.out.println(test.d);
				System.out.println(test.name);
				//test.a=300; �ʵ尪 ���� ����. final static �̴ϱ�!
			
				System.out.println(test.aa()); //�ʵ尪 ���.
				System.out.println(test.dd());
				System.out.println(test.irum());
			}
					
		}// end main

	}//class end
