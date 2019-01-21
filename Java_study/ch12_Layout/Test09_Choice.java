/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오전 11:10:48
 * Modified: 2016년 2월 2일 화요일 오전 11:10:48
 */

import java.awt.*;
import java.awt.event.*;

class Test09_Choice extends Frame implements ItemListener
{
	//vari
	
	Choice ch;
	Label label= new Label("과일", Label.CENTER);
	
	
	//cons
	public Test09_Choice(){
		super("123");
		ch = new Choice();
		ch.addItem("포도");
		ch.addItem("사과");
		ch.addItem("수박");

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
	
		//String str = (String)ch.getSelectedItem();//선택한 아이템을 String으로 저장.
		
		String str = ch.getSelectedItem();//선택한 아이템을 String으로 저장.
				
		if(str.equals("사과"))
		{
			label.setBackground(Color.pink);
		}else if(str.equals("포도"))
		{
			label.setBackground(Color.magenta);
		}else if(str.equals("수박"))
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
