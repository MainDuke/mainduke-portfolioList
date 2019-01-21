

public class Problem_12 {

	 static int count=0;
		
	//삼각수를 이렇게 해도 구해지긴 한다...
	//그러나 삼각수는 n까지의 모든 자연수의 합 즉, n(n+1)/2 로 표현이 가능하다.
	public int samgak(int num){
		
		int sum=0;
		for(int i=1;i<=num;i++){
			sum+=i;
		}//for
		return sum;
	}//end samgak
	
	public static int check(int num){
		count=0;
		
		int temp=(int)Math.sqrt(num);
		
			for(int i=1;i<=temp+1;i++){
				if(num%(i)==0){
				   count++;							
				}//if
			}//for
		
		//System.out.println("약수의 갯수 : "+count+" X="+num);
			
	
		return count*2;
	}//check end

	
	public static void main(String[] args) {
		
		int x=0;
		int tri=0;
		boolean xt=true;
		while(xt == true){
			x++;
			tri += x;
			if(check(tri) > 500){
						System.out.println(tri);
						xt=false;
			}
	
		}//while
		
	}
	
}//class end
