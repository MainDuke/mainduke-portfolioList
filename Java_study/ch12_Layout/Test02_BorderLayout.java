/*
 * Author: Administrator
 * Created: 2016�� 2�� 1�� ������ ���� 12:45:11
 * Modified: 2016�� 2�� 1�� ������ ���� 12:45:11
 */

import java.awt.*;
import java.awt.event.*;

class Test02_BorderLayout extends Frame
{
	//vari
	Button b1, b2 ,b3,b4,b5;
	
	
	//cons
	public  Test02_BorderLayout(){
		super("1111");
		
		b1 = new Button("ù���� ��ư");
		b2 = new Button("�ι��� ��ư");
		b3 = new Button("������ ��ư");
		b4 = new Button("�׹��� ��ư");
		b5 = new Button("�ټ����� ��ư");
		
		setLayout(new BorderLayout());
		this.add(b1,"North"); //�����̳ʿ� ������Ʈ ���̱�. //���ڿ� ö���ڴ� �빮�ڷ�!
		this.add(b2,"South");
		this.add(b3,"Center");
		this.add(b4,"East");
		this.add(b5,"West");
		
		setBounds(200,200,500,500);
		setVisible(true);
		addWindowListener(new MyWin());
	
		
	}
	
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
			}
	}

	public static void main(String args[]){
		new  Test02_BorderLayout();
	}
}
