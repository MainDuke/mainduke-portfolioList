/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 5:09:31
 * Modified: 2016�� 1�� 28�� ����� ���� 5:09:31
 */
import hong.kil.dong.*;

class Test04_package
{
	//���� ����
	CalcTest t1;
	CalcTest2 t2;			
	//������
	public Test04_package(){
	t1 = new CalcTest();
	t2 = new CalcTest2();	
	
	t1.hab(3, 5);
	t2.cha(7, 5);
	}
	//
	
	public static void main( String [] args ) 
	{
		new Test04_package();
		
	}// end main

}//class end
