

public class Problem_12 {

	 static int count=0;
		
	//�ﰢ���� �̷��� �ص� �������� �Ѵ�...
	//�׷��� �ﰢ���� n������ ��� �ڿ����� �� ��, n(n+1)/2 �� ǥ���� �����ϴ�.
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
		
		//System.out.println("����� ���� : "+count+" X="+num);
			
	
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
