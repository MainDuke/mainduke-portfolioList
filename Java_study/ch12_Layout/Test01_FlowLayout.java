/*
 * Author: Administrator
 * Created: 2016�� 2�� 1�� ������ ���� 12:24:40
 * Modified: 2016�� 2�� 1�� ������ ���� 12:24:40
 */
import java.awt.*;
import java.awt.event.*;


class Test01_FlowLayout	extends Frame
{
	//vari
	Button b1, b2 ,b3,b4,b5;
	
	//construction
	public Test01_FlowLayout(){
		super("11");
		
		b1 = new Button("ù���� ��ư");
		b2 = new Button("�ι��� ��ư");
		b3 = new Button("������ ��ư");
		b4 = new Button("�׹��� ��ư");
		b5 = new Button("�ټ����� ��ư");
		
		this.setLayout(new FlowLayout());
		//�����̳�.add(������Ʈ);
		this.add(b1); //�����̳ʿ� ������Ʈ ���̱�.
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		}
	
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}
	public static void main(String args[]){
	
		new Test01_FlowLayout();
	}//end main
	
	
	
}//class end
