/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 12:32:12
 * Modified: 2016�� 1�� 25�� ������ ���� 12:32:12
 */

//book 222 �ǽ�.

class SubInfor{
	String name, id, password;
	String phoneNo, address;
	
	
	//�����ڴ� �⺻������ public�� ���ش�.
	public SubInfor(){}
		
	
	public SubInfor(String name, String id, String password){
		this.name=name;
		this.id=id;
		this.password=password;
		
	}
	
	
	public SubInfor(String name, String id, String password, String phoneNo, String address){
		this.name=name;
		this.id=id;
		this.password=password;
		this.phoneNo=phoneNo;
		this.address=address;
	}
	
	void changepassword(String password){
		this.password=password;
	}
	void setphoneNo(String phoneNo){
		this.phoneNo=phoneNo;
	}
	void setaddress(String setaddress){
		this.address=setaddress;
	}
	
	
}// SubInfor end




class ConstrExample222
{
	public static void main( String [] args ) 
	{
		
		//����, SubInof ���� ����Ʈ �����ڰ� ����.
		//�׷��� SubInfor()�� ���� �ϸ� ������ �����.
		//���ڰ� �ִ� �����ڰ� �������� , ����Ʈ�����ڴ� �ڵ����� ���� ���� �ʴ´�.
		
		ConstrExample222 cc= new ConstrExample222();
		
		SubInfor obj1, obj2, obj3;
		obj1 = new SubInfor("�����", "poorman", "zebi");
		obj2 = new SubInfor("�����", "richman", "money", "02-000-0000", "Ÿ���Ӹ���");
		obj3 = new SubInfor();
		
		printSubInfor(obj1);
		printSubInfor(obj2);
		
		cc.printSubInfor2(obj1);
		cc.printSubInfor2(obj2);
	
		obj2.changepassword("789");
		obj2.setphoneNo("010-7766-8877");
		obj2.setaddress("���� ������ ���̷� 176 �߾Ӻ��� 5f");
		printSubInfor(obj2);
		cc.printSubInfor2(obj2);
		
	}// end main

	//static�� ���� �ʵ忡 �޼��带 ����ߴٸ�...?
	//�Ʒ� �κ� printSubInfor�� ���� ��ü�� �����ؾ� �Ʒ� �޼��带 ���� �����Ҽ� �ֵ�.
	
	static void printSubInfor(SubInfor obj){
		System.out.println("�̰� P1");
		System.out.println("�̸�: " + obj.name);
		System.out.println("ID: " + obj.id);
		System.out.println("�н�����: " + obj.password);
		System.out.println("��ȭ��ȣ: " + obj.phoneNo);
		System.out.println("�ּ�: " + obj.address);
		System.out.println();
	}
	
		void printSubInfor2(SubInfor obj){
			System.out.println("�̰� P2");
			System.out.println("�̸�: " + obj.name);
			System.out.println("ID: " + obj.id);
			System.out.println("�н�����: " + obj.password);
			System.out.println("��ȭ��ȣ: " + obj.phoneNo);
			System.out.println("�ּ�: " + obj.address);
			System.out.println();
		}
	
	
	
	
		
		
	
}//class end
