/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 9:28:29
 * Modified: 2016�� 1�� 21�� ����� ���� 9:28:29
 */

/*array (�迭)
�������� �ʱ�ȭ �ڵ����� �ȴ�. (�޼��� �ۿ� �ܺο��� ����� ����)
�������� ���α׷��Ӱ� ���� �ʱ�ȭ �ؾ��Ѵ�. (�޼��� ���ο��� ����� ����.)
�迭�� ������ ���� �ڵ� �ʱ�ȭ �ȴ�.
 */


class Test02_array
{
	
	static int a1; // ���� ����.
	
	public static void main( String [] args ) 
	{
		//�� Test�� ����� �迭�� �⺻��(default ���� �˾ƺ��� ���� ���̴�.
		
		int a2=0; // ���� ����. << ������ ���� �� ���ָ�  error�� ����. 
		//�׷��� 0���� �ʱ�ȭ.
		
		System.out.println("a1 :"+ a1);
		System.out.println("a2 :"+ a2);
		
		char ch[]= new char[3]; // ' ' �ʱ�ȭ.
		int n[]= new int[3]; //�迭 ����.
		double d[]=new double[3];
		boolean b[]= new boolean[3];
		String str[]=new String[3];
		
		System.out.println("	 ch[i]"+" n[i] "+ "d[i] " + "b[i] " + "str[i]");
		for(int i=0;i<n.length; i++)
		{
			
			System.out.println("i="+i+": "+ch[i]+"\t"+n[i]+"\t"+d[i]+"\t"+b[i]+"\t"+str[i]);
		}//for out
		
		System.out.println("ch.length:"+ch.length); //�迭 ����.
		System.out.println("n.length:"+n.length);
		System.out.println("b.length:"+b.length);
		System.out.println("d.length:"+d.length);
		System.out.println("str.length:"+str.length);
		
		
		
		
		
		

		
		
		
	
	}// end main
	
	
}//end class
