/*
 * Author: Administrator
 * Created: 2016�� 1�� 29�� �ݿ��� ���� 10:51:18
 * Modified: 2016�� 1�� 29�� �ݿ��� ���� 10:51:18
 */

import java.awt.*;
import java.awt.event.*;

class Test03_Window extends Frame
{
	//vari
	
	//cons , cons �ȿ� ���� inner Ŭ������ ���� ����.
	public Test03_Window(){
		super("â����3");
		setBounds(200, 200, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{//���� inner Ŭ����.
			public void windowClosing(WindowEvent w){
			System.exit(0);
		}
		}
		);
	}//cos end
	
	//method
	public static void main( String [] args ) 
	{
		new Test03_Window();
	}// end main
}
