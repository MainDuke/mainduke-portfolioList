/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 10:50:57
 * Modified: 2016�� 1�� 28�� ����� ���� 10:50:57
 */

abstract class AA{
	abstract int aa();//�߻� �޼���.
}//aa


class BB extends AA{
	
	public int aa(){
	return 100;
	}	
}//bb

class CC extends AA{
	public int aa(){
		return 100;
	}	
}//cc

class Test06_Abs
{
	public static void main( String [] args )
	{
		System.out.println(new BB().aa());
		System.out.println(new CC().aa());
	}// end main

}
