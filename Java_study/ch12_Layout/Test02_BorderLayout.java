/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오후 12:45:11
 * Modified: 2016년 2월 1일 월요일 오후 12:45:11
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
		
		b1 = new Button("첫번쨰 버튼");
		b2 = new Button("두번쨰 버튼");
		b3 = new Button("세번쨰 버튼");
		b4 = new Button("네번쨰 버튼");
		b5 = new Button("다섯번쨰 버튼");
		
		setLayout(new BorderLayout());
		this.add(b1,"North"); //컨테이너에 컴포넌트 붙이기. //문자열 철글자는 대문자로!
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
