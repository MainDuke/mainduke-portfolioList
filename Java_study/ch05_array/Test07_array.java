/*
 * Author: Administrator
 * Created: 2016�� 1�� 21�� ����� ���� 11:20:20
 * Modified: 2016�� 1�� 21�� ����� ���� 11:20:20
 */


class Test07_array
{
	public static void main( String [] args )
	{
		int a[][]={{10, 20, 30},{40,50,60},{70,80,90}};
		
		System.out.println("�� ���� : "+a.length);
		System.out.println("a[0] : "+a[0].length);
		System.out.println("a[1] : "+a[1].length);
		System.out.println("a[2] : "+a[2].length);
		
		//�� �κ��� 2���� �迭�� Ư¡�� �׽�Ʈ �غ� ���� ������.
		int fe[][];
		fe= new int[3][4];
		
		System.out.println("fe.length:"+fe.length);
		System.out.println("fe1.length"+fe[1].length);
		System.out.println("fe1.length"+fe.length);
		
		
		System.out.println("--------------------------------------");
		
		
		
		int de[][]= {{1, 2, 3}, {4, 5}, {6, 7, 8, 9,}};
		System.out.println("de.length: "+de.length);
		System.out.println("de1.length: "+de[0].length);		
		System.out.println("de2.length: "+de[1].length);		
		System.out.println("de3.length: "+de[2].length);
		
		for(int i=0;i<de.length;i++)
		{
			for(int j=0;j<de[i].length;j++)
			{
				System.out.printf("de[%d][%d] = %d",i,j, de[i][j]);
				System.out.println();
			}
		}
	}// end main

}//class
