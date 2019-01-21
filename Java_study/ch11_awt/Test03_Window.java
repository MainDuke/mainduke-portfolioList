/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오전 10:51:18
 * Modified: 2016년 1월 29일 금요일 오전 10:51:18
 */

import java.awt.*;
import java.awt.event.*;

class Test03_Window extends Frame
{
	//vari
	
	//cons , cons 안에 무명 inner 클래스를 넣을 것임.
	public Test03_Window(){
		super("창종료3");
		setBounds(200, 200, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{//무명 inner 클래스.
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
