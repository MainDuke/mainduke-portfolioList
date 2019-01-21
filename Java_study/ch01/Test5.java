class Test5
{
	public static void main(String args[])
	{
		System.out.println("인수 갯수 :"+args.length);
		System.out.println("args[0]:"+args[0]);
		System.out.println("args[1]:"+args[1]);
		System.out.println("args[2]:"+args[2]);
	}//main end

}//class end

//명령줄 인수 
//java응용프로그램에는 main()이라는 정적메서드가 포함된다
//이메서드는 String 객체배열인 인수하나를 갖는다
//이 인수의 객체들은 사용자가 며령줄에 입력할 수 있는
// 모든 인수를 표현할 수 있다 

// 명령줄 인수 갯수는 int형이고 (식: args.length)통해서 
// 구한다 
//인수는 args[0], args[1], args[2]...등으로 엑세스 된다 

/*
C:\01_java>javac Test5.java

C:\01_java>java Test5 kim lee park
인수 갯수 :3
args[0]:kim
args[1]:lee
args[2]:park

*/