package ch11_awt;

import java.awt.*;
import java.awt.event.*;

public class Test01_Window extends Frame implements WindowListener{

	//cons
	public Test01_Window() {
		addWindowListener(this);
		setSize(300,300);//âũ��
		setVisible(true);
	}//cons end

	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Test01_Window(); //��ü ����.
	}//main end
	
}//class end
