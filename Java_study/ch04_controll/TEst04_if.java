/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 12:02:35
 * Modified: 2016�� 1�� 18�� ������ ���� 12:02:35
 */

/*���� if��
������ �Է� �޾Ƽ� ���� ���ϱ�
90~100:'A'
90~80: 'B'
80~70: 'C'
70~60: 'D'
59~0 : 'F'
 */

class TEst04_if
{
	public static void main( String [] args ) 
	{
		int jum = Integer.parseInt(args[0]);
		char grade=' '; //�ʱ�ȭ. ���� ���.
		
		if(jum <=100 && jum >=90)
		{
			grade='A';
		}else if(jum<90 && jum>=80)
		{
			grade='B';
		}
		else if(jum<80 && jum>=70)
		{
			grade='C';
		}
		else if(jum<70 && jum>=60)
		{
			grade='D';
		}
		else if(jum<60 && jum>=0)
		{
			grade='F';
		}
		else{
			System.out.println("���� �Է� ����");
		}
		
		//~~
		if(grade == ' '){
			System.out.println("������ 0~100 ���̸� �Է� �Ͻÿ�.");
		}else{
			System.out.println("���� :"+jum+" ���� :"+grade);
		}
		
		
		
	}// end main
	
}//class
