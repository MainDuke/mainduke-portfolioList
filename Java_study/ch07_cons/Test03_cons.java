/*
 * Author: Administrator
 * Created: 2016�� 1�� 25�� ������ ���� 3:33:06
 * Modified: 2016�� 1�� 25�� ������ ���� 3:33:06
 */


/*this : �ڽ��� ��ü�� ����Ų��.
this() : �ڽ��� Ŭ���� ���� ������ ȣ��.
this() �� super()�� ������ ������ ù���ѿ� ���� �ؾߵȴ�.
�̵��� ���ÿ� ����Ҽ� ����.*/


class Cons{
	//����
	String title;
	int num;

	
	//1.����Ʈ �����ڸ� �����ÿ�.
	public Cons(){}
	
	//2. ���� �ִ� ������.
	public Cons(String title, int num){
		this.title=title;
		this.num=num;
		System.out.println("Cons(String title, int num) call... ");
		System.out.println(title+"---"+num);
		
	}
	//3. ���� �ִ� ������.
	public Cons(String title){
		this(title, 200);//�μ��� �� ��ġ�ϴ� ������ ȣ��.
		System.out.println("Cons(String title) call... \n");
	}
}//class end

class Test03_cons
{
	public static void main( String [] args )
	{
		new Cons("����1");//3�� ȣ��.
		
		new Cons("����2", 300); //2�� ȣ��.
		
		
	}// end main

}//class end
