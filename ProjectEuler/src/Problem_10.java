
public class Problem_10 {
	
		public static boolean check(long num){
			//���� num ���� �Ҽ����� �Ǻ��ϴ� �޼���
			if(num%2 ==0 && num != 2){ //2�� ������ �������� �͵��� 2�� �����ϰ� �Ҽ��� �ƴϴ�. 
				return false;
			}
			
			for(long a=2;a*a<=num;a++){ //N���� sqrt(N) ���Ϸ� ������ �������� �͵��� �Ҽ��� �ƴϴ�.
				if(num%a==0){
				return false;
				}//if
			}//for
			
			return true; //2���� ������ �����ϸ� ���� True
		}//check end
	
	  public static void main(String[] args) {
		
		  new Problem_10();
		  
		  long x=1; //�Ҽ��� �߰��Ҷ����� X ���� ���δ�.
		  long y=2; //2���� �Ҽ�ã�⸦ �����Ѵ�.
		  long sum=0;
		  while(y<=2000000){
			  if(check(y)==true){
				  //System.out.println(x+"��° �Ҽ� ="+y);
				  		sum+=y;		  
				  y++;
			  }else{
				  y++;
			  }
			  			  
		  }//while
		  
		  System.out.println("sum= "+sum);
		  
	}//main
	
}//class end

