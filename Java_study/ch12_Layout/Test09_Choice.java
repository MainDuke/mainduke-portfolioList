/*
 * Author: Administrator
 * Created: 2016�� 2�� 2�� ȭ���� ���� 11:10:48
 * Modified: 2016�� 2�� 2�� ȭ���� ���� 11:10:48
 */

import java.awt.*;
import java.awt.event.*;

class Test09_Choice extends Frame implements ItemListener
{
	//vari
	
	Choice ch;
	Label label= new Label("����", Label.CENTER);
	
	
	//cons
	public Test09_Choice(){
		super("123");
		ch = new Choice();
		ch.addItem("����");
		ch.addItem("���");
		ch.addItem("����");

		label.setForeground(Color.blue);
		label.setFont(new Font("Dialog",Font.BOLD, 150));
		
		this.add(ch, "North");
		this.add(label, "Center");
		
		ch.addItemListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);
	}//cons end

	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner end.
	
	
	//overriding
	public void itemStateChanged(ItemEvent ie){
	
		//String str = (String)ch.getSelectedItem();//������ �������� String���� ����.
		
		String str = ch.getSelectedItem();//������ �������� String���� ����.
				
		if(str.equals("���"))
		{
			label.setBackground(Color.pink);
		}else if(str.equals("����"))
		{
			label.setBackground(Color.magenta);
		}else if(str.equals("����"))
		{
			label.setBackground(Color.green);
		}
	
	}
	
	//method
	public static void main( String [] args )
	{
		new Test09_Choice();
	}// end main

	
}//class end
