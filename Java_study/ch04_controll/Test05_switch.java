/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 12:27:06
 * Modified: 2016�� 1�� 18�� ������ ���� 12:27:06
 */

/*����� �Է� �޾Ƽ�, ¦�� Ȧ�����Ǻ� �Ͻÿ�.*/

class Test05_switch
{

 public static void main( String [] args )
	{
	 	int su=Integer.parseInt(args[0]);
			switch(su%2){
			case 0:
				System.out.println(su+" = ¦�� ");
				break;
			case 1:
				System.out.println(su+" = Ȧ�� ");
				break;
			}//switch end.		
		
	}// end main
}//class end

