/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 2:46:58
 * Modified: 2016�� 1�� 18�� ������ ���� 2:46:58
 */

/*��(��)�� �Է¹޾�, �״��� �� �� ���ϱ�.*/

import java.io.*;
class Test08_switch
{
	public static void main( String [] args ) throws IOException		
	{
		String monthstr;//��(��)�� �Է� �޾� ����.
		int month;//
		int days=0;// �� �Է� ����.
		
		
		BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
				//�ѱ��ھ�  �о ���ۿ� ����.
				
		System.out.print("�� �Ǵ� ���� �Է��ϼ���.");
		monthstr = buff.readLine();//���� ������ �д´�.
		month=Integer.parseInt(monthstr); //���ڿ��� ������ ��ȯ.
		
		
		switch(month){
		case 1:	case 3: case 5:	case 7:	case 8:	case 10: case 12:
			days=31;
			break;
		case 2:
			days= 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
		}//switch end
		
		System.out.println(month +"���� "+days+"�� ���� �ֽ��ϴ�.");
		
		
		
		
	}// end main
	
}//class end
