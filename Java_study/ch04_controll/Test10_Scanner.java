/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 3:37:11
 * Modified: 2016�� 1�� 18�� ������ ���� 3:37:11
 */

import java.util.Scanner;
class Test10_Scanner
{ public static void main( String [] args ) 
	{
		//Scanner ��� �Է� ��ƿ�� ������. �ڹ� 5�������� ����.
		System.out.print("�̸��� �Է��Ͻÿ�.");
		Scanner scanner = new Scanner(System.in);
		String name= scanner.nextLine();
				
		System.out.print("���̸� �Է��Ͻÿ�.");
		Scanner scanner2 = new Scanner(System.in);
		int age= scanner2.nextInt();
		
		System.out.print("Ű�� �Է��Ͻÿ�.");
		Scanner scanner3 = new Scanner(System.in);
		double height= scanner3.nextDouble();
		
		//printf
		System.out.printf("%s %d %7.1f\n",name, age, height);	//%s�� ���ڿ� ���.
		//%d �� ���� ���.
		//%f�� �Ǽ� ���.
		//%7.1f ��ü �ڸ���. �Ҽ������ڸ���f
			
}// end main

}//class end