/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오후 2:42:22
 * Modified: 2016년 2월 1일 월요일 오후 2:42:22
 */

import java.awt.*;
import java.awt.event.*;

class Test04_Layout	extends Frame
{
	//vari
	Button b1,b2,b3,b4,b5;
	Panel pn,ps;
	//cons
	public Test04_Layout(){
		super("123455");
		
		
		b1 = new Button("1번 버튼");
		b2 = new Button("2번 버튼");
		b3 = new Button("3번 버튼");
		b4 = new Button("4번 버튼");
		b5 = new Button("5번 버튼");
		
		pn=new Panel();
		ps=new Panel();
		
		
		pn.setBackground(Color.yellow);
		ps.setBackground(Color.green);
		
		
		pn.add(b1);
		pn.add(b2);
		pn.add(b3);
		
		ps.add(b4);
		ps.add(b5);
		
		this.add(pn,"North");
		this.add(ps,"South");
		
		
				
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
	}//cons end
	
	//inner end
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner end
	
	public static void main(String args[]){
		new Test04_Layout();
	}
	
}
