package ch11_awt;

import java.awt.*;
import java.awt.event.*;

public class Test02_Window extends Frame {

	//cons
	public Test02_Window(){
		setSize(300,300);
		setVisible(true);
		addWindowListener(new MyWin()); //�̺�Ʈ ���
	}//cons  end
	
	class MyWin extends WindowAdapter {
		// TODO Auto-generated constructor stub
	public void windowClosing(WindowEvent we){
		
		System.exit(0);
	}
	}//end mywin
	
	public static void main(String[] args) {
		new Test02_Window();
		//�����ϰ� ����.
	}
	
}//class
