/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오후 12:24:40
 * Modified: 2016년 2월 1일 월요일 오후 12:24:40
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
		
		b1 = new Button("첫번쨰 버튼");
		b2 = new Button("두번쨰 버튼");
		b3 = new Button("세번쨰 버튼");
		b4 = new Button("네번쨰 버튼");
		b5 = new Button("다섯번쨰 버튼");
		
		this.setLayout(new FlowLayout());
		//컨테이너.add(컴포넌트);
		this.add(b1); //컨테이너에 컴포넌트 붙이기.
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
