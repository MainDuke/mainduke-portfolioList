//��Ÿ����� �� A^2+B^2=C^2 �� �����ϴ�
//A+B+C=1000 ���� ã�Ƽ� AXBXC ���� ���϶�.

public class Problem_09 {

	public boolean check(int a, int b, int c){
		
		if(Math.pow(a, 2)+Math.pow(b, 2)!=Math.pow(c, 2)){ //��Ÿ��� ���� �ƴ϶�� ���� �޽�.
			return false;
		}//�Ǻ���
		
		return true;
	}//custom.
	
	//�ذ��� �ߴµ�.... �ӵ��� ������. �� ���� �ذ� �Ҽ� ������??
	public Problem_09(){
		
		for (int i = 1; i < 500; i++) {//3�� for���̴�.
			for (int j = 1; j < 500; j++) {//3�� for���̴�.
				for (int k = 1; k < 500; k++) {//3�� for���̴�.
					if(check(i, j, k)==true){//���࿡, ��Ÿ����� ���� �����ϴ� ���̶��!
						if((i+j+k)==1000){ //��Ÿ��� ���� �����ϴµ�, �� ���� ���� 1000 �̶��!
							System.out.println("ã�ҵ�="+i+" "+j+" "+k); //�� ������ ����Ѵ�.
							break;
						}	
					}//if end
					if((i+j+k)>1000){break;} //�ٵ� ���࿡, IJK ���� 1000�� �ʰ��Ѵٸ� K �� ������ ���߰� I,J�� ������Ų�� �ٽ� K���� �ٽ� ������Ų��.
					
					
				}//k for
			}//j for
		}//i for
		
		
	}//cons end
	
	public static void main(String[] args) {
		new Problem_09();
	}//end
	
	
}//class end
