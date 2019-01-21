/*
 * Author: Administrator
 * Created: 2016�� 1�� 29�� �ݿ��� ���� 4:28:40
 * Modified: 2016�� 1�� 29�� �ݿ��� ���� 4:28:40
 */

//MouseMotionListener ���.
//1. ����� �޴´�.
//2. �̺�Ʈ ����� �Ѵ�.
//3. �ش� �޼��� �������̵� �Ѵ�.
//���콺 �̺�Ʈ ó���� �Ϸ���?
import java.awt.*;
import java.awt.event.*;

class Test08_Mouse extends Frame
{
	//����
	//������
	public Test08_Mouse(){
		super("���콺");
		addWindowListener(new MyWin());
		addMouseListener(new MyMouse());
		setBounds(10,10,500,500);
		setVisible(true);
		
		
	}
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner1
	
	//�޼��� ������ ���� ����.
	int x,y;
	String name="";
	
	public class MyMouse extends MouseAdapter{
		public void mousePressed(MouseEvent me){//�������̵�
			if(me.getButton() == me.BUTTON1){//���ʹ�ư
				x= me.getX();
				y= me.getY();	
				name="�ڹ���";
				repaint(); //update()>clearRect()> paint()
		}else if(me.getButton()== me.BUTTON3){//�����ʹ�ư	
			x= me.getX();
			y= me.getY();	
			name="ȫ�浿.";
			repaint(); 	
			
		}else if(me.getButton() == me.BUTTON2){
				System.exit(0);
			}
		}//end
	}//inner2
	
	
	//paint
	public void paint(Graphics g){
	g.drawString(name,x,y);//���콺 ��ư�� ������ ���� ���� ���.
	}
	
	//�޼���
	public static void main( String [] args )
	{
		new Test08_Mouse();
	}// end main
	
}
