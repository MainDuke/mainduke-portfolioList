/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오전 11:42:12
 * Modified: 2016년 2월 1일 월요일 오전 11:42:12
 */

import java.awt.*;
import java.awt.event.*;

class Test11_key extends Frame implements KeyListener
{
	
	//vari
	int x=100, y=100;
	Image im;
	
	//constructor
	public Test11_key(){
		super("1234");
		
		im=Toolkit.getDefaultToolkit().getImage("abc.gif"); //그림얻기.
		
		//this.setBounds(200,200,500,500);
		//super.setVisible(true); 써도 상관없음.
		
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		addKeyListener(this);
		
	}
	//inner class
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);
		
		}
	}
	
	//오버 라이딩.
	public void keyPressed(KeyEvent k){
		switch(k.getKeyCode()){
			case KeyEvent.VK_UP: y-=5; break;
			case KeyEvent.VK_DOWN: y+=5; break;
			case KeyEvent.VK_LEFT : x-=5; break;
			case KeyEvent.VK_RIGHT : x+=5; break;
		}//switch end
		repaint(); //update()==>clearRect() ==> paint() : JVM이 호출.
	}//keyPressed() end.
	public void keyTyped(KeyEvent k){}
	public void keyReleased(KeyEvent k){}
	
	public void paint(Graphics g){
	g.drawImage(im, x, y, this); //이미지 출력.
	
	}
	
	
	public static void main(String args[]){
		new Test11_key();
	}
	
}//class end
