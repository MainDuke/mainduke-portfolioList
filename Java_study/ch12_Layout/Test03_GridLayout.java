/*
 * Author: Administrator
 * Created: 2016�� 2�� 1�� ������ ���� 2:21:21
 * Modified: 2016�� 2�� 1�� ������ ���� 2:21:21
 */

import java.awt.*;
import java.awt.event.*;

class Test03_GridLayout extends Frame
{
	//vari
	
	Button b1,b2,b3,b4,b5;
	
	//con
	public Test03_GridLayout(){
		super("12354");
		
			b1=new Button("1����");
			b2=new Button("2����");
			b3=new Button("3����");
			b4=new Button("4����");
			b5=new Button("5����");
			
			//GridLayout ����
			setLayout(new GridLayout(2,3,20,20)); // 2�� 3��.
			
			this.add(b1);
			this.add(b2);
			this.add(b3);
			this.add(b4);
			this.add(b5);
			
		addWindowListener(new MyWin());
		setBounds(200,200,500,500);
		setVisible(true);
		
	}//con end
	
	//inner
	public class MyWin extends WindowAdapter{
		
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	
	}//inner end
	
	public static void main( String [] args ) 
	{
		new Test03_GridLayout();
	}// end main
	
}//class end

