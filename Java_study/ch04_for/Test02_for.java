/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 4:44:49
 * Modified: 2016�� 1�� 18�� ������ ���� 4:44:49
 */


class Test02_for
{
	public static void main( String [] args )
	{
	//�� 10 ~ 1 ���� ���� ���.
		
	for(int i=10; i>0; i--)
	{System.out.print(i+" ");	}
	System.out.println();
	System.out.println("-----------------------");
	
	
	
	
	//��2. 1~10���� ¦���� ����Ͻÿ�.
	//for,if�� ���.
	for(int i=1; i<=10; i++)
	{
		if(i%2==0){System.out.print(i+" ");	}
	}	
	System.out.println();
	System.out.println("-----------------------");
	
	//����3. 1~50���� 7�� �����!
	
	for(int i=1; i<=50; i++)
	{
		if(i%7==0){System.out.print(i+" ");	}
	}	
	
	System.out.println();
	System.out.println("-----------------------");
	
	//����4. 1~1000����.
	for(int i=1; i<=1000; i++)
	{
		if(i%170==0){System.out.print(i+" ");	}
	}	
	
	System.out.println();
	
	
	
	}// end main


}//class end