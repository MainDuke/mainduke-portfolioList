
public class Problem_07 {//10001 ��° �Ҽ��� ���ϴ� ����.
	
	
		public static boolean check(int num){
			//���� num ���� �Ҽ����� �Ǻ��ϴ� �޼���
			if(num%2 ==0 && num != 2){ //2�� ������ �������� �͵��� 2�� �����ϰ� �Ҽ��� �ƴϴ�. 
				return false;
			}
			
			for(int a=2;a*a<=num;a++){ //N���� sqrt(N) ���Ϸ� ������ �������� �͵��� �Ҽ��� �ƴϴ�.
				if(num%a==0){
				return false;
				}//if
			}//for
			
			return true; //2���� ������ �����ϸ� ���� True
		}//check end
	
	  public static void main(String[] args) {
		
		  new Problem_07();
		  
		  int x=1; //�Ҽ��� �߰��Ҷ����� X ���� ���δ�.
		  int y=2; //2���� �Ҽ�ã�⸦ �����Ѵ�.
		  
		  while(x<=10001){
			  if(check(y)==true){
				  System.out.println(x+"��° �Ҽ� ="+y);
				  x++;
				  y++;
			  }else{
				  y++;
			  }
			  
		  }//while
		  
		  
		  
	}//main
	
}//class end
