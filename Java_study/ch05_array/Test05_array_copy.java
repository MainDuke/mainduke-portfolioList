/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 10:37:44
 * Modified: 2016�� 1�� 21�� ����� ���� 10:37:44
 */


//System.arraycopy ����

class Test05_array_copy
{
	public static void main( String [] args )
	{
		int a[] = {1,3,5,7,9,11};
		int b[] = new int[a.length]; //�迭�� ���������� �ڵ� �ʱ�ȭ �ȴ�.
		System.arraycopy(a,1,b,2,3); // a[1]���� 3�� b[2]�� ����.
		//System.arraycopy(�迭, ��������, ����������� �迭, ���� �������� �迭�� ��������, ���� ����)
		
		for(int i =0;i<a.length;i++)
		{
			System.out.println(a[i]+"=="+b[i]);
		}
		
	}// end main

}//claas end
