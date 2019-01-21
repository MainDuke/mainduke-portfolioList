package ch11_awt;

import java.awt.*;
import java.awt.event.*;

public class Test03_Window extends Frame{

	//cons 
	public Test03_Window(){
		
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
		//무명 클래스
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		}//cons end
	public static void main(String[] args) {
		new Test03_Window();
	}//main end
	
}//class end
