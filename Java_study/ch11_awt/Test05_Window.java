/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오후 12:37:13
 * Modified: 2016년 1월 29일 금요일 오후 12:37:13
 */

import java.awt.*;
import java.awt.event.*;

class Test05_Window extends Frame
{
	//변수
	//생성자.
	Image im;
	
	public Test05_Window(){
		super("그림 출력.");
		
		im = Toolkit.getDefaultToolkit().getImage("test.jpg");	
		addWindowListener(new MyWin());	
		setBounds(200,200,1000,1000);
		setVisible(true);
	}
		
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}
	
	public void paint(Graphics g){
		
		g.drawImage(im, 30, 50, this);
		g.drawRect(30, 50, 350,300);
		}
	public static void main( String [] args )
	{
		new Test05_Window();
	}// end main

}
