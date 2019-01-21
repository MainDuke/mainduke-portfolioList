/*
 * Author: Administrator
 * Created: 2016�� 1�� 29�� �ݿ��� ���� 2:18:55
 * Modified: 2016�� 1�� 29�� �ݿ��� ���� 2:18:55
 */
import java.awt.*;
import java.awt.event.*;

//�������̽��� �޼���� ��� �������̵� ������Ѵ�!!!
//���� Ŭ������ �޼���� �������̵� �� �ʿ�.
class Test06_Mouse extends Frame implements MouseListener, MouseMotionListener
{
	//����
	private int xpos, ypos;
	private String msg;
	//������
	public Test06_Mouse(){  //�����ڿ��� �̺�Ʈ�� ���������Ѵ�.
		super("���콺 �̺�Ʈ");
		addWindowListener(new MyWin()); //������ �̺�Ʈ ���.
		setBounds(500,350,400,500);
		setVisible(true);
		addMouseListener(this);//�̺�Ʈ ���.
		addMouseMotionListener(this); //�̺�Ʈ ���.
	}//cons end
	
	//inneerclass
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//MyWin end

	//�������̵�. Mouse�������̽� 7���� ���� �������̵�. 
	public void mousePressed(MouseEvent m){
	setVal("mousePressed",m.getX(),m.getY());}//�޼��� ȣ��.}//Mouse
	

	public void mouseClicked(MouseEvent m){
      System.out.println("trd");
	setVal("mouseClicked",m.getX(),m.getY());}//Mouse
	public void mouseReleased(MouseEvent m){
	setVal("mouseReleased",m.getX(),m.getY());
			
			}//Mouse
	
	public void mouseEntered(MouseEvent m){
	System.out.println("���콺Ŀ���� â������ ���Խ��ϴ�.");
	}//Mouse
	public void mouseExited(MouseEvent m){
	System.out.println("���콺 Ŀ���� â ������ �������ϴ�.");
	
	}//
	
	
	public void mouseDragged(MouseEvent m){//
	setVal("mouseReleased",m.getX(),m.getY());}//MouseMotion
	public void mouseMoved(MouseEvent m){
	setVal("mouseReleased",m.getX(),m.getY());}//MouseMotion
	
	//����� ���� �޼���.
	private void setVal(String msg, int x, int y){
		this.xpos=x;
		this.ypos=y;
		this.msg=msg;
		repaint(); //�ٽ� �׸���, paint()�޼��� ȣ��.
	}
	//paint �޼���
	public void paint(Graphics g){
		g.drawString(msg+" @["+xpos+","+ypos+"]", xpos, ypos);
	}
	
	//�޼���
	public static void main( String [] args ) 
	{
		new Test06_Mouse();
	}// end main
	


}//class end
