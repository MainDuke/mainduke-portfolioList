/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 3:36:32
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 3:36:32
 */

class PanMae{
	
	//private String pum; //private ����� ������ �ڽ��� Ŭ���� �������� ��� �����ϴ�.
	//private int su;
	//private int dan;
	
	
	//protected�� superŬ������ �Ļ�(����)������ ���� �����մϴ�.
	protected String pum; //ǰ��
	protected int su; 
	protected int dan;
	
	public PanMae(String pum, int su, int dan){
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}	
	public void disp(){//���� ���̵� : ��� ���� �޼��� ���� ������.
		System.out.println(pum + "---" + su + "---" + dan);
		
	}//disp
}//--class


//������
class SalePanMae7 extends PanMae{
	
	protected double rate;//������, ����
	
	public SalePanMae7(String pum, int su, int dan, double rate)
	{
		super(pum, su, dan);
		this.rate=rate;
	}//slaepanmae
		
public void disp(){//���� ���̵� : ��� ���� �޼��� ���� ������.
	System.out.println(pum + "---" + su + "---" + dan);
	System.out.println("������:"+rate);
}//disp

}


class Test07_extends
{
	public static void main( String [] args ) 
	{
		PanMae a= new PanMae("���", 7, 1000);
		a.disp();
		System.out.println();
		
		SalePanMae7 b= new SalePanMae7("����", 10, 1000, 0.02);
		
		b.disp();
		
	}// end main
	
}//class end
