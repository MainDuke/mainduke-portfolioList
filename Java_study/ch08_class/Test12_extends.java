/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 12:46:28
 * Modified: 2016�� 1�� 27�� ������ ���� 12:46:28
 */

class PanMae12{
	//����
	protected String pum;
	protected int su;
	protected int dan;
	
	public PanMae12(String pum, int su, int dan)
	{
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}
	
	public void disp(){
		System.out.println(pum+"---"+su+"---"+dan);
	}
	
}//PanMae end

class SalePanMae12 extends PanMae12 {
	private double rate;
	public SalePanMae12(String pum, int su, int dan, double rate){
		super(pum, su, dan);
		this.rate=rate;
	}//Sale end
	public void disp(){
		
		System.out.println(pum+"---"+su+"---"+dan+"--"+(int)(dan*(1-rate)));
	}
}//class end

class Test12_extends
{
	public static void main(String args[]) 
	{
		PanMae12 p[]=new PanMae12[4]; //�迭 ����.
		
		p[0]=new PanMae12("���",7,700);
		p[1]=new SalePanMae12("���",10,1500,0.22);
		p[2]=new PanMae12("����",15,5000);
		p[3]=new SalePanMae12("����",3,20000,0.33);
		
		System.out.println();
		for(int i=0; i<p.length; i++)
		{
			p[i].disp();
			
		}			
		
		PanMae12 p2=new PanMae12("����", 9900, 2);
		
		p2.disp();
		
		
		p2=new SalePanMae12("��κ�붱",2, 15000, 0.15 );
		
		p2.disp();
		
	}//main end
}//class
