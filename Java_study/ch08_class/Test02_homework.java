/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 11:28:21
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 11:28:21
 */


/*
Test02_homework
�ֹι�ȣ�� �Է� �޾Ƽ� �������� �������� �����Ͽ� ����Ͻÿ�.
�Է��� main(String [] args) �� �μ��� �޴´�.

if �Ǵ� switch~case�� ���.

1����
2����
3����
4����

 */
import java.util.Scanner;

class Test02_homework
{
	public static void main( String [] args )
	{
		//		Integer.parseInt(args[0])
		//000000-0000000 (14�ڸ�)
		//01234567890123
		//0000000000000 (13�ڸ�)
		
		//if(args[0].length == ){
		
		System.out.print("�ֹε�� ��ȣ�� �Է��Ͻÿ�.");
		Scanner scanner = new Scanner(System.in);
		String s1= scanner.nextLine();
		
		int a1=s1.length();
		
		//scanner�� �̿��ؼ� �гο��� �μ��� ������ �ְ� �ڵ��ߴ�.
		//�׷��� main(String args[])�� �ް� �ʹٸ� �Ʒ��� ���� �ڵ��� �Ѵ�.
		
		/*
		String s1=args[0];
		int a1 = s1.length();
		*/ 
		
		
		//s1 �� �Է¹��� ���ڿ� ������ a1�� �־ if������ �Ǻ��Ѵ�.
		
		System.out.println();
		
		//���ڿ��� ������ �ľ��Ͽ�, ����. �ٸ��� ���� ã�´�.
		
		if(a1 == 14){		
			
			String s2=s1.substring(7,8);
			int q1 = Integer.parseInt(s2);
			
			//14�ڸ��� ���ڸ� �޾��� ���, 7��° ���ڸ� ���������� ��ȯ�Ͽ� 
			//�� ���� ��Ȯ�ϰ� �Ǻ��Ѵ�.
			//equals() �� �̿��Ͽ� ���� ��ȯ���� �׳� �Ǻ��� �ص� �ȴ�.
			//s2.equals("?") ���.
			
			if(q1 == 1){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else if(q1 == 2){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}
			else if(q1 == 3){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}
			else if(q1 == 4){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else{
				System.out.println("�߸��� �ֹε�� ��ȣ�Դϴ�.");
			}
		}else if(a1 == 13)
		{
			String s2=s1.substring(6,7);
			int q1 = Integer.parseInt(s2);
			
			if(q1 == 1){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else if(q1 == 2){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}
			else if(q1 == 3){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}
			else if(q1 == 4){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else{
				System.out.println("�߸��� �ֹε�� ��ȣ�Դϴ�.");
			}
		}
			else{//�߸��� ��ȣ�� �Է� �޾��� ���, ���.
				System.out.println("�߸��� �ֹε�� ��ȣ�Դϴ�.");
				System.out.println("13�ڸ� ��ȣ�� �Է����ֽðų�");
				System.out.println("000000-0000000 '-'�� �Է��ؼ� 14�ڸ��� �Է����ֽʽÿ�.");
		}
			
			System.out.println();
		}// end main
		
}//class end
	