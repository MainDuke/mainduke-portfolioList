/*
�Ǻ���ġ ������ ����, ¦���̸鼭 400�鸸 ������ ��� ���� ���Ͻÿ�.

 */
import java.math.BigInteger;


class problem_02_re
{
	
	long a=0;
	long b=0;
	long c=0;
	long sum=0;
	
	
	public problem_02_re(){
		
		
		for(int i=1;i<=1000;i++)
		{
			if(c>4000000){
				break;
			}
								
			fivo(i);
			System.out.print(i+" ");
			System.out.println(" c : "+c);
			
			if(c % 2 ==0){
				sum+=c;
			}
			
		}
		System.out.println("sum = "+sum);
		
		//400�鸸 ������ ���� ������ �Ǻ���ġ ��������, ¦�� �׸� ���� ����� ��ȯ.
		//����. sum = 4613732
		
		
	}//cons end
	
	public long fivo(int num){
		
		if(num <= 1)
		{
			a=0;
			b=1;
		return num;
		
		}else{
			c=a+b;
			a=b;
			b=c;
			
			return c;
		}
		
	}//end custom
	
	
	public static void main( String [] args )
	{
		new problem_02_re();    
	}// end main
	
}//class end