/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 10:49:39
 * Modified: 2016�� 1�� 21�� ����� ���� 10:49:39
 */



//Test06_array 
//���ڿ��� �� ���� ��ҷ� �����ϱ�.

class Test06_array
{
	public static void main( String [] args )
	{
		String str="Good-Morning-kildong";
		char ch[]=new char[str.length()];
		
		str.getChars(5,12,ch,2);//5�� ���ڷκ��� 12���������� ch[2]���� ��Ҹ� �ִ´�.
								//5~11 ���� �Է��� �Ǵ°��̴�. Java�� Ư¡.
		
		System.out.println();   
		System.out.println(str);
		System.out.println();
		
		for(int i=0;i<ch.length;i++)
		{
			System.out.print(ch[i]);
		}//for out
		
		System.out.println();
		
	}// end main

}//class
