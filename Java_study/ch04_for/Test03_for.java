/*
 * Author: Administrator
 * Created: 2016�� 1�� 19�� ȭ���� ���� 9:36:47
 * Modified: 2016�� 1�� 19�� ȭ���� ���� 9:36:47
 */


class Test03_for
{
	public static void main(String args[])
	{
		//����1. 1~10���� �� ���ϱ�.
		int sum=0;
		for(int i=1; i<=10; i++){
			sum+=i;//sum=sum+i
		}//for
			System.out.println("1~10������ �� : " +sum);
			System.out.println(); //line skip
			
		
		//����2. 1~20���� ¦�� �� ���ϱ�.
		//if�� ���.
		int sum2 =0;
		
		for(int i=1; i<=20; i++){
			
			if(i%2 == 0){
				sum2 +=i;
				System.out.println(i);
				}//if
			}//for
		System.out.println("1~20������ ¦���� �� : " +sum2);
		System.out.println(); //line skip
		
		//����3 1~1000, 127�� ����� �� ���ϱ�.
		int sum3=0;
		
		
		for(int i=1; i<=1000; i++){
			
			if(i%127 == 0){
				sum3 +=i;
				System.out.println(i);
			}//if
		}//for
		System.out.println("1~1000������ 127����� �� : " +sum3);
		System.out.println(); //line skip
		
		
		
		
		
		
			
	}//main end
	
}//class end
