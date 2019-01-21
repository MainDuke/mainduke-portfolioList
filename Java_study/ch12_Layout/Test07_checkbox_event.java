/*
 * Author: Administrator
 * Created: 2016�� 2�� 2�� ȭ���� ���� 9:24:00
 * Modified: 2016�� 2�� 2�� ȭ���� ���� 9:24:00
 */

import java.awt.*;
import java.awt.event.*;


class Test07_checkbox_event extends Frame implements ItemListener
{
	
	//vari
	Checkbox apple, banana,orange, grape;
	Panel panel;
	TextArea ta;
	
	//cons 
	public Test07_checkbox_event(){
		super("11");
		
		apple = new Checkbox("���", null, true);//null(�׷��̸�), true(����)
		banana = new Checkbox("�ٳ���");
		orange = new Checkbox("������");
		grape = new Checkbox("����");
		panel = new Panel();
		ta = new TextArea();
		
		//
		panel.add(apple);
		panel.add(banana);
		panel.add(orange);
		panel.add(grape);
		
		//
		this.add(panel, "North");
		this.add(ta, "Center");
		
		//
		apple.addItemListener(this);
		banana.addItemListener(this);
		orange.addItemListener(this);
		grape.addItemListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);		
		
		
	
	}//cons end

	//inner class
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}
	//overriding
	public void itemStateChanged(ItemEvent ie){
	
		System.out.println("TESTSTETSET");
		
		Checkbox cb=(Checkbox)ie.getSource();
		if(cb.equals(apple)){
			if(cb.getState())//üũ�ڽ��� ���°� True �̸�.
			{
				ta.append("��� ����\n");
			}else{
				ta.append("��� ��������\n");
			}
		}else if(cb.equals(banana)){
			if(cb.getState())//üũ�ڽ��� ���°� True �̸�.
			{
				ta.append("�ٳ��� ����\n");
			}else{
				ta.append("�ٳ��� ��������\n");
			}
		}else if(cb.equals(grape)){
			if(cb.getState())//üũ�ڽ��� ���°� True �̸�.
			{
				ta.append("���� ����\n");
			}else{
				ta.append("���� ��������\n");
			}
		}else if(cb.equals(orange)){
			if(cb.getState())//üũ�ڽ��� ���°� True �̸�.
			{
				ta.append("������ ����\n");
			}else{
				ta.append("������ ��������.\n");
			}
		}//ifend
	}//itemStateChanged end
		
	//main method
	public static void main( String [] args )
	{
		new Test07_checkbox_event();
	}// end main
	
}//class end
