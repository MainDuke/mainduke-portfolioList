/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 4:25:34
 * Modified: 2016�� 1�� 18�� ������ ���� 4:25:34
 */

//for(�ʱ�ġ;����(����ġ);����ġ){
//�ݺ�ó���� ����;
//}


class Test01_for
{
	public static void main(String args[])
	{//1.good 5�� ���.
		for(int i=1; i<=5; i++){
			System.out.println("good");
		}
		System.out.println(); // line skip= �ٹٲ�.
		
		//2. ���� (1 2 3 5 ....10����.)���.
		
		for(int i=1; i<=10; i++){
			System.out.print(i+" ");
		}
		
		/*3. ���� ������ ���� ���.
		for
		i=1
		i=2
		.
		.
		.
		i=10
		 */
		System.out.println();
		System.out.println("==============================next");
		
		for(int i=1; i<=10; i++){
			System.out.println("i = "+i);
		}
		
		//for�� �ȿ��� ����� ������ ���������̴�. ��, for�� �ۿ��� ȣ���� �ȵ�.
		
		
	}//main end
}//class end.
