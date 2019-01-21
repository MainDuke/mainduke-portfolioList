import java.awt.*;
import java.awt.event.*;

//MouseMotionListener ���.
//1. ����� �޴´�.
//2. �̺�Ʈ ����� �Ѵ�.
//3. �ش� �޼��� �������̵� �Ѵ�.
//���콺 �̺�Ʈ ó���� �Ϸ���?

class Test07_Mouse extends Frame implements MouseMotionListener
{
	//����
	//int xpos,ypos;
	Point point=new Point(0,0); //���콺 ��ǥ ó��.
	//color
	Color cols[]={Color.blue,Color.red,Color.green,Color.magenta,Color.cyan};
	
	//������
	public Test07_Mouse(){
	super("���콺 �̺�Ʈ.");
	addWindowListener(new MyWin());
	setBounds(200,200,500,500);
	setVisible(true); //â ǥ��!
	addMouseMotionListener(this);
	}//cons end
	
	//�������̵�.
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
 	
	//�޼���
	public static void main( String [] args )
	{
		new Test07_Mouse();
	}// end main

}//clss end
