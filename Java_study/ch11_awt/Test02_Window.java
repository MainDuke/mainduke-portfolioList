/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오전 10:37:01
 * Modified: 2016년 1월 29일 금요일 오전 10:37:01
 */

//inner 클래스 사용.

import java.awt.*;
import java.awt.event.*;

class Test02_Window extends Frame
{
	//변수
	//생성자
	public Test02_Window(){
		super("창종료2");
		addWindowListener(new MyWin()); //이벤트 종료.
		setBounds(200, 200, 300, 300); // x/y/w/h 
		setVisible(true); //창표시.
	}//cons end
	
	//inner class
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}//windowclosing end
	}//end Mywin
	//메서드
	public static void main(String args[]){
		new Test02_Window();
	}
		

}
