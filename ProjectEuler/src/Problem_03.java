/*
���μ� ���� ���Ѵ���, ���� ū ���μ��� ã�Ƴ��� ����̴�.
ū �ڷ�Ÿ���� ���. �ڷ� �ڿ� L ���� �־��ش�.
(2) ����� ������ �� (literal)

Java������ ��������� ����ϴ� ���ͷ� ���� ����Ѵ�.

Java�� ���� ���ͷ��� int Ÿ���̴�. long Ÿ���� ǥ���ϱ� ���ؼ��� ���� ���� L �̳� l �� �ٿ��ش�.

int age = 20;
long bigdata = 86127531235L;

�ε� �Ҽ��� ���ͷ��� double ���̴�. float Ÿ���� ǥ���ϱ� ���ؼ��� ���� ���� F�� f�� ���δ�.

double delta = 453.523311903;
float ratio = 0.2363F;

 */


class Problem_03
{
	long a;
	int b;
	long x= 600851475143L; //�ڿ� L ���� �ٿ��ش�.
	long arr[]=new long[100];
	long or;
		
	public Problem_03(){
			
		or=x;
		a=2;
		b=0;
		
		while(x>1){
		
		if(x%a==0){
				
			x=x/a;
			arr[b++]=a;
			
		}
		if(x%a !=0 ){a++;}
		
		
	}//while end
	if(or!=1){
		for(int i=0;i<b;i++){
			System.out.print(arr[i]+" ");
		}	
		
	}

	}//cons end
	
	public static void main( String [] args )
	{
		new Problem_03();
	}// end main

}
