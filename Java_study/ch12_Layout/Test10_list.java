/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오전 11:43:33
 * Modified: 2016년 2월 2일 화요일 오전 11:43:33
 */

import java.awt.*;
import java.awt.event.*;

class Test10_list extends Frame implements ItemListener , ActionListener
{
	//vair
	
	TextArea ta1, ta2;
	List list;
	Label label;
	
	//cons
	public Test10_list(){
		super("aaa");
	
		this.setBackground(Color.yellow);
			
		label = new Label("리스트박스");
		list = new List(3); //항목을 3개식 보여주기.
		list.add("이름"); //list에 항목 추가.
		list.add("국어"); 
		list.add("영어"); 
		list.add("수학"); 
		list.add("과학");
		
		ta1=new TextArea("", 7 , 30, TextArea.SCROLLBARS_VERTICAL_ONLY); //수직 스크롤
		ta2=new TextArea("", 7 , 30, TextArea.SCROLLBARS_HORIZONTAL_ONLY); //수평 스크롤.
		
		list.addActionListener(this);
		list.addItemListener(this);
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,300,400);
	
		
		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(list);
		this.add(ta1);
		this.add(ta2);
	
	}//cons end

	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
			
		}
	}//inner end
	
	//overRiding
	public void itemStateChanged(ItemEvent ie){
	ta1.append("Item Event 발생 : "+list.getSelectedItem()+"\n");
}//list를 클릭할때!
	
	
	public void actionPerformed(ActionEvent ae){
	ta2.append("Action Event 발생 : "+ae.getActionCommand()+"\n");
	}//list를 더블 클릭 할때 실행 되는 메서드.
	
	//main
	public static void main( String [] args ) 
	{
		new Test10_list();
	}// end main


}//class end

