/*
 * Author: Administrator
 * Created: 2016�� 1�� 20�� ������ ���� 11:13:29
 * Modified: 2016�� 1�� 20�� ������ ���� 11:13:29
 */


/*continue : �ݺ� loop�� �� ���� �����Ͱ� ���� �ǹ��̴�.
			�� �ٽ� ���� loop ����.
*/

class Test06_continue
{
	public static void main( String [] args )
	{
		for(int i=1;i<=10;i++)
		{
			if(1%2 == 0)continue;
			System.out.println(i+ " ");
			
		}//for end
		
	}// end main

}//class
