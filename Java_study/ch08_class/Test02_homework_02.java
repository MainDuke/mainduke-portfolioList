//equals() ����ؼ� Ǯ�.


import java.util.Scanner;

class Test02_homework_02
{
	public static void main( String [] args )
	{
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
		//���ڿ��� ������ �ľ��Ͽ�, ����. �ٸ��� ���� ã�´�.
		
		System.out.println();
		
		if(a1 == 14){		
			
			String s2=s1.substring(7,8);
			
			//14�ڸ��� ���ڸ� �޾��� ���, 7��° ���ڸ� ���������� ��ȯ�Ͽ� 
			//�� ���� ��Ȯ�ϰ� �Ǻ��Ѵ�.
			//equals() �� �̿��Ͽ� ���� ��ȯ���� �׳� �Ǻ��� �ص� �ȴ�.
			//s2.equals("?") ���.
			
			if(s2.equals("1") || s2.equals("3")){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else if(s2.equals("2") || s2.equals("4")){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else{
				System.out.println("�߸��� �ֹε�� ��ȣ�Դϴ�.");
			}
		}else if(a1 == 13)
		{
			String s2=s1.substring(6,7);
			
			if(s2.equals("1") || s2.equals("3")){
				System.out.println(args[0]);
				System.out.println("�����Դϴ�.");
			}else if(s2.equals("2") || s2.equals("4")){
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
