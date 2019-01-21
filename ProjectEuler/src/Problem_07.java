
public class Problem_07 {//10001 번째 소수를 구하는 문제.
	
	
		public static boolean check(int num){
			//들어온 num 값을 소수인지 판별하는 메서드
			if(num%2 ==0 && num != 2){ //2로 나누어 떨어지는 것들은 2를 제외하고 소수가 아니다. 
				return false;
			}
			
			for(int a=2;a*a<=num;a++){ //N값의 sqrt(N) 이하로 나누어 떨어지는 것들은 소수가 아니다.
				if(num%a==0){
				return false;
				}//if
			}//for
			
			return true; //2가지 조건을 만족하면 리턴 True
		}//check end
	
	  public static void main(String[] args) {
		
		  new Problem_07();
		  
		  int x=1; //소수를 발견할때마다 X 값을 먹인다.
		  int y=2; //2부터 소수찾기를 시작한다.
		  
		  while(x<=10001){
			  if(check(y)==true){
				  System.out.println(x+"번째 소수 ="+y);
				  x++;
				  y++;
			  }else{
				  y++;
			  }
			  
		  }//while
		  
		  
		  
	}//main
	
}//class end
