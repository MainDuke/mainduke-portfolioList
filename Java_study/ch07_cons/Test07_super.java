/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 10:21:10
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 10:21:10
 */

//super() :  ���� Ŭ������ ������ ȣ��. super()�� Ŭ���� ù�ٿ� ����.
//super : ���� Ŭ���� ��ü

class ConSuper{
	String title;//����.
	int num;
	
	public ConSuper(){}//����Ʈ ������.
	
	
	public ConSuper(String title, int num){
		
		this.title=title;
		this.num=num;
	}//ConSuper end
	
	public void disp(){
		System.out.println(title+"---"+num);
	}	//disp end
}//class end===========

//�Ļ� Ŭ���� : ��� �޴� �����̴�.
class ConSub extends ConSuper{		
	
	public ConSub(){
	
	//super("abc", 12);
}
	//���࿡ super("abc", 123) ������
	//����Ʈ �����ڸ� ȣ���Ѵ�.	
}//Consub end

class Test07_super
{
	public static void main( String [] args ) 
	{
		ConSub sub= new ConSub();
		sub.disp();
		
	}// end main
	

}//class
