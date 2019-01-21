/*
 * Author: Administrator
 * Created: 2016�� 1�� 18�� ������ ���� 10:11:00
 * Modified: 2016�� 1�� 18�� ������ ���� 10:11:00
 */

//2016.01.18 �� ��������, CH03_Test06 ���� ���ڿ� �� ������.

class Test06
{
	public static void main( String [] args ) 
	{
		
		String str="hello";
		System.out.println(str.equals("hello"));//true
		System.out.println(str.equals("Hello"));//false
		System.out.println(str.equalsIgnoreCase("Hello"));//true
		//equalsIgnoreCase �� ��ҹ��� ���� ���� �ʴ´�.
		System.out.println("==========================first end");
		
		//����? ���Ŀ����ڷ� ��Ʈ���� �� �Ҽ� �ִ°�?
		System.out.println(str==("hello"));//true
		System.out.println(str==("Hello"));//true
		
		//�ȴ�?... JPad ���� ���� ȿ���ΰ�??
		
		System.out.println("==========================second end");
		
		String str2=new String("hello");
		System.out.println(str=="hello");//true
		System.out.println(str==("Hello"));//false
		System.out.println(str==str2);//false
		
		
		System.out.println("==========================3th end");
		
		String s1="hello"; //�Ϲ��Լ�ó�� ���.
		String s2="hello"; //�Ϲ� �Լ�ó�� ���.
		System.out.println("s1=s2?"+(s1==s2));//true
		
		System.out.println("==========================4th end");
		
		
		String s3 = new String("hello"); //��ü ����.
		String s4 = new String("hello"); //��ü ����.
		
		System.out.println("s3=s4?"+(s3==s4));//false
		//Why? ��ü�� �ٸ��� == �� �޸� �ּҸ� ������ �Ѵ�. �׷��Ƿ� false�� ���´�.
		
		
		System.out.println("==========================5th end");
		
		System.out.println("s3.equals(s4)? : "+(s3.equals(s4)));//false
		//Why? �׷���, equals()�޼���� ���ڿ� ��ü�� ���ϹǷ� ��ü�� �޶� True ������ �޴´�.
		
		System.out.println("==========================6th end");
		System.out.println("---Instanceof---");
		
		Object ob=new Object(); //Object�� �ֻ��� Ŭ�����̴�.
		String str5=new String("abc");
		System.out.println(ob instanceof Object);//true
		//                       ==  
		System.out.println(str5 instanceof String);//true
		//                          ==		
		System.out.println(str5 instanceof Object);//true
		//							<
		System.out.println(ob instanceof String);// false
		//							>
				/*
		System.out.println(str5 instanceof StringBuffer);// false
		�ƹ� ���� ���� Ŭ������ �� ����= ����.
		 */
		
		
		
	}// end main
	
}
