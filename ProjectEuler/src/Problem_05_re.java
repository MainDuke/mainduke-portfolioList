
public class Problem_05_re {
	
	    public static void main(String[] args) {
	        int result = 0;

	        for (int i = 5; ; i++) {
	            if (test(i) == true) {
	                if (result < i) {
	                    result = i;
	                    break;
	                }
	            }
	        }
	        System.out.println(result);
	    }

	    public static boolean test(int val) {
	        for (int k = 1; k < 5; k++) {
	            if (val % k != 0) {
	            	System.out.println(val);
	            	return false;
	            }
	        }
	        return true;
	    }
}//class

