/*
피보나치 수열을 만들어서, 짝수이면서 400백만 이하의 모든 항을 더하시오.
빅 인티저 사용해서 400만 번째 숫자 계산 하려고 했으나 문제를 잘못 읽은 것으로 판결!
그러나 빅인티저의 사용법에 대해서 다시 생각해보게 됬음!.

굳.
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
