/*
 * Author: Administrator
 * Created: 2016년 2월 2일 화요일 오후 12:37:56
 * Modified: 2016년 2월 2일 화요일 오후 12:37:56
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Test11_List_event extends Frame implements ItemListener, ActionListener
{
	//vari
	List list1, list2;
	TextArea ta1, ta2;
	TextField tf;
	Button b1,b2,b3,b4,b5;
	
	//cons
	public Test11_List_event(){
		super("");
		this.setFont(new Font("Dialog", Font.BOLD,16));
		
		setDesign(); //메서드 호출.
		
		setVisible(true);
		setBounds(200,200,400,350);
		
		//이벤트 등록.
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		list1.addActionListener(this);
		list2.addActionListener(this);
		
		addWindowListener(new MyWin());
		
    
      
	}//con end
	
	public void setDesign(){
		
		list1 = new List(10, true); // true 다중선택,/ 10개는 보여지게 하고, 
		list1.add("삼성전자"); //list 에 항목 추가.
		list1.add("abc 마트");
		list1.add("삼성전기");
		list1.add("모비스");
		list1.add("컴투스");
		list1.add("메가스터디");
		list1.add("블루투스");
		list1.add("한미약품");
		list1.add("광동제약");
		
		Panel p1 = new Panel(new BorderLayout());
		p1.add(list1);
		
		list2= new List(10, true);
		Panel p2 = new Panel(new BorderLayout());
		p2.add(list2);
		
		b1=new Button(">");
		b2=new Button(">>");
		b3=new Button("<");
		b4=new Button("<<");
		b5=new Button("삭제");	
		
		Panel p3 = new Panel(new GridLayout(5,10,10,5));
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		
		//
		tf=new TextField(20); // 20글자
		Panel p4= new Panel(new FlowLayout(FlowLayout.RIGHT));
		p4.setBackground(Color.orange);
      p4.add(new Label("추가",Label.LEFT));
		p4.add(tf);
		//
		
		Panel p= new Panel(new FlowLayout());
		p.setBackground(Color.yellow);
      p.add(p1);
		p.add(p3);
		p.add(p2);
		//
		
		this.add("Center", p );
		this.add("South", p4);
		
	}//setDesign end
	
	
	//overriding
	public void itemStateChanged(ItemEvent ie){}
	
	public void actionPerformed(ActionEvent ae){
		Object ob = ae.getSource();
		String str="";
		if(ob == tf)	
		{
			if(tf.getText().equals(""))//아무내용도 없을때.
			{
				JOptionPane.showMessageDialog(this, "추가할 내용을 입력하시오.");
				tf.requestFocus();
				return; // 더이상 수행 안되게 명령.
			}//inner if end
			
			//중복 체크.
			for(int i=0;i<list1.getItemCount(); i++)
			{
				if(list1.getItem(i).equals(tf.getText()))
				{
					JOptionPane.showMessageDialog(this, "List1에 이미 존재합니다.");
					tf.setText("");
					return; //이전 상태로 되돌아감.
				}//if end 
				
			}//for end
			for(int i=0;i<list2.getItemCount(); i++)
			{
				if(list2.getItem(i).equals(tf.getText()))
				{
					JOptionPane.showMessageDialog(this, "List2에 이미 존재합니다.");
					tf.setText("");
					return; //이전 상태로 되돌아감.
				}//if end 
				
			}//for end
			
			//항목 추가.
			list1.add(tf.getText().trim());
			tf.setText("");
			tf.requestFocus();
			
		}//if1 end
		
		if(ob==b1)
		{//선택한 자료를 list2 로 옴기기.
	
			String items[]=list1.getSelectedItems();
			for(int i = 0;i<items.length;i++)
			{
				list2.add(items[i]);
				list1.remove(items[i]);
			}//for end
		}//if2 end
		
		
		if(ob==b3)
		{//선택한 자료를 list1로 옴기기.
			
			String items[]=list2.getSelectedItems();
			for(int i = 0;i<items.length;i++)
			{
				list1.add(items[i]);
				list2.remove(items[i]);
			}//for end
		}//if3 end
		
		
		if(ob==b2)
		{//모든 자료를 list2로 옴기기.
			String items[]=list1.getItems();
			for(int i = 0;i<items.length;i++)
			{
				list2.add(items[i]);
			}//for end
			list1.removeAll();
		}//if4 end
		
		if(ob==b4)
		{//모든 자료를 list2로 옴기기.
			String items[]=list2.getItems();
			for(int i = 0;i<items.length;i++)
			{
				list1.add(items[i]);
			}//for end
			list2.removeAll();
		}//if5 end
		
		//더블 클릭 할때 반응하게 설계.
		if(ob == list1)
		{
			str = ae.getActionCommand();
			list1.remove(str);
			list2.add(str);
		}
		if(ob == list2)
		{
			str = ae.getActionCommand();
			list2.remove(str);
			list1.add(str);
		}
	
		
		
	}//list를 더블 클릭 할때 실행 되는 메서드.
	
	//inner
	public class MyWin extends WindowAdapter{
		
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
		
	}//inner end
	
	//method
	public static void main( String [] args ) 
	{
		new Test11_List_event();
	}// end main
	
}//class end
