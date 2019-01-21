
public class Problem_12_re {

	
	    public static void main(String [] args){
	        int counter = 0;
	        int TriangleNumber = 0;
	        boolean Switch = true;
	        while(Switch == true){
	            counter ++;
	            TriangleNumber += counter;
	            if(Factors(TriangleNumber) > 500){
	                System.out.println(TriangleNumber);
	                Switch = false;
	            }
	        }
	         
	    }
	    public static int Factors(int n){
	        // Finds all the factors of a number (n)
	        // and returns the number of factors.
	        int counter = 0;
	        int k = (int) Math.sqrt(n);
	        for(int i = 1; i < k + 1; i ++){
	            if(n % i == 0){
	                counter ++;
	            }
	        }
	        return 2 * counter;
	    }
	 
	
	
}
