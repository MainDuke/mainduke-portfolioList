/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오후 2:46:25
 * Modified: 2016년 1월 27일 수요일 오후 2:46:25
 */

class PanMaeSuper{
	
	//변수
	
		protected String pum;
		protected int su;
		protected int dan;
		
	/*public PanMaeSuper(){
		
		System.out.println("PanMaeSuper default call");
	}*/
		//생성자
		public PanMaeSuper(String pum, int su, int dan){
		System.out.println("PanMaeSuper call");
			this.pum=pum;
			this.su=su;
			this.dan=dan;
			
		}
		
		//메서드
		public void disp(){
			System.out.println(pum+"---"+su+"---"+dan);
		System.out.println("disp1");
		}	
}//class -------

class SalePanMae2 extends PanMaeSuper
{
	//변수
	private double rate;//할인률.
	//생성자
	public SalePanMae2(String pum, int su, int dan, double rate){
	
	super(pum, su, dan); //call PanMaeSuper
	System.out.println("call SalePanMae2");
	this.rate=rate;
}
	//메서드 오버 라이딩.
	public void disp(){
			System.out.println(pum+"---"+su+"---"+dan+"---"+dan*(1-rate));
	System.out.println("disp2");
		
		}
	
	//메서드
	public void halinAk(){
		System.out.println("할인액 : "+dan*rate);
	}	
}//class -----------

class Test14_extends_casting
{
	public static void main(String args[]){
	
		PanMaeSuper p[]=new PanMaeSuper[4]; //배열 생성.
					
		System.out.println("--start--");
		p[0]=new PanMaeSuper("라면",7,700);
		System.out.println("p[0]");
		p[1]=new SalePanMae2("김밥",10,1500,0.22);
		System.out.println("p[1]");
		p[2]=new PanMaeSuper("파전",15,5000);
		System.out.println("p[2]");
		p[3]=new SalePanMae2("피자",3,20000,0.33);
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
