public class Problem_06 {

	public Problem_06(){ //N������ �ڿ����� ���� ������ �Ϳ��� , N������ �ڿ����� �������� ���Ѱ��� �� ���� ���ϴ� �����̴�.
		
System.out.println(gop(100)-hap(100));
		
	}//cons
	
	public int hap(int num){ //N������ ���� ������ ���� Sum ���ٰ� ��� �����ִ� �޼����̴�.
		
		int sum=0;
		for(int i=1; i<=num;i++){
		sum+= Math.pow(i, 2);
		}//for end
		
		return sum;
	}//end hap
	
	public int gop(int num){ //N ������ ���� ���� ���� ����, Sum �� �������� �����Ѵ�.
		
		int sum=0;
		for(int i=1; i<=num;i++){
		sum += i;
		}//for end
		
		return (int)(Math.pow(sum, 2)); //Math.pow()�� ������ ��ȯ�̹Ƿ�, int Ÿ������ ĳ�������ش�.
	}//end hap
	
	public static void main(String[] args) {
		new Problem_06();
	}
	
	
}//class 
