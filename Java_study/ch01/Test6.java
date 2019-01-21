//명령줄 인수 
class Test6
{
	public static void main(String args[])
	{
		int a=Integer.parseInt(args[0]);//문자열을 정수로 변환
		int b=Integer.parseInt(args[1]);
		int tot=a+b;
		System.out.println("a+b="+tot);
	}//main end
}//class end 
