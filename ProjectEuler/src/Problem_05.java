import java.util.*;


//�Ҽ��� ���ϴ� �޼���

class Problem_05
{
	
	public static void getPrime(int num, ArrayList<Integer> prime) {
		
		prime.add(2); 
		
		for (int i = 2; i <= num; i++) {
			for (int j = 0; prime.size() > j; j++) {
			
				if (i % prime.get(j) == 0) break; // �Ҽ��� �ƴ� ��� pass
				
				if (j + 1 == prime.size()){ // �Ҽ��� ��
					
						if(i<num){						
						prime.add(i);
						}
				}//if end
			}//for j end
		}//for i end
		
	
		for (Integer result : prime) {
					
			System.out.print(result+" ");
		}
		
	}//end method
	
	public static void main(String[] args) {
		new Problem_05();
		
		ArrayList<Integer> prime = new ArrayList<Integer>();

		long start = System.currentTimeMillis();
		getPrime(20, prime);
		long end = System.currentTimeMillis();
		System.out.println("����ð� : " + (end - start));
	}
	

}
