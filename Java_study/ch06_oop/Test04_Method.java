/*
 * Author: Administrator
 * Created: 2016�� 1�� 22�� �ݿ��� ���� 10:49:27
 * Modified: 2016�� 1�� 22�� �ݿ��� ���� 10:49:27
 */


class Demo04
{
	public int sum(int a, int b){
		int s=a+b;
		return s;
	}//sum end
	
	public double sum(double a, double b){
		double s=a+b;
		return s;
	}//sum end
	
	
	public String getName(String name){
	String str="����� �̸��� "+name+" �Դϴ�.";
	return str;
	
	}
		

}//Demo03 end

class Test04_Method
{
	public static void main(String args[]){
		
	Demo04 d4= new Demo04();
	
	int s1=d4.sum(3,7);
	double s2=d4.sum(3.3,5.6);
	String msg=d4.getName("��â��");
	
	System.out.println("s1 : "+s1);
	System.out.printf("s2 : %5.2f", s2);
	System.out.println();
	System.out.println("msg : "+msg);
	
	
			
	}//end main
	
}//class end
