/*
 * Author: Administrator
 * Created: 2016�� 1�� 29�� �ݿ��� ���� 10:37:01
 * Modified: 2016�� 1�� 29�� �ݿ��� ���� 10:37:01
 */

//inner Ŭ���� ���.

import java.awt.*;
import java.awt.event.*;

class Test02_Window extends Frame
{
	//����
	//������
	public Test02_Window(){
		super("â����2");
		addWindowListener(new MyWin()); //�̺�Ʈ ����.
		setBounds(200, 200, 300, 300); // x/y/w/h 
		setVisible(true); //âǥ��.
	}//cons end
	
	//inner class
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}//windowclosing end
	}//end Mywin
	//�޼���
	public static void main(String args[]){
		new Test02_Window();
	}
		

}
