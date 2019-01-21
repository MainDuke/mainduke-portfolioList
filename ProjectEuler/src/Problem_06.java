public class Problem_06 {

	public Problem_06(){ //N까지의 자연수의 합을 제곱한 것에서 , N까지의 자연수의 제곱들을 합한것을 뺀 값을 구하는 문제이다.
		
System.out.println(gop(100)-hap(100));
		
	}//cons
	
	public int hap(int num){ //N까지의 값을 제곱한 다음 Sum 에다가 계속 더해주는 메서드이다.
		
		int sum=0;
		for(int i=1; i<=num;i++){
		sum+= Math.pow(i, 2);
		}//for end
		
		return sum;
	}//end hap
	
	public int gop(int num){ //N 까지의 값을 전부 합한 다음, Sum 의 제곱값을 리턴한다.
		
		int sum=0;
		for(int i=1; i<=num;i++){
		sum += i;
		}//for end
		
		return (int)(Math.pow(sum, 2)); //Math.pow()는 더블형 반환이므로, int 타입으로 캐스팅해준다.
	}//end hap
	
	public static void main(String[] args) {
		new Problem_06();
	}
	
	
}//class 
