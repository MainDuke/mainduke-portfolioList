/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 10:47:51
 * Modified: 2016�� 1�� 25�� ������ ���� 10:47:51
 */
//static �޼���� static���� ����� ����, �޼��常 ȣ�� ����.
//Math.max(5,2) => static���� ����� �޼���� ��ü �����ʰ� ȣ�Ⱑ��.
//Ŭ����.�޼���();

//-static ������ ��� ��ü�� �׸� ���� �Ҽ� �ִ�.
//static ���� ��ü ���� �ʰ� ȣ�Ⱑ��.
//static �޼��忡���� this ��� ����: �ڽ��� 2�� ��Ī�ϴ� ���̹Ƿ�..

class Test16_var_static
{
	
	static int a = 100;
	
	public static void main(String args[]){
	
	int  a= 200; //��������.

	System.out.println("�������� a:"+a);
	System.out.println("�������� this.a:"+(this.a)); //static �޼��� �ȿ��� this ȣ�� �ȵȴ�. 
	
	
}//main end
}//class end
