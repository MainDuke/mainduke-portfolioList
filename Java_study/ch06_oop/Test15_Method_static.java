/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 10:25:24
 * Modified: 2016�� 1�� 25�� ������ ���� 10:25:24
 */

//static �޼���� static���� ����� ����, �޼��常 ȣ�� ����.
//Math.max(5,2) => static���� ����� �޼���� ��ü �����ʰ� ȣ�Ⱑ��.
//Ŭ����.�޼���();

//-static ������ ��� ��ü�� �׸� ���� �Ҽ� �ִ�.



//�߸��� ����. ��� ��ü�� static dan,su, �� ���Ƿ� �μ����� ������ ������.
class SangPum2{
	//��������: �ڵ����� �ʱ�ȭ �˴ϴ�.
	
	String pum;//ǰ��.
	int su;
	/*static*/ int dan;//�ܰ�. // static �� ����� �������� ��µȴ�.
	
	
	//������ : Ŭ���� �̸��� ���� �̸�, ������ ����.
	
public SangPum2(){}

//�޼���
public void setData(String p, int s, int d){
pum=p;
su=s;
dan=d;
}//setData end
public void disp()
{
	System.out.println(pum+"---"+su+"---"+dan);
}
}

class Test15_Method_static
{
public static void main( String [] args ) 	
{

	SangPum2 s1,s2,s3;//int a,b,c
	s1= new SangPum2();//a=10;
	s2= new SangPum2();//b=20;
	s3= new SangPum2();//c=30;

	s1.setData("���",3,1500);
	s2.setData("��",5,2000);
	s3.setData("����",6,3000);
	
	s1.disp();
	s2.disp();
	s3.disp();
	
	
	
}// end main

}//class
