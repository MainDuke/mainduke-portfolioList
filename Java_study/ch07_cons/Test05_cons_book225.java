/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 4:14:45
 * Modified: 2016�� 1�� 25�� ������ ���� 4:14:45
 */


//book 224~228 : ������
//���� ù���� �ҹ���, �ι�° �������ʹ� �빮��.
//�޼��� ù���� �ҹ���, �ι�° �����ź��ʹ� �빮��.

class SubInfor2{

	//��������
	String name;
	String id;
	String password;
	String phoneNo;
	String address;	

	//1. ����Ʈ
	public SubInfor2()
	{
	System.out.println("����Ʈ");	
	}
	
	//2. ���� ����.
	public SubInfor2(String name, String id, String password){
		this.name=name; 
		this.id=id;
		this.password=password;
	}//cons end
	//3. ���� ����.
	public SubInfor2(String name, String id, String password, String phoneNo, 
		String address){
		this.name=name; //227 ������ ����.
		this.id=id;
		this.password=password;
		this.phoneNo= phoneNo;
		this.address=address;
	}//cons end
	//�޼���
	public void changepassword(String password)
	{
		this.password=password;
	}
	public void setAddress(String address)
	{
		this.address= address;
	}
	public void setphoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	
}//class end

class Test05_cons_book225{
	public static void main( String [] args ){
	
		SubInfor2 ob1,ob2;
		ob1=new SubInfor2(); 
		ob2 = new SubInfor2("ȫ�浿","Food","12345","02-2323-5656","���� ������ ���̷� 176 �߾� ���� 5F");
		
		
		Test05_cons_book225 test= new Test05_cons_book225();//�ؿ� void disp() �� ��ü ����.
				
		test.disp(ob1);
		test.disp(ob2);
		
	}// end main
	void disp(SubInfor2 ob){
	System.out.println("�̸�:"+ob.name);
	System.out.println("ID :"+ob.id);
	System.out.println("Password :"+ob.id);
	System.out.println("��ȭ��ȣ :"+ob.phoneNo);
	System.out.println("Address :"+ob.address+"\n");
}//disp end

	
	
}//class end.
