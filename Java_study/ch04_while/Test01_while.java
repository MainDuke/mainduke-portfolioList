/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 4:20:44
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 4:20:44
 */


class Test01_while
{
	public static void main( String [] args ) 
	{
		//1.�����̸� 5�� ���.
		System.out.println();
		int i = 1;
		while(i<=5)
		{
			System.out.print("��â�� ");
			i++;

						}
		
		//2.1~10���� ����ϱ�.
		i=1;
		
		System.out.println();
		System.out.println("------------------------Test01_while_q2");
		System.out.println();
		
		while(i<=10)
		{
			System.out.print(i + " ");
			i++;
			
		}
		
		//3. 1~20���� ¦���� ���.
		i=1;
		
		System.out.println();
		System.out.println("------------------------Test01_while_q3");
		System.out.println();
		
		while(i<=20)
		{
			if(i%2 == 0){
			System.out.print(i + " ");
			}
			
			i++;
		
		}
		System.out.println();
		
	}// end main

}//class end
