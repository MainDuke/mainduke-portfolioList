/*
�Ǻ���ġ ������ ����, ¦���̸鼭 400�鸸 ������ ��� ���� ���Ͻÿ�.
�� ��Ƽ�� ����ؼ� 400�� ��° ���� ��� �Ϸ��� ������ ������ �߸� ���� ������ �ǰ�!
�׷��� ����Ƽ���� ������ ���ؼ� �ٽ� �����غ��� ����!.

��.
 */
import java.math.BigInteger;


class problem_02
{
	BigInteger sum = new BigInteger("0");
	BigInteger a= new BigInteger("0");
	BigInteger b= new BigInteger("0");
	BigInteger c= new BigInteger("0");	
	BigInteger d= new BigInteger("0");
	BigInteger e= new BigInteger("4000000");
	//long a=0;
	//long b=0;
	//long c=0;
	//long sum=0;
	
	
	public problem_02(){
			
		
		if(c.remainder(BigInteger.valueOf(2)).compareTo(d)==0)
		{
		sum=sum.add(c);
		}
		
		//System.out.println();
		
		
		
	
		
		
		/*
		if(c.remainder(BigInteger.valueOf(2)).compareTo(0)){
		System.out.print(c+" ");
		}//if end
		
		}//for end
		*/
		//System.out.println("sum = "+sum);
		
	}//cons end
	
	public void fivo(int num){
		
		if(num <= 1)
		{

			a=a.add(BigInteger.valueOf(0));
			b=b.add(BigInteger.valueOf(1));
			
			c=c.add(a);
			c=c.add(b);
		
			System.out.println();
			//big=big.add(a);
			//big=big.add(b);
		}else{
			//c=a+b;
			//a=b;
			//b=c;
			
			c=c.multiply(BigInteger.ZERO);
			c=c.add(a);
			c=c.add(b);
			
			a=b;
			
			b=c;
	
		}
		
	}//end custom
	
	
	public static void main( String [] args )
	{
		new problem_02();    
	}// end main
	
}//class end
