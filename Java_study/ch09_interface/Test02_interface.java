/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 9:16:54
 * Modified: 2016�� 1�� 28�� ����� ���� 9:16:54
 */

//�������̽�
//�������̽��� �������̽� ����϶��� extends
//���� ��� ����.
interface AA2{
	public void aa();
}//AA
interface BB2{
	public void bb();
}//BB

interface CC2 extends AA2, BB2{
	public char cc();
}//CC

class DD2 implements CC2
{
	public void aa(){
		System.out.println("aa()....");
	}
	public void bb(){
		System.out.println("bb()....");
	}
	public char cc(){
		System.out.println("cc()....");
		return 'A';
	}

}//DD2 end	


class Test02_interface
{
	public static void main(String args[])
	{
			DD2 d= new DD2();
			d.aa();
			d.bb();
			d.cc();
			
			
	}//main end

}//class end