/*
 * Author: Administrator
 * Created: 2016년 1월 15일 금요일 오전 10:36:30
 * Modified: 2016년 1월 15일 금요일 오전 10:36:30
 */


class Test06
{
public static void main(String args[])
	{
	//float a1 =12.5; 에러.
	
	float a2 =(float)12.5;
	int a3=(int)12.5;
	char ch=(char)65;
	
	System.out.println("a2:"+a2);
	System.out.println("a3:"+a3);
	System.out.println("ch:"+ch);
	
	
	//boolean
	boolean b1=true;
	boolean b2=false;
	System.out.println("b1:"+b1);
	System.out.println("b2:"+b2);
	
	//null=="" 공백도 아니고 0도 아닌 무를 뜻함.
	String str3 = null;
	String str4 = "";
	
	System.out.println("str3:"+str3);
	System.out.println("str4:"+str4);
	
	int num;
	num=10+20;
	System.out.println("NUM:"+num);
	
	}
}
