/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 2:17:40
 * Modified: 2016�� 1�� 18�� ������ ���� 2:17:40
 */

/*������ �Է��Ͽ� ���� ���ϱ�.*/

class Test06_switch
{
	public static void main( String [] args ) 
	{
		int jum = Integer.parseInt(args[0]);
		char grade= ' '; //���� �ʱ�ȭ.
		
		
		
		switch(jum/10){
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade= 'F';
			}//switch end
		
		if(jum>100 || jum<0){
			System.out.println("0~100 ���̸� �Է��Ͻÿ�.");
		}
		else {
			System.out.println("���� : "+jum+"  ���� : "+grade);
		}
		
	}// end main

}//class end
