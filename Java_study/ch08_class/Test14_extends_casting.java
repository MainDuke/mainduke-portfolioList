/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 2:46:25
 * Modified: 2016�� 1�� 27�� ������ ���� 2:46:25
 */

class PanMaeSuper{
	
	//����
	
		protected String pum;
		protected int su;
		protected int dan;
		
	/*public PanMaeSuper(){
		
		System.out.println("PanMaeSuper default call");
	}*/
		//������
		public PanMaeSuper(String pum, int su, int dan){
		System.out.println("PanMaeSuper call");
			this.pum=pum;
			this.su=su;
			this.dan=dan;
			
		}
		
		//�޼���
		public void disp(){
			System.out.println(pum+"---"+su+"---"+dan);
		System.out.println("disp1");
		}	
}//class -------

class SalePanMae2 extends PanMaeSuper
{
	//����
	private double rate;//���η�.
	//������
	public SalePanMae2(String pum, int su, int dan, double rate){
	
	super(pum, su, dan); //call PanMaeSuper
	System.out.println("call SalePanMae2");
	this.rate=rate;
}
	//�޼��� ���� ���̵�.
	public void disp(){
			System.out.println(pum+"---"+su+"---"+dan+"---"+dan*(1-rate));
	System.out.println("disp2");
		
		}
	
	//�޼���
	public void halinAk(){
		System.out.println("���ξ� : "+dan*rate);
	}	
}//class -----------

class Test14_extends_casting
{
	public static void main(String args[]){
	
		PanMaeSuper p[]=new PanMaeSuper[4]; //�迭 ����.
					
		System.out.println("--start--");
		p[0]=new PanMaeSuper("���",7,700);
		System.out.println("p[0]");
		p[1]=new SalePanMae2("���",10,1500,0.22);
		System.out.println("p[1]");
		p[2]=new PanMaeSuper("����",15,5000);
		System.out.println("p[2]");
		p[3]=new SalePanMae2("����",3,20000,0.33);
		System.out.println("p[3]");
		
		for(int i=0; i<p.length; i++)
		{
			p[i].disp();
			System.out.println("p["+i+"].disp call");
				if(p[i] instanceof SalePanMae2){
				((SalePanMae2)p[i]).halinAk();}
			
		}	
		
		
		System.out.println("====================");
		System.out.println(p[1].dan);
		System.out.println(p[1].su);
		
		
	
	}//main end

}//class end
