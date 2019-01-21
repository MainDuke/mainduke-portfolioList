/*
 * Author: Administrator
 * Created: 2016�� 2�� 1�� ������ ���� 11:42:12
 * Modified: 2016�� 2�� 1�� ������ ���� 11:42:12
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
		
		im=Toolkit.getDefaultToolkit().getImage("abc.gif"); //�׸����.
		
		//this.setBounds(200,200,500,500);
		//super.setVisible(true); �ᵵ �������.
		
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
	
	//���� ���̵�.
	public void keyPressed(KeyEvent k){
		switch(k.getKeyCode()){
			case KeyEvent.VK_UP: y-=5; break;
			case KeyEvent.VK_DOWN: y+=5; break;
			case KeyEvent.VK_LEFT : x-=5; break;
			case KeyEvent.VK_RIGHT : x+=5; break;
		}//switch end
		repaint(); //update()==>clearRect() ==> paint() : JVM�� ȣ��.
	}//keyPressed() end.
	public void keyTyped(KeyEvent k){}
	public void keyReleased(KeyEvent k){}
	
	public void paint(Graphics g){
	g.drawImage(im, x, y, this); //�̹��� ���.
	
	}
	
	
	public static void main(String args[]){
		new Test11_key();
	}
	
}//class end
