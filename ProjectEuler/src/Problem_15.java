
public class Problem_15 {

	
	public static double factorial(double num){
		
		double sum=1;
		
		for(double i=1;i<=num;i++){
			sum*=i;
		}//for end
	
		return sum;
	}//factorial end
	
	
	public static void main(String[] args) {
		
		System.out.println("40!= "+factorial(40));
		
		System.out.println("20!= "+factorial(20));
		System.out.println("20!= "+factorial(20));
		
		System.out.println("40!/20!*20!");
		System.out.println(factorial(40)/(factorial(20)*factorial(20)));
		
	}//main
	
}//class end
