/*
 * Author: Administrator
 * Created: 2016�� 1�� 26�� ȭ���� ���� 9:39:55
 * Modified: 2016�� 1�� 26�� ȭ���� ���� 9:39:55
 */


//super : ���� Ŭ���� ��ü�� ���Ѵ�.
//super() : ���� Ŭ���� �����ڸ� ȣ���Ѵ�.

import java.awt.*; //Frame
import java.awt.event.*; //�̺�Ʈ ó�� �Ҷ� ���. ���콺 Ŭ��.

class Test06_super extends Frame{
	//������ : ��ü �ʱ�ȭ.
	public Test06_super(){
	super("���� 1"); //���� Ŭ���� ������ ȣ��
						//ù�ٿ� �����ؾ� �ؾ��Ѵ�.
	
	setTitle("ȫ�浿 ����");
	setBackground(Color.yellow);//����.
						
	//setSize(300,300); //âũ�� 300�ȼ�.
	//setVisible(true); //â ǥ��.
	
	//this.setSize(300,300);  
	//this.setVisible(true);
	
	super.setSize(300,300);  
	super.setVisible(true);
	//������ �ȿ����� �ڱ��ڽ��� �������� �ʾƵ� �ȴ�.
	//3���� ȣ����� �� �ȴ�.
	
	}
	//JVM�� main()ȣ��.
	public static void main( String [] args ) 
	{
		new Test06_super();// ��ü ����.
		
		//t : Ŭ���� ����, �ν��Ͻ�, ��ü, ���۷���.
		
		//Test06_super t
		//int a=10;
		//�ڷ���  ����.
					
	}// end main

}//end class
