class Test5
{
	public static void main(String args[])
	{
		System.out.println("�μ� ���� :"+args.length);
		System.out.println("args[0]:"+args[0]);
		System.out.println("args[1]:"+args[1]);
		System.out.println("args[2]:"+args[2]);
	}//main end

}//class end

//����� �μ� 
//java�������α׷����� main()�̶�� �����޼��尡 ���Եȴ�
//�̸޼���� String ��ü�迭�� �μ��ϳ��� ���´�
//�� �μ��� ��ü���� ����ڰ� ����ٿ� �Է��� �� �ִ�
// ��� �μ��� ǥ���� �� �ִ� 

// ����� �μ� ������ int���̰� (��: args.length)���ؼ� 
// ���Ѵ� 
//�μ��� args[0], args[1], args[2]...������ ������ �ȴ� 

/*
C:\01_java>javac Test5.java

C:\01_java>java Test5 kim lee park
�μ� ���� :3
args[0]:kim
args[1]:lee
args[2]:park

*/