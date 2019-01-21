/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오전 10:24:10
 * Modified: 2016년 2월 2일 화요일 오전 10:24:10
 */

import java.awt.*;
import java.awt.event.*;

class Test08_radio extends Frame implements ItemListener
{
	
	//vari
	Checkbox apple, orange, banana, grape;
	CheckboxGroup group;
	Label la1, la2, la3;
	Panel p1, p2;
	
	
	//cons
	public Test08_radio(){
		super("1111");
		
		group = new CheckboxGroup(); //그룹 객체 생성.
		apple = new Checkbox("사과", group, true);//null(그룹이름), true(선택)
		banana = new Checkbox("바나나", group, false);
		orange = new Checkbox("오렌지", group, false);
		grape = new Checkbox("포도", group, false);
	
		
		p1= new Panel();
		p2 = new Panel();
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.cyan);
		
		la1=new Label("항복을 선택하시오");	
		la2=new Label("선택한 항목은 다음과 같습니다.");
		la3=new Label(" 1             ");
		
		p1.setLayout(new GridLayout(5,0));
		p1.add(la1); //p1에 la1 붙이기.
		p1.add(apple); //p1에 apple 붙이기.
		p1.add(banana);//p1에 banana
		p1.add(orange);//p1에 orange
		p1.add(grape);//p1에 grape
		
		
		p2.add(la2);
		p2.add(la3);

		//
		this.add(p1,"North");
		this.add(p2,"Center");
		
		apple.addItemListener(this);
		banana.addItemListener(this);
		orange.addItemListener(this);
		grape.addItemListener(this);
		
		
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,500,500);
	}//cons
	
	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
			
		}
	}//inner end

	
	//overriding
	public void itemStateChanged(ItemEvent ie){
	la3.setText(group.getSelectedCheckbox().getLabel());
	//group.getSelectedCheckbox().getLabel()
	}
	
	public static void main(String args[]){
		new Test08_radio();
	}

}//class end
