/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 4:36:13
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 4:36:13
 */
class SangPum
{
	//���� ���� =Ŭ���� ����
	String pum;
	int su;
	double dan;
	
	//�޼��� : �� ���� �ϴ� �޼���
	public void setData(String pum, int su, int dan){
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}//setData end.
	
	public void disp(){
		
		
		System.out.println("��ǰ�� : "+this.pum);
		System.out.println("���� : "+this.su);
		System.out.println("�ܰ� : "+this.dan);
		System.out.println("�ݾ� : "+(su*dan)+"��\n");	
	}
	
}//SangPum end
class Test11_Method
{
	public static void main( String [] args ) 
	{	
	SangPum sp=new SangPum(); // ��ü ����.
	sp.setData("����", 20, 2500);
	sp.disp();
	}
}// class
	