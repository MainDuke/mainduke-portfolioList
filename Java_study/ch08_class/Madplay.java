/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 5:39:14
 * Modified: 2016�� 1�� 27�� ������ ���� 5:39:14
 */
public class ���屹{
	public void �����߱�(){
		System.out.println("�ұ�ġ��");
}
}
class ���ٱ����屹 extends ���屹{
	public void �����߱�(){
		System.out.println("���ٱ����屹���� �������");
	}
	public void ���߰��ϱ�(){
	System.out.println("���߰�!");
	}
}
class �ᳪ�����屹 extends ���屹{
	public void �����߱�(){
		System.out.println("�ᳪ�����屹���� ���߰���");
	}
	public void �ᳪ���ֱ�(){
		System.out.println("�ᳪ��");
	}
}//class

class �밴{
	public void ���屹�Ա�(���屹 �������屹){
		�������屹.�����߱�();
	}
}

class Madplay{
	public static void main( String [] args ) 
	{
		�밴 �밴�ѻ�� = new �밴();
		���屹 ���屹�ѱ׸� = new ���ٱ����屹();
		�밴�ѻ��.���屹�Ա�(���屹�ѱ׸�);
	}// end main

}//class end
