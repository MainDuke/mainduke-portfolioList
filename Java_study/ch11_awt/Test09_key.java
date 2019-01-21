/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오전 9:44:38
 * Modified: 2016년 2월 1일 월요일 오전 9:44:38
 */
import java.awt.*;
import java.awt.event.*;


/*
keyPressd(KeyEvent e) : 키보드 위치상의 값으로 처리한다.
A= 65 a=65
F1 ~ F12 shift ctrl 엔터키, tab 키 : 처리 못함.
가상키 값.


keyTyped(KeyEvent e) : 아스키 코드 값으로 처리 한다.
A=65 a=97 (알파벳, 숫자)
F1 ~ F12 shift ctrl 엔터키, tab 키 : 처리 못함.

keyReleased(KeyEvent e) : 키보드에서 손을 떼었을때, 
*/

class Test09_key extends Frame implements KeyListener
{
	//cons
	public Test09_key(){
		super("키 입력");
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		addKeyListener(this);
	}
	
	//inner
	public class MyWin extends WindowAdapter{
		
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//MyWin
	
	int a=10;
		int x=0;
		int y=0;
	//오버라이딩.
	public void keyPressed(KeyEvent k){
		
		System.out.println("k.getKeyChar() :"+k.getKeyChar());
		
		System.out.println("k.getKeyCode() :"+k.getKeyCode());
		
		
		if(k.isShiftDown()){
			a+=10;
		}
		if(k.isControlDown()){
			a+=20;
		}
		
		switch(k.getKeyCode()){
		case KeyEvent.VK_UP : y-=a; break;
		case KeyEvent.VK_DOWN : y+=a; break;
		case KeyEvent.VK_LEFT : x-=a; break;
		case KeyEvent.VK_RIGHT : x+=a; break;
		case KeyEvent.VK_END : System.exit(0);
			
		}//switch end
	Graphics g =getGraphics();
	int red=(int)(Math.random()*255);
	int blue=(int)(Math.random()*255);
	int green=(int)(Math.random()*255);
	
	g.setColor(new Color(red, green, blue));
	g.fillOval(x,y,a,a);
	
	}
	
	public void keyReleased(KeyEvent k){} 
	public void keyTyped(KeyEvent k){}
	
	//main
	public static void main(String args[])
	{
		new Test09_key();
	}
	
	
}//class end
