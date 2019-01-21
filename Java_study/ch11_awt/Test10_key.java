import java.awt.*;
import java.awt.event.*;


class Test10_key extends Frame implements KeyListener
{
	public Test10_key(){
		super("key");
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		addKeyListener(this); //�̺�Ʈ ���.
		
	}
	
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);
		}
	}
	
	public void keyPressed(KeyEvent k){
	//Graphics �� �߻� �޼���� new�� ���� �ʴ´�.
		Graphics g =getGraphics();
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.clearRect(0,0,500,500); //â�� ������� �������.
		g.setColor(Color.blue);
		g.drawString("��� ���� Ű code : "+k.getKeyCode(), 30,50);
		g.drawString("��� �Է��� ���� : "+k.getKeyChar(),30,80);
	}
	public void keyReleased(KeyEvent k){}
	
	public void keyTyped(KeyEvent k){//�ƽ�Ű �ڵ尪��.
		Graphics g= getGraphics();
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.setColor(Color.magenta);

		
	g.drawString("��� ���� �ƽ�Ű �ڵ� �� : "+(int)k.getKeyChar(), 30,110 );
		
		g.drawString("��� ���� �ƽ�Ű ���� : "+k.getKeyChar(), 30, 140 );
	}
	
	
	public static void main(String args[]){
		new Test10_key();
	}
	
}//class end
