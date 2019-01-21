
public class Problem_14 {

	public static long check(long num){
		
		long temp=num;
		long count=1;
		while(true){
			if(temp==1){break;}
			
			if(temp%2 ==0){
				//System.out.println("temp2 =" + temp);
				temp=temp/2;
				count++;
			}else{
				//System.out.println("temp3 =" + temp);
				temp=3*temp+1;
				count++;
			}//else end
		
		}//while
		
		return count;
		
	}//cal
	
	public static void main(String[] args) {
	
		//System.out.println(check(100000));
		
		
		long a=0;
		for(long i=1;i<=1000000;i++){
			
			
			
			if(a<check(i)){
				a=check(i);
				System.out.println("a 갱신한 i 값="+i+" A값="+a);
			}//if
			
			
		}//end
		
	}//main end


}//class end
