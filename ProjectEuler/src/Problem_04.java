/*
 * Author: Administrator
 * Created: 2016�� 4�� 14�� ����� ���� 1:50:30
 * Modified: 2016�� 4�� 14�� ����� ���� 1:50:30
 */


class Problem_04
{
	
	public Problem_04(){
		
		int max=0;
		int a=0;
		int b=0;
		
		for(int i=100;i<1000;i++)// 3�ڸ��� ��!
		{
			for(int j=100;j<1000;j++)
			{
				
				String str=Integer.toString(i*j); //������ ���ڿ��� �ٲ㼭 
				String nstr=new StringBuilder(str).reverse().toString(); //���ڿ��� �����´�.
				
				if(str.equals(nstr)){ //���� ��Ī ��Ų ���� ��ġ�Ѵٸ�
					int num=Integer.parseInt(str);
					if(num>max){ //����� max ������ Ȯ�ε� num���� ũ�ٸ�, max ���ٰ� num�� �����Ѵ�.
						max=num;
						break;
					}
					
						
				}//	
						
				}
			}//for
System.out.println(max); //���������� for���� ��������, max �� ����� ���� ��������.
		
	}//cons
public static void main( String [] args ) 
{
	new Problem_04();
}// end main

}//class end
