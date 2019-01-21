/*
소인수 값을 구한다음, 가장 큰 소인수를 찾아내는 방법이다.
큰 자료타입의 경우. 자료 뒤에 L 값을 넣어준다.
(2) 명시적 데이터 값 (literal)

Java에서는 명시적으로 사용하는 리터럴 값을 사용한다.

Java의 정수 리터럴은 int 타입이다. long 타입을 표현하기 위해서는 숫자 끝에 L 이나 l 을 붙여준다.

int age = 20;
long bigdata = 86127531235L;

부동 소수점 리터럴은 double 형이다. float 타입을 표현하기 위해서는 숫자 끝에 F나 f를 붙인다.

double delta = 453.523311903;
float ratio = 0.2363F;

 */


class Problem_03
{
	long a;
	int b;
	long x= 600851475143L; //뒤에 L 값을 붙여준다.
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
