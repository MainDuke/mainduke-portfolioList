/*
 * Author: Administrator
 * Created: 2016�� 1�� 15�� �ݿ��� ���� 4:11:55
 * Modified: 2016�� 1�� 15�� �ݿ��� ���� 4:11:55
 */


//���� ������
//= += -= *= /= %=




class Test05
{
	public static void main( String [] args ) 
	{
		
		int x, y;
		x=5;
		y=2;
		
		
		//�����ϱ� ���� �������� ��ȭ�� ������ Ȯ���ϸ鼭 �����ڿ� ���ؼ� �����ϱ� ���� ����.
		System.out.println("x+=Y :"+(x+=y));
		
		System.out.println("x1 :"+x);
		System.out.println("y1 :"+y);
		
		
		System.out.println("x-=Y :"+(x-=y));
		System.out.println("x2 :"+x);
		System.out.println("y2 :"+y);		
		
		
		System.out.println("x*=Y :"+(x*=y));
		
		System.out.println("x3 :"+x);
		System.out.println("y3 :"+y);
		
		System.out.println("x/=Y :"+(x/=y));
		
		System.out.println("x4 :"+x);
		System.out.println("y4 :"+y);
		
		System.out.println("x%=Y :"+(x%=y));
		
		System.out.println("x5 :"+x);
		System.out.println("y5 :"+y);
		
		
		System.out.println("-----------------------------------");
		
		//���� ������.
		System.out.println(5>3?5:3);
		System.out.println(5<3?5:3);
		
		int a=10, b=5;
		int c=(a>b)?a:b;
		System.out.println("c:"+c);
		
		
		
		
	}// end main
	
}//class end
