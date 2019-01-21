/*
 * Author: Administrator
 * Created: 2016�� 2�� 1�� ������ ���� 9:44:38
 * Modified: 2016�� 2�� 1�� ������ ���� 9:44:38
 */
import java.awt.*;
import java.awt.event.*;


/*
keyPressd(KeyEvent e) : Ű���� ��ġ���� ������ ó���Ѵ�.
A= 65 a=65
F1 ~ F12 shift ctrl ����Ű, tab Ű : ó�� ����.
����Ű ��.


keyTyped(KeyEvent e) : �ƽ�Ű �ڵ� ������ ó�� �Ѵ�.
A=65 a=97 (���ĺ�, ����)
F1 ~ F12 shift ctrl ����Ű, tab Ű : ó�� ����.

keyReleased(KeyEvent e) : Ű���忡�� ���� ��������, 
*/

class Test09_key extends Frame implements KeyListener
{
	//cons
	public Test09_key(){
		super("Ű �Է�");
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
	//�������̵�.
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
