/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 4:16:27
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 4:16:27
 */

class SinSang{
//���� ���� =Ŭ���� ����
String name;
int age;
double ki;
//�޼��� : ���� �����ϴ� �޼���
//this: ���� Ŭ���� ��ü�� ���Ѵ�.
public void setData(String name, int age, double ki){
this.name=name;
this.age=age;
this.ki=ki;

}//setData end

public void disp(){
	
	System.out.println("�̸� : "+this.name);
	System.out.println("���� : "+this.age);
	System.out.println("Ű : "+this.ki);
}// SinSang end

	
class Test10_Method
{
	public static void main( String [] args ) 
	{
		SinSang s=new SinSang(); // ��ü ����.
		s.setData("�ڹ���", 21, 167.8);
		s.disp();
		
		SangPum sp=new SangPum(); // ��ü ����.
		sp.setData("����", 20, 2500);
		sp.disp();
		
				
	}// end main

}//class end
