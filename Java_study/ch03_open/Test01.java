/*
 * Author: Administrator
 * Created: 2016�� 1�� 15�� �ݿ��� ���� 12:15:19
 * Modified: 2016�� 1�� 15�� �ݿ��� ���� 12:15:19
 */


class Test01
{public static void main( String [] args ) {
		//��� ������
		
		int a =5;
		int b =3;
		
			int s1=a+b;
			int s2=a-b;
			int s3=a*b;
			int s4=a/b; //����/����=����.
						//����/�Ǽ�=�Ǽ�.
			int s5=a%b;//������.
			
		System.out.println("s1 :"+s1);
		System.out.println("s2 :"+s2);
		System.out.println("s3 :"+s3);
		System.out.println("s4 :"+s4);
		System.out.println("s5 :"+s5);
		System.out.println("-----------------");

		int c=5;
		int d=5;
		
		System.out.println("++c :"+(++c)); //��������.
		System.out.println("--d :"+(--d));
		c=5;
		d=5;
		
		System.out.println("c++ :"+(c++)); //��������.
		System.out.println("d-- :"+(d--)); 
		
		int e=5;
		int f=++e + ++e;
		System.out.println("f :"+f);
		
		for(int i=1; i<=10;i++){
			System.out.println(i+" ");
		}	
	
	}
}// end main
