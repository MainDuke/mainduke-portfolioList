import java.math.BigInteger;
import java.util.*;

public class Problem_16 {

	public static void main(String[] args) {
		
	//BigInteger aa = new BigInteger((String)Math.pow(2, 1000));
	//System.out.println(Math.pow(2, 1000));
	//int a= (int)Math.pow(2, 10);
		int sum=0;
      String str=(int)Math.pow(2, 10)+"";
      BigInteger aa = new BigInteger(str);
      BigInteger bb = new BigInteger("1");
      
      for(int i=1;i<=100;i++){
    	  
    	  bb = bb.multiply(aa);
    	  
      }//end
      String str2=bb.toString();
      
      for(int i=0;i<str2.length();i++){
    	 sum += (str2.charAt(i)-48);
      }
      
      
      System.out.println(sum);
      
      
      
	}//main
	
}//class end
