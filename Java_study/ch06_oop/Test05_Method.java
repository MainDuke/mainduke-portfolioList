/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 11:25:02
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 11:25:02
 */


//��Ű��- �� ����
//���?

class Demo05{
	public void aa(){
		System.out.println("aa()...call");
	}//aa() end
	
	public int bb(){
		//ó������
		return 123;	
	}//bb() end
	
	public String getName(){
		return "������";
	}//getName end
	
} // Demo05 end

class Test05_Method
{
	public static void main(String agrs[]){
		
		Demo05 d5= new Demo05();
		
		d5.aa();
		
		System.out.println(d5.bb());
		System.out.println(d5.getName());
		
	}//main end
	
}// class end
