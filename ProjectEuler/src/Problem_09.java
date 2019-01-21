//피타고라스의 수 A^2+B^2=C^2 을 만족하는
//A+B+C=1000 값을 찾아서 AXBXC 값을 구하라.

public class Problem_09 {

	public boolean check(int a, int b, int c){
		
		if(Math.pow(a, 2)+Math.pow(b, 2)!=Math.pow(c, 2)){ //피타고라스 수가 아니라면 리턴 펄스.
			return false;
		}//판별식
		
		return true;
	}//custom.
	
	//해결은 했는데.... 속도가 느리다. 더 빨리 해결 할수 없을까??
	public Problem_09(){
		
		for (int i = 1; i < 500; i++) {//3중 for문이다.
			for (int j = 1; j < 500; j++) {//3중 for문이다.
				for (int k = 1; k < 500; k++) {//3중 for문이다.
					if(check(i, j, k)==true){//만약에, 피타고라스의 수를 만족하는 값이라면!
						if((i+j+k)==1000){ //피타고라스 수가 만족하는데, 세 수의 합이 1000 이라면!
							System.out.println("찾았따="+i+" "+j+" "+k); //그 값들을 출력한다.
							break;
						}	
					}//if end
					if((i+j+k)>1000){break;} //근데 만약에, IJK 값이 1000을 초과한다면 K 값 증가를 멈추고 I,J를 증가시킨후 다시 K값을 다시 증가시킨다.
					
					
				}//k for
			}//j for
		}//i for
		
		
	}//cons end
	
	public static void main(String[] args) {
		new Problem_09();
	}//end
	
	
}//class end
