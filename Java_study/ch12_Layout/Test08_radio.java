/*
 * Author: Administrator
 * Created: 2016�� 2�� 2�� ȭ���� ���� 10:24:10
 * Modified: 2016�� 2�� 2�� ȭ���� ���� 10:24:10
 */

import java.awt.*;
import java.awt.event.*;

class Test08_radio extends Frame implements ItemListener
{
	
	//vari
	Checkbox apple, orange, banana, grape;
	CheckboxGroup group;
	Label la1, la2, la3;
	Panel p1, p2;
	
	
	//cons
	public Test08_radio(){
		super("1111");
		
		group = new CheckboxGroup(); //�׷� ��ü ����.
		apple = new Checkbox("���", group, true);//null(�׷��̸�), true(����)
		banana = new Checkbox("�ٳ���", group, false);
		orange = new Checkbox("������", group, false);
		grape = new Checkbox("����", group, false);
	
		
		p1= new Panel();
		p2 = new Panel();
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.cyan);
		
		la1=new Label("�׺��� �����Ͻÿ�");	
		la2=new Label("������ �׸��� ������ �����ϴ�.");
		la3=new Label(" 1             ");
		
		p1.setLayout(new GridLayout(5,0));
		p1.add(la1); //p1�� la1 ���̱�.
		p1.add(apple); //p1�� apple ���̱�.
		p1.add(banana);//p1�� banana
		p1.add(orange);//p1�� orange
		p1.add(grape);//p1�� grape
		
		
		p2.add(la2);
		p2.add(la3);

		//
		this.add(p1,"North");
		this.add(p2,"Center");
		
		apple.addItemListener(this);
		banana.addItemListener(this);
		orange.addItemListener(this);
		grape.addItemListener(this);
		
		
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);
	}//cons
	
	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
			
		}
	}//inner end

	
	//overriding
	public void itemStateChanged(ItemEvent ie){
	la3.setText(group.getSelectedCheckbox().getLabel());
	//group.getSelectedCheckbox().getLabel()
	}
	
	public static void main(String args[]){
		new Test08_radio();
	}

}//class end
