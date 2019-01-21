import java.awt.*;
import java.awt.event.*;

//MouseMotionListener 사용.
//1. 상속을 받는다.
//2. 이벤트 등록을 한다.
//3. 해당 메서드 오버라이딩 한다.
//마우스 이벤트 처리를 하려면?

class Test07_Mouse extends Frame implements MouseMotionListener
{
	//변수
	//int xpos,ypos;
	Point point=new Point(0,0); //마우스 좌표 처리.
	//color
	Color cols[]={Color.blue,Color.red,Color.green,Color.magenta,Color.cyan};
	
	//생성자
	public Test07_Mouse(){
	super("마우스 이벤트.");
	addWindowListener(new MyWin());
	setBounds(200,200,500,500);
	setVisible(true); //창 표시!
	addMouseMotionListener(this);
	}//cons end
	
	//오버라이딩.
	public void mouseDragged(MouseEvent m){
		point=m.getPoint();
		repaint(); //cleaRect()-->update()-->paint()
	}
	public void mouseMoved(MouseEvent m){
		}
	
	public void update(Graphics g){
		g.setColor(cols[(int)(Math.random()*cols.length)]);
		paint(g);
	}
	
	//paint()
	public void paint(Graphics g){
	g.drawOval(point.x,point.y,20,20);
	}
	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);
		}
	}//inner end
 	
	//메서드
	public static void main( String [] args )
	{
		new Test07_Mouse();
	}// end main

}//clss end
