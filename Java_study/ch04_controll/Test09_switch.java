/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 3:18:43
 * Modified: 2016�� 1�� 18�� ������ ���� 3:18:43
 */


//���� �Է±�� : java.util.Scanner Ŭ������ ���.

import java.util.Scanner;

class Test09_switch
{
	public static void main( String [] args ) 
	{
		//Scanner ��� �Է� ��ƿ�� ������. �ڹ� 5�������� ����.
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է� �Ͻÿ�.");
		int month=scanner.nextInt();
		
		int days=0;
		
		switch(month)
		{
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days=31;
			break;
		case 2:
			days=28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
		
		}
		System.out.println(month +"���� "+days+"�� ���� �ֽ��ϴ�.");
		
		
		
	}// end main

}//class end
