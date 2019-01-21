/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오후 3:18:48
 * Modified: 2016년 2월 1일 월요일 오후 3:18:48
 */

import java.awt.*;
import java.awt.event.*;

class Test05_event extends Frame implements ActionListener
{
	//vari
	Button b1, b2 ,b3,b4,b5;
	
	TextField tf1,tf2;
	TextArea ta;
	
	//cons
	public Test05_event(){
		super("!!@##");
		
		tf1=new TextField();
		tf2=new TextField();
		ta= new TextArea(0,0);
		ta.setEditable(false);
		
		setLayout(new BorderLayout());
		this.add(tf1,"North"); //컨테이너에 컴포넌트 붙이기. //문자열 철글자는 대문자로!
		this.add(tf2,"South");
		this.add(ta,"Center");
				
		tf1.setBackground(Color.yellow);		
		tf2.setBackground(Color.magenta);		
		ta.setBackground(Color.cyan);		
		
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);
		
		tf1.addActionListener(this);
		tf2.addActionListener(this);
	}//cons end

	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner end

	
	//overiding
	public void actionPerformed(ActionEvent e){
			if(e.getSource() == tf1){
				String str=tf1.getText().trim();
				if(!str.equals("")){
				String msg= "손오공 말>>"+tf1.getText();
				tf1.setText("");// 클리어.
				ta.append(msg+"\n");
				tf2.requestFocus();//tf2 포커스 초점 이동.
				}
				}else if(e.getSource() == tf2){
					String str2=tf2.getText().trim();
						if(!str2.equals("")){
						String msg= "저팔계 말>>"+tf2.getText();
						tf2.setText("");// 클리어.
						ta.append(msg+"\n");
						tf1.requestFocus();//tf2 포커스 초점 이동.
						}
					}
		
	}
	public static void main( String [] args ) 
	{
		new Test05_event();
	}// end main
}
