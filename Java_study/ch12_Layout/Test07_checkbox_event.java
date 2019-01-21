/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오전 9:24:00
 * Modified: 2016년 2월 2일 화요일 오전 9:24:00
 */

import java.awt.*;
import java.awt.event.*;


class Test07_checkbox_event extends Frame implements ItemListener
{
	
	//vari
	Checkbox apple, banana,orange, grape;
	Panel panel;
	TextArea ta;
	
	//cons 
	public Test07_checkbox_event(){
		super("11");
		
		apple = new Checkbox("사과", null, true);//null(그룹이름), true(선택)
		banana = new Checkbox("바나나");
		orange = new Checkbox("오렌지");
		grape = new Checkbox("포도");
		panel = new Panel();
		ta = new TextArea();
		
		//
		panel.add(apple);
		panel.add(banana);
		panel.add(orange);
		panel.add(grape);
		
		//
		this.add(panel, "North");
		this.add(ta, "Center");
		
		//
		apple.addItemListener(this);
		banana.addItemListener(this);
		orange.addItemListener(this);
		grape.addItemListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);		
		
		
	
	}//cons end

	//inner class
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}
	//overriding
	public void itemStateChanged(ItemEvent ie){
	
		System.out.println("TESTSTETSET");
		
		Checkbox cb=(Checkbox)ie.getSource();
		if(cb.equals(apple)){
			if(cb.getState())//체크박스의 상태가 True 이면.
			{
				ta.append("사과 선택\n");
			}else{
				ta.append("사과 선택해제\n");
			}
		}else if(cb.equals(banana)){
			if(cb.getState())//체크박스의 상태가 True 이면.
			{
				ta.append("바나나 선택\n");
			}else{
				ta.append("바나나 선택해제\n");
			}
		}else if(cb.equals(grape)){
			if(cb.getState())//체크박스의 상태가 True 이면.
			{
				ta.append("포도 선택\n");
			}else{
				ta.append("포도 선택해제\n");
			}
		}else if(cb.equals(orange)){
			if(cb.getState())//체크박스의 상태가 True 이면.
			{
				ta.append("오렌지 선택\n");
			}else{
				ta.append("오렌지 선택해제.\n");
			}
		}//ifend
	}//itemStateChanged end
		
	//main method
	public static void main( String [] args )
	{
		new Test07_checkbox_event();
	}// end main
	
}//class end
