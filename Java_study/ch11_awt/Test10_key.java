import java.awt.*;
import java.awt.event.*;


class Test10_key extends Frame implements KeyListener
{
	public Test10_key(){
		super("key");
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		addKeyListener(this); //이벤트 등록.
		
	}
	
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);
		}
	}
	
	public void keyPressed(KeyEvent k){
	//Graphics 는 추상 메서드라서 new를 쓰지 않는다.
		Graphics g =getGraphics();
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.clearRect(0,0,500,500); //창을 흰색으로 지우려고.
		g.setColor(Color.blue);
		g.drawString("방금 누른 키 code : "+k.getKeyCode(), 30,50);
		g.drawString("방금 입력한 문자 : "+k.getKeyChar(),30,80);
	}
	public void keyReleased(KeyEvent k){}
	
	public void keyTyped(KeyEvent k){//아스키 코드값을.
		Graphics g= getGraphics();
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.setColor(Color.magenta);

		
	g.drawString("방금 누른 아스키 코드 값 : "+(int)k.getKeyChar(), 30,110 );
		
		g.drawString("방금 누른 아스키 문자 : "+k.getKeyChar(), 30, 140 );
	}
	
	
	public static void main(String args[]){
		new Test10_key();
	}
	
}//class end
