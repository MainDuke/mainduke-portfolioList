/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 3:28:05
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 3:28:05
 */

class GeneralRoom{
	int roomNo;//���ȣ.
	int capacity;//����
}

class SpecialRoom extends GeneralRoom
{
	String owner;//������
	
	public void disp(){
		System.out.println("���ȣ: "+roomNo);
		System.out.println("����: "+capacity);
		System.out.println("����: "+owner);
	}//disp end
}//specialroom end

class Test06_extends
	{
		public static void main( String [] args ) 	{
			
			SpecialRoom sr=new SpecialRoom(); //��ü����
			
			sr.roomNo=3;
			sr.capacity=30;
			sr.owner="ȫ�浿";
			sr.disp();
			
			
		}// end main
		
	}
	