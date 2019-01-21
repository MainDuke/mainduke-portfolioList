/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오후 4:19:12
 * Modified: 2016년 2월 2일 화요일 오후 4:19:12
 */
import java.awt.*;
import java.awt.event.*;

class Test12_TextField extends Frame implements ActionListener, TextListener
{
	//vari
	TextField tf;
	TextArea ta;
	
	//cons
	public  Test12_TextField(){
		super("111");
	
		tf= new TextField(20);
		ta= new TextArea(10, 20);
		
		this.add(tf,"North");
		this.add(ta,"Center");
		
		tf.addTextListener(this);
		tf.addActionListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);
		
	}
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}
	
		//over
		public void actionPerformed(ActionEvent e){
			
              tf.setText("");
         }
		
		public void textValueChanged(TextEvent te){
			ta.append("TextEvent : "+tf.getText()+"\n");
		
		}
	public static void main( String [] args )	
	{
		new Test12_TextField();
	}// end main

}//class end
